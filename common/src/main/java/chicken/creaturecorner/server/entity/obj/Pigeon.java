package chicken.creaturecorner.server.entity.obj;


import chicken.creaturecorner.server.block.CCPoiTypes;
import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.blockentity.custom.PigeonLoftBlockEntity;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.goal.PigeonFlockFollowLeader;
import chicken.creaturecorner.server.sound.CCSounds;
import chicken.creaturecorner.util.CCTags;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.longs.LongSet;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.VisibleForDebug;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.AirRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pigeon extends AbstractCornerCreature {

    public final net.minecraft.world.entity.AnimationState idleAnimationState = new net.minecraft.world.entity.AnimationState();

    public Pigeon leader;
    private int schoolSize = 1;
    private boolean wantsToFly;

    private static final EntityDataAccessor<Integer> FLY_TICKS = SynchedEntityData.defineId(Pigeon.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(Pigeon.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> PANIC = SynchedEntityData.defineId(Pigeon.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> FLYING = SynchedEntityData.defineId(Pigeon.class, EntityDataSerializers.BOOLEAN);

    public Pigeon(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(PathType.WATER, 0);
        setFlying(false);
        this.wantsToFly = false;
    }

    public void customServerAiStep() {
        if (this.getMoveControl().hasWanted()) {
            double d0 = this.getMoveControl().getSpeedModifier();
            this.setPose(Pose.STANDING);
            this.setSprinting(d0 >= 1.1D);
        } else {
            this.setPose(Pose.STANDING);
            this.setSprinting(false);
        }

        super.customServerAiStep();
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PigeonEnterLoftGoal());

        this.goalSelector.addGoal(1, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new PigeonFlockFollowLeader(this));
        this.goalSelector.addGoal(4, new PigeonWaterAvoidingRandomStrollGoal(this, 1.0F));

        this.goToLoftGoal = new PigeonGoToLoftGoal();
        this.goalSelector.addGoal(5, this.goToLoftGoal);
        this.goalSelector.addGoal(5, new PigeonLocateLoftGoal());

        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, LivingEntity.class, 6.0F, 1, 1.5D,
                (entity) ->
                        entity instanceof Wolf || entity instanceof Ocelot || entity instanceof Cat || entity instanceof CoyoteEntity
        ));

        this.goalSelector.addGoal(2, new BreedGoal(this, 1, Pigeon.class));
        this.goalSelector.addGoal(8, new PigeonFlyGoal());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    class PigeonWaterAvoidingRandomStrollGoal extends RandomStrollGoal{

        public static final float PROBABILITY = 0.001F;
        protected final float probability;

        public PigeonWaterAvoidingRandomStrollGoal(PathfinderMob mob, double speedModifier) {
            this(mob, speedModifier, 0.001F);
        }

        public PigeonWaterAvoidingRandomStrollGoal(PathfinderMob mob, double speedModifier, float probability) {
            super(mob, speedModifier, 120, false);
            this.probability = probability;
        }


        protected Vec3 getPosition() {
            if (this.mob.isInWaterOrBubble()) {
                Vec3 vec3 = LandRandomPos.getPos(this.mob, 15, 7);
                return vec3 == null ? super.getPosition() : vec3;
            } else {
                return this.mob.getRandom().nextFloat() >= this.probability ? LandRandomPos.getPos(this.mob, 10, 7) : super.getPosition();
            }
        }

        public boolean canUse() {
            return (!Pigeon.this.isFlying() || !Pigeon.this.wantsToFly) && super.canUse();
        }

        public boolean canContinueToUse() {
            return (!Pigeon.this.isFlying() || !Pigeon.this.wantsToFly) && super.canContinueToUse();
        }

    }

    private void switchNavigator(boolean onLand) {
        if (onLand || this.isBaby()) {
            this.moveControl = new MoveControl(this);
            this.navigation = new GroundPathNavigation(this, level());
        } else {
            this.moveControl = new FlyingMoveControl(this, 32, false); //new FlightMoveController(this, 0.7F, false);
            this.navigation = new FlyingPathNavigation(this, level());
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FLY_TICKS, 0);
        builder.define(VARIANT, 0);
        builder.define(PANIC, false);
        builder.define(FLYING, false);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("FlyTicks", getFlyTicks());
        compound.putInt("Variant", getVariant());
        compound.putBoolean("Panic", getPanic());
        compound.putBoolean("IsFlying", isFlying());
        if (this.hasLoft()) {
            compound.put("loft_pos", NbtUtils.writeBlockPos(this.getLoftPos()));
        }
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        this.loftPos = (BlockPos)NbtUtils.readBlockPos(compound, "loft_pos").orElse((BlockPos) null);
        super.readAdditionalSaveData(compound);
        this.setFlyTicks(compound.getInt("FlyTicks"));
        this.setVariant(compound.getInt("Variant"));
        this.setPanic(compound.getBoolean("Panic"));
        this.setFlying(compound.getBoolean("IsFlying"));
    }

    public int getFlyTicks() {
        return this.entityData.get(FLY_TICKS);
    }

    public void setFlyTicks(int ticks) {
        this.entityData.set(FLY_TICKS, ticks);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    public boolean getPanic() {
        return this.entityData.get(PANIC);
    }

    public void setPanic(boolean panic) {
        this.setFlying(false);
        this.entityData.set(PANIC, panic);
    }

    public boolean isFlying() {
        return this.entityData.get(FLYING);
    }

    public void setFlying(boolean flight) {
        this.entityData.set(FLYING, flight);
        switchNavigator(!flight);
    }

    @Override
    public String getVariantName() {

        return switch (getVariant()) {
            case 1 -> "white";
            case 2 -> "red";
            default -> "grey";
        };
    }

    public static String getVariantName(int variant) {

        return switch (variant) {
            case 1 -> "white";
            case 2 -> "red";
            default -> "grey";
        };
    }

    public void startFollowing(Pigeon leader) {
        if (!this.hasFollowers()){
            this.leader = leader;
            leader.addFollower();
        }
    }

    public void stopFollowing() {
        assert this.leader != null;
        this.leader.removeFollower();
        this.leader = null;
    }

    private void addFollower() {
        ++this.schoolSize;
    }

    private void removeFollower() {
        --this.schoolSize;
    }

    public boolean canBeFollowed() {
        return !this.isFollower() && this.hasFollowers() && this.schoolSize < this.getMaxSchoolSize() && !this.isBaby() && this.level().isDay();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.FLYING_SPEED, 0.4F)
                .add(Attributes.MOVEMENT_SPEED, 0.2F).add(Attributes.MAX_HEALTH, 5);
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, @NotNull BlockState pState, @NotNull BlockPos pPos) {}

    @Override
    public int getMaxHeadYRot() {
        return 9;
    }

    @Override
    public int getMaxHeadXRot() {
        return 9;
    }


    @Override
    public void aiStep() {
        if(this.getLastDamageSource() != null) {
            if(!this.getPanic()) {
                this.getNavigation().stop();
                this.setPanic(true);
            }
        }
        super.aiStep();

        if (!this.level().isClientSide) {
            if (this.remainingCooldownBeforeLocatingNewLoft > 0) {
                --this.remainingCooldownBeforeLocatingNewLoft;
            }

            if (this.tickCount % 20 == 0 && !this.isLoftValid()) {
                this.loftPos = null;
            }
        }
    }

    @Override
    public void tick() {
        if (this.level().isClientSide()){
            this.setupAnimationStates();
        }

        super.tick();

        if (this.isFlying() && !this.onGround()){
            if (this.random.nextInt(10)==0){
                if (!findGroundPosition()){
                    this.setFlyTicks(0);
                    this.moveDown();
                }
            }
        }

        if (this.isFollower() && this.leader!=null && this.random.nextInt(50)==0){

            if (!this.isTooCloseToLeader()){
                if (this.leader.wantsToFly && this.getFlyTicks()<500){
                    this.setFlyTicks(500);
                }

                if (!this.leader.wantsToFly && this.getFlyTicks()>0){
                    this.setFlyTicks(0);
                }
            }

        }

        int prevFlyTicks = this.getFlyTicks();

        if (!this.wantsToFly && this.isFlying()){
            this.setFlying(false);
        }

        if (this.getFlyTicks()<=0){
            this.wantsToFly = false;
        }else if (this.getFlyTicks()>=500){
            this.wantsToFly = true;
        }

        if (this.wantsToFly && !this.isFlying()){
            this.setFlyTicks(prevFlyTicks-1);
        }else if (!this.wantsToFly){
            this.setFlyTicks(prevFlyTicks+1);
        }

        if(!this.onGround() && !this.isFlying() && this.getDeltaMovement().y<0) {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1, 0.75F, 1));
        }

        if (this.hasFollowers() && this.level().random.nextInt(200) == 1) {
            List<? extends Pigeon> list = this.level()
                    .getEntitiesOfClass((Class<? extends Pigeon>)this.getClass(), this.getBoundingBox().inflate(8.0, 8.0, 8.0));
            if (list.size() <= 1) {
                this.schoolSize = 1;
            }
        }
    }

    private void setupAnimationStates() {
        this.idleAnimationState.animateWhen(this.isAlive(), this.tickCount);
    }


    public boolean hasFollowers() {
        return this.schoolSize > 1;
    }

    public boolean inRangeOfLeader() {
        return this.distanceToSqr(this.leader) <= 200.0;
    }

    public boolean isTooCloseToLeader() {
        return this.distanceToSqr(this.leader) <= 3;
    }

    public boolean shouldMoveToLeader() {
        if (this.leader == null){
            return false;
        }else {
            if (!this.inRangeOfLeader()) return false;
            return !this.isTooCloseToLeader();
        }
    }

    public void pathToLeader() {
        if (this.isFollower()) {
            this.getNavigation().moveTo(this.leader, 1.0);
        }

    }
    public boolean isFollower() {
        return this.leader != null && this.leader.isAlive() && this.level().isDay();
    }


    public void addFollowers(Stream<? extends Pigeon> followers) {
        followers.limit((long)(this.getMaxSchoolSize() - this.schoolSize))
                .filter(p_27538_ -> p_27538_ != this)
                .forEach(p_27536_ -> p_27536_.startFollowing(this));
    }

    @Override
    public SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType spawnType, SpawnGroupData spawnGroupData) {

        super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);

        if (spawnType != MobSpawnType.SPAWN_EGG) {
            if (spawnGroupData == null) {
                spawnGroupData = new SchoolSpawnGroupData(true, this);
            } else {
                this.startFollowing(((SchoolSpawnGroupData)spawnGroupData).leader);
            }
        }

        if (spawnType != MobSpawnType.STRUCTURE){

            if (!this.level().isClientSide()){
                ServerLevel serverLevel = (ServerLevel)this.level();
                if (serverLevel.isVillage(this.blockPosition())){
                    this.setVariant(this.random.nextInt(3));
                }else {
                    this.setVariant(0);
                }
            }

        }else{
            this.setVariant(this.random.nextInt(3));

            int extraBirds = this.getRandom().nextInt(1, 5);
            for (int i = 0; i < extraBirds; i++){
                Pigeon pigeon = CCEntities.PIGEON.get().create(level.getLevel());
                if (pigeon != null) {
                    pigeon.moveTo(this.getX(), this.getY(), this.getZ(), random.nextInt(360), 0.0F);
                    pigeon.finalizeSpawn(level, level.getCurrentDifficultyAt(this.blockPosition()), MobSpawnType.NATURAL, spawnGroupData);
                    pigeon.setVariant(this.random.nextInt(3));
                    level.addFreshEntity(pigeon);
                }
            }
        }

        return spawnGroupData;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return this.getMaxSchoolSize();
    }

    public int getMaxSchoolSize() {
        return 10;
    }

    @Override
    public boolean hasChildModel() {
        return true;
    }

    @Override
    public void move(@NotNull MoverType type, @NotNull Vec3 pos) {
        super.move(type, pos);
    }

    @Override
    protected float getJumpPower() {
        return this.getJumpPower(1F);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(ItemTags.VILLAGER_PLANTABLE_SEEDS);
    }


    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        Pigeon entity = CCEntities.PIGEON.get().create(serverLevel);
        if(entity != null) {

            //entity.setVariant(this.random.nextInt(3));

            if(ageableMob instanceof Pigeon otherParent) {
                if (otherParent.getVariant() != this.getVariant()){
                    entity.setVariant(this.random.nextBoolean() ? this.getVariant() : otherParent.getVariant());
                }else if(otherParent.getVariant() == this.getVariant()) {
                    if (this.getVariant() == 0){
                        int random = this.random.nextInt(100);
                        if (random>20){
                            entity.setVariant(this.getVariant());
                        }else {
                            entity.setVariant(this.random.nextBoolean() ? 1 : 2);
                        }
                    }else {
                        entity.setVariant(this.getVariant());
                    }
                }
            }

            entity.setBaby(true);
        }
        return entity;
    }


    public static boolean spawnRules(EntityType<Pigeon> pigeonEntityEntityType, ServerLevelAccessor serverLevelAccessor, MobSpawnType mobSpawnType, BlockPos pos, RandomSource randomSource) {
        boolean canContinue = serverLevelAccessor.isEmptyBlock(pos);

        boolean isAir = serverLevelAccessor.getBlockState(pos.below()).isAir();

        boolean flag = MobSpawnType.ignoresLightRequirements(mobSpawnType) || isBrightEnoughToSpawn(serverLevelAccessor, pos);

        if(canContinue) {
            Optional<ResourceKey<Biome>> biomeKey = serverLevelAccessor.getBiome(pos).unwrapKey();
            if(biomeKey.isPresent()) {
                ResourceKey<Biome> resourceKey = biomeKey.get();
                if(resourceKey == Biomes.END_MIDLANDS || resourceKey == Biomes.END_BARRENS || resourceKey == Biomes.END_HIGHLANDS || resourceKey == Biomes.SMALL_END_ISLANDS) {
                    StructureManager manager = serverLevelAccessor.getLevel().structureManager();
                    if (manager.hasAnyStructureAt(pos)) {
                        Map<Structure, LongSet> structures = manager.getAllStructuresAt(pos);
                        for (Structure structure : structures.keySet()) {
                            if (structure.type() == StructureType.END_CITY) {
                                return !isAir;
                            }
                        }
                    }
                    return false;
                } else if(serverLevelAccessor.getBiomeManager().getBiome(pos).is(BiomeTags.IS_MOUNTAIN)) {
                    return (serverLevelAccessor.getBlockState(pos.below()).is(BlockTags.ANIMALS_SPAWNABLE_ON) && flag);

                } else {
                    return serverLevelAccessor.getLevel().isVillage(pos);
                }
            }
        }
        return false;
    }

    public static class SchoolSpawnGroupData extends AgeableMobGroupData {
        public final Pigeon leader;
        public SchoolSpawnGroupData(boolean shouldSpawnBaby, Pigeon pigeonEntity) {
            super(shouldSpawnBaby);
            this.leader = pigeonEntity;
        }
    }

    class PigeonFlyGoal extends Goal {
        private static final int WANDER_THRESHOLD = 22;

        PigeonFlyGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Pigeon.this.wantsToFly && Pigeon.this.navigation.isDone() && Pigeon.this.random.nextInt(10) == 0;
        }

        public boolean canContinueToUse() {
            return Pigeon.this.isFlying() && Pigeon.this.navigation.isInProgress();
        }

        public void start() {
            Pigeon.this.setFlying(true);
            Vec3 vec3 = this.findPos();
            if (vec3 != null) {
                Pigeon.this.navigation.moveTo(Pigeon.this.navigation.createPath(BlockPos.containing(vec3), 1), 1.0);
            }

        }


        private Vec3 findPos() {
            Vec3 vec3;

            vec3 = Pigeon.this.getViewVector(0.0F);

            Vec3 vec32 = HoverRandomPos.getPos(Pigeon.this, 8, 7, vec3.x, vec3.z, 1.5707964F, 3, 1);
            return vec32 != null ? vec32 : AirAndWaterRandomPos.getPos(Pigeon.this, 8, 4, -2, vec3.x, vec3.z, 1.5707963705062866);
        }

        @Override
        public void stop() {
            super.stop();
            Pigeon.this.setFlying(false);
        }
    }

    private Boolean findGroundPosition() {
        BlockPos blockpos = null;

        for(int i = 0; i < 10; i++) {
            blockpos = new BlockPos((int) this.getX(), (int) (this.getY()-i), (int) this.getZ());
            if (!this.isAir(this.level(), blockpos)) {
                return true;
            }
        }

        return false;
    }

    private void moveDown(){
        this.setDeltaMovement(0, -1, 0);
    }

    private boolean isAir(LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos);
        return (blockstate.is(Blocks.AIR));
    }

    @Override
    public void remove(RemovalReason reason) {
        if (!this.level().isClientSide && this.isDeadOrDying() && this.isFollower()){
            if (this.leader != null){
                this.leader.removeFollower();
            }
        }
        super.remove(reason);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return CCSounds.PIGEON_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return CCSounds.PIGEON_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return CCSounds.PIGEON_DEATH.get();
    }

    protected boolean isFlapping() {
        return !this.onGround() && !this.isInWaterOrBubble() && this.getRandom().nextInt(10) == 0 ;
    }

    protected void onFlap() {
        this.playSound(CCSounds.PIGEON_FLAP.get(), 0.15F, 1.0F);
    }

    @Override
    public float getWalkTargetValue(BlockPos pPos, LevelReader pLevel) {
        if (this.isFlying())
            return this.getDepthPathfindingFavor(pPos, pLevel);
        else
            return super.getWalkTargetValue(pPos, pLevel);
    }

    float getDepthPathfindingFavor(BlockPos pos, LevelReader world) {
        int y = pos.getY() + Math.abs(world.getSeaLevel()) + 70;
        return 1f / (y < 0 ? 1 : y);
    }






    //Loft stuff

    @Nullable
    BlockPos loftPos;
    private static final int COOLDOWN_BEFORE_LOCATING_NEW_LOFT = 200;
    int remainingCooldownBeforeLocatingNewLoft;

    PigeonGoToLoftGoal goToLoftGoal;

    @VisibleForDebug
    public boolean hasLoft() {
        return this.loftPos != null;
    }

    @Nullable
    @VisibleForDebug
    public BlockPos getLoftPos() {
        return this.loftPos;
    }


    void pathfindRandomlyTowards(BlockPos pos) {
        Vec3 vec3 = Vec3.atBottomCenterOf(pos);
        int i = 0;
        BlockPos blockpos = this.blockPosition();
        int j = (int)vec3.y - blockpos.getY();
        if (j > 2) {
            i = 4;
        } else if (j < -2) {
            i = -4;
        }

        int k = 6;
        int l = 8;
        int i1 = blockpos.distManhattan(pos);
        if (i1 < 15) {
            k = i1 / 2;
            l = i1 / 2;
        }

        Vec3 vec31 = AirRandomPos.getPosTowards(this, k, l, i, vec3, (double)((float)Math.PI / 10F));
        if (vec31 != null) {
            this.navigation.setMaxVisitedNodesMultiplier(0.5F);
            this.navigation.moveTo(vec31.x, vec31.y, vec31.z, (double)1.0F);
        }

    }


    boolean closerThan(BlockPos pos, int distance) {
        return pos.closerThan(this.blockPosition(), (double)distance);
    }

    public void setLoftPos(BlockPos loftPos) {
        this.loftPos = loftPos;
    }

    boolean wantsToEnterLoft() {
        boolean flag = this.level().isRaining() || this.level().isNight();
        return flag && !this.isLoftNearFire();
    }

    private boolean isLoftNearFire() {
        if (this.loftPos == null) {
            return false;
        } else {
            BlockEntity blockentity = this.level().getBlockEntity(this.loftPos);
            return blockentity instanceof PigeonLoftBlockEntity && ((PigeonLoftBlockEntity)blockentity).isFireNearby();
        }
    }

    private boolean doesLoftHaveSpace(BlockPos loftPos) {
        BlockEntity blockentity = this.level().getBlockEntity(loftPos);
        return blockentity instanceof PigeonLoftBlockEntity ? ((PigeonLoftBlockEntity)blockentity).isEmpty() : false;
    }

    boolean isTooFarAway(BlockPos pos) {
        return !this.closerThan(pos, 32);
    }

    boolean isLoftValid() {
        if (!this.hasLoft()) {
            return false;
        } else if (this.isTooFarAway(this.loftPos)) {
            return false;
        } else {
            BlockEntity blockentity = this.level().getBlockEntity(this.loftPos);
            return blockentity != null && blockentity.getType() == CCBlockEntities.PIGEON_LOFT.get();
        }
    }

    class PigeonEnterLoftGoal extends Goal {

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        @Override
        public boolean canUse() {
            if (Pigeon.this.hasLoft() && Pigeon.this.wantsToEnterLoft() && Pigeon.this.loftPos.closerToCenterThan(Pigeon.this.position(), (double)2.0F)) {
                BlockEntity blockEntity = Pigeon.this.level().getBlockEntity(Pigeon.this.loftPos);
                if (blockEntity instanceof PigeonLoftBlockEntity) {
                    PigeonLoftBlockEntity pigeonloftBlockEntity = (PigeonLoftBlockEntity)blockEntity;
                    if (pigeonloftBlockEntity.isEmpty()) {
                        return true;
                    }

                    Pigeon.this.loftPos = null;
                }
            }

            return false;
        }

        public void start() {
            BlockEntity blockEntity = Pigeon.this.level().getBlockEntity(Pigeon.this.loftPos);
            if (blockEntity instanceof PigeonLoftBlockEntity pigeonloftBlockEntity) {
                pigeonloftBlockEntity.tryEnterDwelling(Pigeon.this);
            }
        }
    }

    class PigeonLocateLoftGoal extends Goal {

        public boolean canUse() {
            return Pigeon.this.remainingCooldownBeforeLocatingNewLoft == 0 && !Pigeon.this.hasLoft() && Pigeon.this.wantsToEnterLoft();
        }

        @Override
        public boolean canContinueToUse() {
            return false;
        }

        public void start() {
            Pigeon.this.remainingCooldownBeforeLocatingNewLoft = 200;
            List<BlockPos> list = this.findNearbyLoftsWithSpace();
            if (!list.isEmpty()) {
                for(BlockPos blockPos : list) {
                    if (!Pigeon.this.goToLoftGoal.isTargetBlacklisted(blockPos)) {
                        Pigeon.this.setLoftPos(blockPos);
                        return;
                    }
                }

                Pigeon.this.goToLoftGoal.clearBlacklist();
                Pigeon.this.setLoftPos(list.get(0));
            }
        }

        private List<BlockPos> findNearbyLoftsWithSpace() {
            BlockPos blockPos = Pigeon.this.blockPosition();
            PoiManager poiManager = ((ServerLevel)Pigeon.this.level()).getPoiManager();
            Stream<PoiRecord> stream = poiManager.getInRange((holder) -> holder.is(CCTags.POITypes.PIGEON_LOFT_POI), blockPos, 20, PoiManager.Occupancy.ANY);

            return (List)stream.map(PoiRecord::getPos).filter(Pigeon.this::doesLoftHaveSpace).sorted(Comparator.comparingDouble(
                    (blockPos2) -> blockPos2.distSqr(blockPos))).collect(Collectors.toList());
        }
    }

    public class PigeonGoToLoftGoal extends Goal {
        public static final int MAX_TRAVELLING_TICKS = 600;
        int travellingTicks;
        private static final int MAX_BLACKLISTED_TARGETS = 3;
        final List<BlockPos> blacklistedTargets;
        @Nullable
        private Path lastPath;
        private static final int TICKS_BEFORE_LOFT_DROP = 60;
        private int ticksStuck;

        PigeonGoToLoftGoal() {
            this.travellingTicks = Pigeon.this.level().random.nextInt(10);
            this.blacklistedTargets = Lists.newArrayList();
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            return Pigeon.this.loftPos != null && !Pigeon.this.hasRestriction() 
                    && Pigeon.this.wantsToEnterLoft() && !this.hasReachedTarget(Pigeon.this.loftPos)
                    && Pigeon.this.level().getBlockState(Pigeon.this.loftPos).is(CCTags.Blocks.PIGEON_LOFTS);
        }

        public void start() {
            this.travellingTicks = 0;
            this.ticksStuck = 0;
            super.start();
        }

        public void stop() {
            this.travellingTicks = 0;
            this.ticksStuck = 0;
            Pigeon.this.navigation.stop();
            Pigeon.this.navigation.resetMaxVisitedNodesMultiplier();
        }

        public void tick() {
            if (Pigeon.this.loftPos != null) {
                ++this.travellingTicks;
                if (this.travellingTicks > this.adjustedTickDelay(600)) {
                    this.dropAndBlacklistLoft();
                } else if (!Pigeon.this.navigation.isInProgress()) {
                    if (!Pigeon.this.closerThan(Pigeon.this.loftPos, 16)) {
                        if (Pigeon.this.isTooFarAway(Pigeon.this.loftPos)) {
                            this.dropLoft();
                        } else {
                            Pigeon.this.pathfindRandomlyTowards(Pigeon.this.loftPos);
                        }
                    } else {
                        boolean flag = this.pathfindDirectlyTowards(Pigeon.this.loftPos);
                        if (!flag) {
                            this.dropAndBlacklistLoft();
                        } else if (this.lastPath != null && Pigeon.this.navigation.getPath().sameAs(this.lastPath)) {
                            ++this.ticksStuck;
                            if (this.ticksStuck > 60) {
                                this.dropLoft();
                                this.ticksStuck = 0;
                            }
                        } else {
                            this.lastPath = Pigeon.this.navigation.getPath();
                        }
                    }
                }
            }

        }

        private boolean pathfindDirectlyTowards(BlockPos pos) {
            Pigeon.this.navigation.setMaxVisitedNodesMultiplier(10.0F);
            Pigeon.this.navigation.moveTo((double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), 2, (double)1.0F);
            return Pigeon.this.navigation.getPath() != null && Pigeon.this.navigation.getPath().canReach();
        }

        boolean isTargetBlacklisted(BlockPos pos) {
            return this.blacklistedTargets.contains(pos);
        }

        private void blacklistTarget(BlockPos pos) {
            this.blacklistedTargets.add(pos);

            while(this.blacklistedTargets.size() > 3) {
                this.blacklistedTargets.remove(0);
            }

        }

        void clearBlacklist() {
            this.blacklistedTargets.clear();
        }

        private void dropAndBlacklistLoft() {
            if (Pigeon.this.loftPos != null) {
                this.blacklistTarget(Pigeon.this.loftPos);
            }

            this.dropLoft();
        }

        private void dropLoft() {
            Pigeon.this.loftPos = null;
            Pigeon.this.remainingCooldownBeforeLocatingNewLoft = 200;
        }

        private boolean hasReachedTarget(BlockPos pos) {
            if (Pigeon.this.closerThan(pos, 2)) {
                return true;
            } else {
                Path path = Pigeon.this.navigation.getPath();
                return path != null && path.getTarget().equals(pos) && path.canReach() && path.isDone();
            }
        }
    }
}
