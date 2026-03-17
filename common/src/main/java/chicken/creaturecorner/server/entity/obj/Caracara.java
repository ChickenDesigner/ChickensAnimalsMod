package chicken.creaturecorner.server.entity.obj;

import chicken.creaturecorner.server.block.CCBlocks;
import chicken.creaturecorner.server.block.obj.custom.CaracaraNestBlock;
import chicken.creaturecorner.server.block.obj.custom.PigeonNestBlock;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.base.INestEggLayer;
import chicken.creaturecorner.server.entity.obj.control.AnimalMoveControl;
import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.base.goal.LookForFoodGoal;
import chicken.creaturecorner.server.entity.obj.goal.nesting.BuildNestGoal;
import chicken.creaturecorner.server.entity.obj.goal.nesting.EggLayerBreedGoal;
import chicken.creaturecorner.server.entity.obj.goal.nesting.GoToNestGoal;
import chicken.creaturecorner.server.entity.obj.goal.nesting.LocateNestGoal;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;


public class Caracara extends AbstractCornerCreature implements NeutralMob, INestEggLayer {

    public final AnimationState idleAnimationState = new AnimationState();

    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);

    Ingredient FOOD_INGREDIENTS = Ingredient.of(Items.RABBIT, Items.PORKCHOP);

    private UUID persistentAngerTarget;
    public boolean wantsToFly;
    private LookForFoodGoal forFoodGoal;
    @Nullable
    BlockPos nestPos;
    int layEggCounter;
    int buildNestCounter;
    int locateNestCooldown;
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME;
    private static final EntityDataAccessor<Integer> FLY_TICKS;
    private static final EntityDataAccessor<Integer> IN_FLIGHT_TICKS;
    private static final EntityDataAccessor<Boolean> FLYING;
    private static final EntityDataAccessor<Boolean> DIVING;

    private static final EntityDataAccessor<Boolean> IS_PREGNANT = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_BUILDING_NEST = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_LAYING_EGG = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> NEST_SEARCH_TIME = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> NEST_BUILD_TIME = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.INT);

    public AttackPhase attackPhase;
    public float currentRoll;
    public float currentPitch;
    public static final float STARTING_ANGLE = 0.015F;

    public Caracara(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
        this.attackPhase = AttackPhase.CIRCLE;
        this.currentRoll = 0.0F;
        this.currentPitch = 0.0F;
        this.setPathfindingMalus(PathType.DANGER_FIRE, -1.0F);
        this.setPathfindingMalus(PathType.WATER, -1.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 16.0F);
        this.setPathfindingMalus(PathType.COCOA, -1.0F);
        this.setPathfindingMalus(PathType.FENCE, -1.0F);
        this.moveControl = new CaracaraMoveControl(this, 1.0F, false);
        this.navigation = new CaracaraPathNavigation(this, this.level());
        this.lookControl = new SmoothSwimmingLookControl(this, 2);
        this.wantsToFly = false;
    }

    public boolean canFly() {
        return this.wantsToFly && !this.isBaby();
    }

    public boolean killedEntity(ServerLevel level, LivingEntity entity) {
        if (!(entity instanceof Player)) {
            this.killed(entity);
        }

        return super.killedEntity(level, entity);
    }

    public void killed(LivingEntity entity) {
        int food = this.getFoodLevel();
        if (!(entity instanceof Sheep) && !(entity instanceof Pig)) {
            this.setFoodLevel(Math.min(60, food + 20));
        } else {
            this.setFoodLevel(Math.min(60, food + 50));
        }

    }

    public int maxFood() {
        return 60;
    }

    protected void registerGoals() {
        this.forFoodGoal = new LookForFoodGoal(this, ItemTags.MEAT);
        this.goalSelector.addGoal(3, this.forFoodGoal);
        this.goalSelector.addGoal(2, new CaracaraFlyMelee(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0F, true) {
            public boolean canUse() {
                return !Caracara.this.canFly() && super.canUse();
            }

            public boolean canContinueToUse() {
                return !Caracara.this.canFly() && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.5, itemstack -> itemstack.is(Items.RABBIT), false));

        this.goalSelector.addGoal(2, new CaracaraStalkPrey(this, (double)1.0F));
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(4, new CaracaraStrollGoal(this, (double)0.5F));
        this.goalSelector.addGoal(7, new AIFlyIdle());

        this.goalSelector.addGoal(2, new EggLayerBreedGoal(this, 1));
        this.goalSelector.addGoal(0, new Caracara.CaracaraLocateNest());
        this.goalSelector.addGoal(2, new Caracara.CaracaraGoToNestGoal(this, 1));
        this.goalSelector.addGoal(1, new Caracara.CaracaraBuildNestGoal());

        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Pigeon.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Chicken.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Rabbit.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Pig.class, false));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Sheep.class, false));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
    }

    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(FLY_TICKS, 0);
        builder.define(IN_FLIGHT_TICKS, 0);
        builder.define(FLYING, false);
        builder.define(DIVING, false);
        builder.define(DATA_REMAINING_ANGER_TIME, 0);
        builder.define(IS_PREGNANT, false);
        builder.define(IS_LAYING_EGG, false);
        builder.define(IS_BUILDING_NEST, false);
        builder.define(NEST_SEARCH_TIME, 0);
        builder.define(NEST_BUILD_TIME, 0);
    }

    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("FlyTicks", this.getFlyTicks());
        compound.putBoolean("IsFlying", this.isFlying());
        compound.putBoolean("IsPregnant", isPregnant());
        compound.putBoolean("IsLayingEgg", isLayingEgg());
        compound.putBoolean("IsBuildingNest", isBuildingNest());
        compound.putInt("NestSearchTime", getNestSearchTime());
        compound.putInt("NestBuildTime", getNestBuildingTime());
    }

    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFlyTicks(compound.getInt("FlyTicks"));
        this.setFlying(compound.getBoolean("IsFlying"));
        this.setPregnant(compound.getBoolean("IsPregnant"));
        this.setLayingEgg(compound.getBoolean("IsLayingEgg"));
        this.setBuildingNest(compound.getBoolean("IsBuildingNest"));
        this.setNestSearchTime(compound.getInt("NestSearchTime"));
        this.setNestBuildingTime(compound.getInt("NestBuildTime"));
    }

    public int getFlyTicks() {
        return (Integer)this.entityData.get(FLY_TICKS);
    }

    public void setFlyTicks(int ticks) {
        this.entityData.set(FLY_TICKS, ticks);
    }

    public int getInFlightTicks() {
        return (Integer)this.entityData.get(IN_FLIGHT_TICKS);
    }

    public void setInFlightTicks(int ticks) {
        this.entityData.set(IN_FLIGHT_TICKS, ticks);
    }

    public void setFlying(boolean flight) {
        this.entityData.set(FLYING, flight);
    }

    public boolean isFlying() {
        return (Boolean)this.entityData.get(FLYING);
    }

    public void setDiving(boolean flight) {
        this.entityData.set(DIVING, flight);
    }

    public boolean isDiving() {
        return (Boolean)this.entityData.get(DIVING);
    }

    public boolean canPickUpLoot() {
        return this.isHungry();
    }

    @Override
    public boolean isPregnant() {
        return this.entityData.get(IS_PREGNANT);
    }

    @Override
    public void setPregnant(boolean pregnant) {
        this.entityData.set(IS_PREGNANT, pregnant);
    }

    @Override
    public int getLayEggCounter() {
        return this.layEggCounter;
    }

    @Override
    public void setLayEggCounter(int layEggCounter) {
        this.layEggCounter = layEggCounter;
    }

    @Override
    public boolean isLayingEgg() {
        return this.entityData.get(IS_LAYING_EGG);
    }

    @Override
    public void setLayingEgg(boolean pIsLayingEgg) {
        this.layEggCounter = pIsLayingEgg ? 1 : 0;
        this.entityData.set(IS_LAYING_EGG, pIsLayingEgg);
    }

    public boolean hasNest() {
        return this.getNestPos() != null;
    }

    @Override
    public void setNestPos(BlockPos pPos) {
        this.nestPos = pPos;
    }

    @Nullable
    @Override
    public BlockPos getNestPos() {
        return this.nestPos;
    }

    @Override
    public int getBuildingNestCounter() {
        return buildNestCounter;
    }

    @Override
    public void setBuildingNestCounter(int buildNestCounter) {
        this.buildNestCounter = buildNestCounter;
    }

    @Override
    public int getNestSearchTime() {
        return this.entityData.get(NEST_SEARCH_TIME);
    }

    @Override
    public void setNestSearchTime(int searchTime) {
        this.entityData.set(NEST_SEARCH_TIME, searchTime);
    }

    @Override
    public int getNestBuildingTime() {
        return this.entityData.get(NEST_BUILD_TIME);
    }

    @Override
    public void setNestBuildingTime(int searchTime) {
        this.entityData.set(NEST_BUILD_TIME, searchTime);
    }

    @Override
    public Block getNestType() {
        return CCBlocks.CARACARA_NEST.get();
    }

    @Override
    public boolean isBuildingNest() {
        return this.entityData.get(IS_BUILDING_NEST);
    }

    @Override
    public void setBuildingNest(boolean buildingNest) {
        this.buildNestCounter = buildingNest ? 1 : 0;
        this.entityData.set(IS_BUILDING_NEST, buildingNest);
    }

    @Override
    public int getNestSearchCooldown() {
        return locateNestCooldown;
    }

    @Override
    public void setNestSearchCooldown(int cooldown) {
        this.locateNestCooldown = cooldown;
    }

    @Override
    public void onNestBuilt(Level level, BlockPos pos) {
        this.getJumpControl().jump();
        BlockState state = this.getNestType().defaultBlockState();
        level.playSound(null, pos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
        level.setBlock(pos, state, 3);
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(this, state));
        this.setNestPos(pos);
    }

    @Override
    public void onEggLaid(Level level, BlockPos pos) {
        if (!this.level().isClientSide()){
            if (this.hasNest()){
                BlockState blockstate = CCBlocks.CARACARA_NEST.get().defaultBlockState();

                if (blockstate.getBlock() instanceof CaracaraNestBlock){
                    int eggs = this.getRandom().nextInt(1, 4);
                    level.setBlockAndUpdate(pos, blockstate.setValue(CaracaraNestBlock.EGGS, eggs));

                    level.playSound(null, pos, SoundEvents.MOSS_PLACE, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
                    level.playSound(null, pos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);

                    level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(this, blockstate.setValue(CaracaraNestBlock.EGGS, eggs)));
                }
            }
        }
    }

    @Override
    public void onBreed(AbstractCornerCreature partner) {
        if (!this.hasNest()){
            this.setNestSearchTime(20*60);
            this.setNestBuildingTime(20*60);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.STEP_HEIGHT, 1.0F)
                .add(Attributes.FLYING_SPEED, 1.0F)
                .add(Attributes.ATTACK_DAMAGE, 4.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.FOLLOW_RANGE, 64.0F);
    }

    protected void checkFallDamage(double pY, boolean pOnGround, @NotNull BlockState pState, @NotNull BlockPos pPos) {
        if (this.isBaby()) {
            super.checkFallDamage(pY, pOnGround, pState, pPos);
        }

    }

    public int getMaxHeadYRot() {
        return 9;
    }

    public int getMaxHeadXRot() {
        return 9;
    }

    protected void pickUpItem(ItemEntity itemEntity) {
        ItemStack item = itemEntity.getItem();
        if (item.is(ItemTags.MEAT)) {
            ItemStack itemstack = itemEntity.getItem();
            ItemStack itemstack1 = this.equipItemIfPossible(itemstack.copy());
            if (!itemstack1.isEmpty()) {
                this.onItemPickup(itemEntity);
                this.take(itemEntity, 1);
                itemstack.shrink(1);
                if (itemstack.isEmpty()) {
                    itemEntity.discard();
                }
            }
        }

    }

    private void triggerFoodSearch() {
        if (this.forFoodGoal != null) {
            this.forFoodGoal.trigger();
        } else {
            this.navigation.stop();
            Predicate<ItemEntity> predicate = (p_25258_) -> p_25258_.getItem().is(ItemTags.MEAT);
            List<? extends ItemEntity> list = this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate((double)32.0F, (double)8.0F, (double)32.0F), predicate);
            if (!list.isEmpty()) {
                this.navigation.moveTo((Entity)list.getFirst(), 1.1);
            }
        }

    }

    public void aiStep() {
        ItemStack stack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        if (stack != null && stack.is(ItemTags.MEAT) && this.isHungry()) {
            this.setFoodLevel(this.getFoodLevel() + 50);
            this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), this.getX(), this.getY(), this.getZ(), (double)0.0F, (double)0.0F, (double)0.0F);
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EAT, SoundSource.AMBIENT);
            stack.setCount(0);
            this.setItemInHand(InteractionHand.MAIN_HAND, Items.AIR.getDefaultInstance());
        }

        if (this.isAlmostStarving() && (double)this.random.nextFloat() <= 0.2) {
            this.triggerFoodSearch();
        }

        super.aiStep();

        if (this.isFlying() && !this.onGround()) {
            float prevPitch = this.currentPitch;
            float targetPitch = (float)Math.max((double)-0.75F, Math.min((double)0.75F, (this.getY() - this.yOld) * (double)10.0F));
            targetPitch = -targetPitch;
            this.currentPitch = prevPitch + (targetPitch - prevPitch) * 0.05F;

            float prevRoll = this.currentRoll;
            float targetRoll = Math.max(-0.45F, Math.min(0.45F, (this.getYRot() - this.yRotO) * 0.1F));
            targetRoll = -targetRoll;
            this.currentRoll = prevRoll + (targetRoll - prevRoll) * 0.05F;
        } else {
            this.currentPitch = 0.0F;

            this.currentRoll = 0.0F;
        }

        if (this.isAlive() && (this.isLayingEgg() && this.layEggCounter >= 1 && this.layEggCounter % 5 == 0)) {
            BlockPos blockpos = this.blockPosition();
            this.level().levelEvent(2001, blockpos, Block.getId(this.level().getBlockState(blockpos)));
        }
        if (this.isAlive() && (this.isBuildingNest() && this.buildNestCounter >= 1 && this.buildNestCounter % 5 == 0)) {
            BlockPos blockpos = this.blockPosition().below();
            this.level().levelEvent(2001, blockpos, Block.getId(this.level().getBlockState(blockpos)));
        }

    }

    @Override
    public boolean hasHunger() {
        return true;
    }

    private void setupAnimationStates() {
        this.idleAnimationState.animateWhen(this.isAlive(), this.tickCount);
    }

    public void tick() {
        if (this.level().isClientSide()){
            this.setupAnimationStates();
        }

        super.tick();
        int prevFlyTicks = this.getFlyTicks();
        if (!this.level().isClientSide) {
            if (this.isDiving() && (this.getTarget() == null || this.attackPhase == AttackPhase.CIRCLE || this.isBaby())) {
                this.setDiving(false);
            }

            if (this.isFlying() && this.canFly()) {
                this.setNoGravity(true);
                if (this.isPassenger() || this.isInLove()) {
                    this.setFlying(false);
                }
            } else {
                this.setNoGravity(false);
            }
        }

        if (!this.canFly() && this.onGround()) {
            this.setFlying(false);
        }

        if (this.getFlyTicks() <= 0) {
            this.wantsToFly = false;
        } else if (this.getFlyTicks() >= 1000) {
            this.wantsToFly = true;
        }

        if (!this.isAggressive()) {
            if (this.canFly() && this.isFlying()) {
                this.setFlyTicks(prevFlyTicks - 1);
            } else if (!this.canFly() && this.onGround()) {
                this.setFlyTicks(prevFlyTicks + 3);
            }
        }

        if (this.isFlying() && this.getInFlightTicks()<5) {
            int prevFlightTicks = this.getInFlightTicks();
            this.setInFlightTicks(prevFlightTicks+1);
        }

        if (!this.isFlying() && this.getInFlightTicks()>0) {
            int prevFlightTicks = this.getInFlightTicks();
            this.setInFlightTicks(prevFlightTicks-1);
        }

        LivingEntity var3 = this.getTarget();
        if (var3 instanceof Pigeon pigeon) {
            if (this.canFly() && pigeon.isFlying() && this.random.nextInt(10) == 0) {
                this.setFlyTicks(500);
                this.setFlying(true);
                this.wantsToFly = true;
            }
        }

        if (!this.onGround() && !this.isFlying() && this.getDeltaMovement().y < (double)0.0F && !this.isBaby()) {
            this.setDeltaMovement(this.getDeltaMovement().multiply((double)1.0F, (double)0.5F, (double)1.0F));
        }

    }

    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.RABBIT);
    }

    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {
        Caracara entity = (Caracara) CCEntities.CARACARA.get().create(serverLevel);
        if (entity != null) {
            entity.setBaby(true);
        }

        return entity;
    }

    public int getRemainingPersistentAngerTime() {
        return (Integer)this.entityData.get(DATA_REMAINING_ANGER_TIME);
    }

    public void setRemainingPersistentAngerTime(int time) {
        this.entityData.set(DATA_REMAINING_ANGER_TIME, time);
    }

    public UUID getPersistentAngerTarget() {
        return this.persistentAngerTarget;
    }

    public void setPersistentAngerTarget(UUID uuid) {
        this.persistentAngerTarget = uuid;
    }

    public void startPersistentAngerTimer() {
        this.setRemainingPersistentAngerTime(PERSISTENT_ANGER_TIME.sample(this.random));
    }

    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target) && ((this.getLastHurtByMob() != null && this.getLastHurtByMob() == target) || this.isHungry() && (!this.isBaby() || (this.isBaby() && ((target instanceof Pigeon && target.isBaby()) || target instanceof Rabbit || target instanceof Chicken))));
    }


    public BlockPos getBirdGround(BlockPos in) {
        BlockPos position;
        for(position = new BlockPos(in.getX(), (int)this.getY(), in.getZ()); position.getY() < 320 && !this.level().getFluidState(position).isEmpty(); position = position.above()) {
        }

        while(position.getY() > -64 && !this.level().getBlockState(position).isSolid() && this.level().getFluidState(position).isEmpty()) {
            position = position.below();
        }

        return position;
    }

    public Vec3 getBlockGrounding(Vec3 fleePos) {
        float radius = (float)(10 + this.getRandom().nextInt(15));
        float neg = this.getRandom().nextBoolean() ? 1.0F : -1.0F;
        float renderYawOffset = this.yBodyRot;
        float angle = 0.015F * renderYawOffset + 3.15F + this.getRandom().nextFloat() * neg;
        double extraX = (double)(radius * Mth.sin((float)Math.PI + angle));
        double extraZ = (double)(radius * Mth.cos(angle));
        BlockPos radialPos = new BlockPos((int)(fleePos.x() + extraX), (int)this.getY(), (int)(fleePos.z() + extraZ));
        BlockPos ground = this.getBirdGround(radialPos);
        if (ground.getY() < -64) {
            return null;
        } else {
            for(ground = this.blockPosition(); ground.getY() > -64 && !this.level().getBlockState(ground).isSolid(); ground = ground.below()) {
            }

            return !this.isTargetBlocked(Vec3.atCenterOf(ground.above())) ? Vec3.atCenterOf(ground.below()) : null;
        }
    }

    public Vec3 getBlockInViewAway(Vec3 fleePos, float radiusAdd) {
        float radius = 5.0F + radiusAdd + (float)this.getRandom().nextInt(5);
        float neg = this.getRandom().nextBoolean() ? 1.0F : -1.0F;
        float renderYawOffset = this.yBodyRot;
        float angle = 0.015F * renderYawOffset + 3.15F + this.getRandom().nextFloat() * neg;
        double extraX = (double)(radius * Mth.sin((float)Math.PI + angle));
        double extraZ = (double)(radius * Mth.cos(angle));
        BlockPos radialPos = new BlockPos((int)(fleePos.x() + extraX), 0, (int)(fleePos.z() + extraZ));
        BlockPos ground = this.getBirdGround(radialPos);
        int distFromGround = (int)this.getY() - ground.getY();
        int flightHeight = 5 + this.getRandom().nextInt(5);
        int j = this.getRandom().nextInt(5) + 5;
        BlockPos newPos = ground.above(distFromGround > 5 ? flightHeight : j);
        if (this.level().getBlockState(ground).is(BlockTags.LEAVES)) {
            newPos = ground.above(1 + this.getRandom().nextInt(3));
        }

        return !this.isTargetBlocked(Vec3.atCenterOf(newPos)) && this.distanceToSqr(Vec3.atCenterOf(newPos)) > (double)1.0F ? Vec3.atCenterOf(newPos) : null;
    }

    public boolean isTargetBlocked(Vec3 target) {
        Vec3 Vector3d = new Vec3(this.getX(), this.getEyeY(), this.getZ());
        return this.level().clip(new ClipContext(Vector3d, target, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this)).getType() != HitResult.Type.MISS;
    }

    private boolean isOverWaterOrVoid() {
        BlockPos position;
        for(position = this.blockPosition(); position.getY() > -65 && this.level().isEmptyBlock(position); position = position.below()) {
        }

        return !this.level().getFluidState(position).isEmpty() || this.level().getBlockState(position).is(Blocks.VINE) || position.getY() <= -65;
    }

    static {
        DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.INT);
        FLY_TICKS = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.INT);
        IN_FLIGHT_TICKS = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.INT);
        FLYING = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.BOOLEAN);
        DIVING = SynchedEntityData.defineId(Caracara.class, EntityDataSerializers.BOOLEAN);
    }

    public class CaracaraPathNavigation extends GroundPathNavigation {
        private final Caracara mob;
        private float yMobOffset;

        public CaracaraPathNavigation(Caracara mob, Level world) {
            this(mob, world, 0.0F);
        }

        public CaracaraPathNavigation(Caracara mob, Level world, float yMobOffset) {
            super(mob, world);
            this.yMobOffset = 0.0F;
            this.mob = mob;
            this.yMobOffset = yMobOffset;
        }

        public void tick() {
            if (this.mob.canFly()) {
                ++this.tick;
            } else {
                super.tick();
            }

        }

        public boolean moveTo(double x, double y, double z, double speedIn) {
            if (this.mob.canFly()) {
                this.mob.getMoveControl().setWantedPosition(x, y, z, speedIn);
                return true;
            } else {
                return super.moveTo(x, y, z, speedIn);
            }
        }

        public boolean moveTo(Entity entityIn, double speedIn) {
            if (this.mob.canFly()) {
                this.mob.getMoveControl().setWantedPosition(entityIn.getX(), entityIn.getY() + (double)this.yMobOffset, entityIn.getZ(), speedIn);
                return true;
            } else {
                return super.moveTo(entityIn, speedIn);
            }
        }
    }

    public class CaracaraMoveControl extends AnimalMoveControl {
        private final Caracara parentEntity;
        private final float speedGeneral;
        private final boolean shouldLookAtTarget;
        private final boolean needsYSupport;

        public CaracaraMoveControl(Caracara bird, float speedGeneral, boolean shouldLookAtTarget, boolean needsYSupport) {
            super(bird, 15);
            this.parentEntity = bird;
            this.shouldLookAtTarget = shouldLookAtTarget;
            this.speedGeneral = speedGeneral;
            this.needsYSupport = needsYSupport;
        }

        public CaracaraMoveControl(Caracara bird, float speedGeneral, boolean shouldLookAtTarget) {
            this(bird, speedGeneral, shouldLookAtTarget, false);
        }

        public void tick() {
            if (this.parentEntity.canFly()) {
                if (this.operation == Operation.MOVE_TO) {
                    Vec3 vector3d = new Vec3(this.wantedX - this.parentEntity.getX(), this.wantedY - this.parentEntity.getY(), this.wantedZ - this.parentEntity.getZ());
                    double d0 = vector3d.length();
                    if (d0 < this.parentEntity.getBoundingBox().getSize()) {
                        this.operation = Operation.WAIT;
                        this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().scale((double)0.5F));
                    } else {
                        this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(this.speedModifier * (double)this.speedGeneral * 0.05 / d0)));
                        if (this.needsYSupport) {
                            double d1 = this.wantedY - this.parentEntity.getY();
                            this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add((double)0.0F, (double)this.parentEntity.getSpeed() * (double)this.speedGeneral * Mth.clamp(d1, (double)-1.0F, (double)1.0F) * (double)0.6F, (double)0.0F));
                        }

                        if (this.parentEntity.getTarget() != null && this.shouldLookAtTarget) {
                            double d2 = this.parentEntity.getTarget().getX() - this.parentEntity.getX();
                            double d1 = this.parentEntity.getTarget().getZ() - this.parentEntity.getZ();
                            this.parentEntity.setYRot(-((float)Mth.atan2(d2, d1)) * (180F / (float)Math.PI));
                            this.parentEntity.yBodyRot = this.parentEntity.getYRot();
                        } else {
                            Vec3 vector3d1 = this.parentEntity.getDeltaMovement();
                            this.parentEntity.setYRot(-((float)Mth.atan2(vector3d1.x, vector3d1.z)) * (180F / (float)Math.PI));
                            this.parentEntity.yBodyRot = this.parentEntity.getYRot();
                        }
                    }
                } else if (this.operation == Operation.STRAFE) {
                    this.operation = Operation.WAIT;
                }
            } else {
                super.tick();
            }

        }

        private boolean canReach(Vec3 p_220673_1_, int p_220673_2_) {
            AABB axisalignedbb = this.parentEntity.getBoundingBox();

            for(int i = 1; i < p_220673_2_; ++i) {
                axisalignedbb = axisalignedbb.move(p_220673_1_);
                if (!this.parentEntity.level().noCollision(this.parentEntity, axisalignedbb)) {
                    return false;
                }
            }

            return true;
        }
    }

    class CaracaraStrollGoal extends RandomStrollGoal {

        public static final float PROBABILITY = 0.001F;
        protected final float probability;

        public CaracaraStrollGoal(PathfinderMob mob, double speedModifier) {
            this(mob, speedModifier, 0.001F);
        }

        public CaracaraStrollGoal(PathfinderMob mob, double speedModifier, float probability) {
            super(mob, speedModifier, 120, false);
            this.probability = probability;
        }

        
        protected Vec3 getPosition() {
            if (this.mob.isInWaterOrBubble()) {
                Vec3 vec3 = LandRandomPos.getPos(this.mob, 15, 7);
                return vec3 == null ? super.getPosition() : vec3;
            } else {
                return this.mob.getRandom().nextFloat() >= this.probability ? LandRandomPos.getPos(this.mob, 15, 7) : super.getPosition();
            }
        }

        public boolean canUse() {
            return !Caracara.this.isFlying() && !Caracara.this.canFly() && Caracara.this.onGround() && super.canUse();
        }

        public boolean canContinueToUse() {
            return !Caracara.this.isFlying() && !Caracara.this.canFly() && Caracara.this.onGround() && super.canContinueToUse();
        }
    }

    public static enum AttackPhase {
        CIRCLE,
        SWOOP;

        private AttackPhase() {
        }
    }

    static class CaracaraStalkPrey extends Goal {
        private final Caracara bird;
        private final double speedModifier;
        
        private LivingEntity prey;
        int stalkingTicks;

        CaracaraStalkPrey(Caracara pBird, double pSpeedModifier) {
            this.bird = pBird;
            this.speedModifier = pSpeedModifier;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        public boolean canUse() {
            this.prey = this.bird.getTarget();
            return this.prey != null && this.bird.attackPhase == AttackPhase.CIRCLE && this.bird.canFly();
        }

        public boolean canContinueToUse() {
            return this.bird.canFly() && this.prey != null && this.bird.distanceToSqr(this.prey.getX(), this.prey.getY() + (double)8.0F, this.prey.getZ()) < (double)256.0F && this.bird.attackPhase == AttackPhase.CIRCLE;
        }

        public void start() {
            this.bird.setAggressive(true);
            this.bird.setDiving(false);
            this.stalkingTicks = 5;
        }

        public void stop() {
            if (this.prey == null) {
                this.bird.getNavigation().stop();
            }

        }

        public void tick() {
            this.bird.getLookControl().setLookAt(this.prey.getX(), this.prey.getY() + (double)8.0F, this.prey.getZ(), (float)this.bird.getMaxHeadYRot(), (float)this.bird.getMaxHeadXRot());
            if (this.bird.distanceToSqr(this.prey.getX(), this.prey.getY() + (double)8.0F, this.prey.getZ()) < 0.75F) {
                --this.stalkingTicks;
                if (this.stalkingTicks < 0) {
                    this.bird.attackPhase = AttackPhase.SWOOP;
                    this.bird.setDiving(true);
                }
            } else {
                this.bird.getMoveControl().setWantedPosition(this.prey.getX(), this.prey.getY() + (double)8.0F, this.prey.getZ(), this.speedModifier);
            }

        }
    }

    public class CaracaraFlyMelee extends Goal {
        private final Caracara bird;
        float circleDistance = 1.0F;
        float yLevel = 2.0F;

        public CaracaraFlyMelee(Caracara pBird) {
            this.bird = pBird;
        }

        public boolean canUse() {
            Entity entity = this.bird.getTarget();
            return entity != null && entity.isAlive() && this.bird.canFly() && this.bird.attackPhase == AttackPhase.SWOOP;
        }

        public void start() {
            this.yLevel = (float)this.bird.getRandom().nextInt(2);
            this.bird.setDiving(true);
        }

        public void stop() {
            this.yLevel = (float)this.bird.getRandom().nextInt(2);
            if (this.bird.onGround()) {
                this.bird.setFlying(false);
            }

            this.bird.setDiving(false);
        }

        public void tick() {
            LivingEntity target = this.bird.getTarget();
            if (target != null) {
                if (this.bird.distanceTo(target) < 3.0F) {
                    this.bird.doHurtTarget(target);
                    this.bird.attackPhase = AttackPhase.CIRCLE;
                    this.bird.setDiving(false);
                    this.stop();
                }

                this.bird.getMoveControl().setWantedPosition(target.getX(), target.getY() + (double)(target.getEyeHeight() / 2.0F), target.getZ(), (double)1.0F);
            }

        }
    }

    private class AIFlyIdle extends Goal {
        protected double x;
        protected double y;
        protected double z;
        private boolean flightTarget;

        public AIFlyIdle() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        public boolean canUse() {
            if (Caracara.this.isOverWaterOrVoid() && !Caracara.this.isPassenger()) {
                this.flightTarget = true;
                Vec3 lvt_1_1_ = this.getPosition();
                if (lvt_1_1_ == null) {
                    return false;
                } else {
                    this.x = lvt_1_1_.x;
                    this.y = lvt_1_1_.y;
                    this.z = lvt_1_1_.z;
                    return true;
                }
            } else if (Caracara.this.canFly() && !Caracara.this.isVehicle() && (Caracara.this.getTarget() == null || !Caracara.this.getTarget().isAlive()) && !Caracara.this.isPassenger()) {
                if (Caracara.this.getRandom().nextInt(45) != 0 && !Caracara.this.isFlying()) {
                    return false;
                } else {
                    this.flightTarget = Caracara.this.canFly();
                    Vec3 lvt_1_1_ = this.getPosition();
                    if (lvt_1_1_ == null) {
                        return false;
                    } else {
                        this.x = lvt_1_1_.x;
                        this.y = lvt_1_1_.y;
                        this.z = lvt_1_1_.z;
                        return true;
                    }
                }
            } else {
                return false;
            }
        }

        public void tick() {
            Caracara.this.getMoveControl().setWantedPosition(this.x, this.y, this.z, (double)0.8F);
            if (!this.flightTarget && Caracara.this.isFlying() && Caracara.this.onGround()) {
                Caracara.this.setFlying(false);
            }

            if (Caracara.this.isFlying() && Caracara.this.onGround() && !Caracara.this.canFly()) {
                Caracara.this.setFlying(false);
            }

        }

        
        protected Vec3 getPosition() {
            Vec3 vector3d = Caracara.this.position();
            return !Caracara.this.canFly() && !Caracara.this.isOverWaterOrVoid() ? Caracara.this.getBlockGrounding(vector3d) : Caracara.this.getBlockInViewAway(vector3d, 10.0F);
        }

        public boolean canContinueToUse() {
            return Caracara.this.isFlying() && Caracara.this.distanceToSqr(this.x, this.y, this.z) > (double)5.0F;
        }

        public void start() {
            Caracara.this.setFlying(true);
            Caracara.this.getMoveControl().setWantedPosition(this.x, this.y, this.z, (double)0.8F);
        }

        public void stop() {
            Caracara.this.getNavigation().stop();
            this.x = (double)0.0F;
            this.y = (double)0.0F;
            this.z = (double)0.0F;
            super.stop();
        }
    }



    class CaracaraLocateNest extends LocateNestGoal {

        public CaracaraLocateNest() {
            super(Caracara.this, 24);
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos blockPos) {
            if (level.getBlockState(blockPos).getBlock() instanceof CaracaraNestBlock nest && creature instanceof INestEggLayer nestEggLayer)
                return nest.isEmpty(level.getBlockState(blockPos)) && level.getBlockState(blockPos).is(nestEggLayer.getNestType());
            return false;
        }
    }

    class CaracaraBuildNestGoal extends BuildNestGoal {
        public CaracaraBuildNestGoal() {
            super(Caracara.this, 1, 0.9, 10);
        }

        @Override
        public boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
            return ((pLevel.getBlockState(pPos).is(Blocks.CACTUS) && pLevel.isEmptyBlock(pPos.above()) && Caracara.this.getNestBuildingTime()>0))
                    || (Caracara.this.getNestBuildingTime()==0 && super.isValidTarget(pLevel, pPos));
        }

        @Override
        public void start() {
            super.start();

            Caracara.this.setFlyTicks(1500);
            Caracara.this.setFlying(true);
            Caracara.this.wantsToFly = true;
        }

        @Override
        protected boolean isReachedTarget() {
            if (super.isReachedTarget()){
                Caracara.this.setFlyTicks(0);
                Caracara.this.setFlying(false);
                Caracara.this.wantsToFly = false;
            }

            return super.isReachedTarget();
        }

        @Override
        protected boolean findNearestBlock() {
            if (Caracara.this.getNestBuildingTime()>0){
                return super.findNearestBlock();
            }else
            {
                int i = 25;
                int j = 10;
                BlockPos blockpos = this.mob.blockPosition();
                BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

                for(int k = j; k >= -j; k--) {
                    for(int l = 0; l < i; ++l) {
                        for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                            for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                                blockpos$mutableblockpos.setWithOffset(blockpos, i1, k, j1);
                                if (this.mob.isWithinRestriction(blockpos$mutableblockpos) && this.isValidTarget(this.mob.level(), blockpos$mutableblockpos)) {
                                    this.blockPos = blockpos$mutableblockpos;
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
        }
    }

    class CaracaraGoToNestGoal extends GoToNestGoal {

        public CaracaraGoToNestGoal(AbstractCornerCreature mob, double speedModifier) {
            super(mob, speedModifier);
        }

        @Override
        protected boolean isReachedTarget() {
            if (super.isReachedTarget()){
                Caracara.this.setFlyTicks(0);
                Caracara.this.setFlying(false);
                Caracara.this.wantsToFly = false;
            }

            return super.isReachedTarget();
        }

        @Override
        public void start() {
            if (this.mob instanceof INestEggLayer nester && nester.hasNest()){
                this.blockPos = nester.getNestPos();
                if (this.mob.level().getBlockState(blockPos).getBlock() instanceof CaracaraNestBlock nestBlock){
                    if (this.mob.level().getBlockState(blockPos).is(nester.getNestType())
                            && nestBlock.isEmpty(this.mob.level().getBlockState(blockPos))){
                        Caracara.this.setFlyTicks(1500);
                        Caracara.this.setFlying(true);
                        Caracara.this.wantsToFly = true;
                        this.moveMobToBlockWithOffset(0, 0.5, 0);
                    }else {
                        nester.setNestPos(null);
                        nester.setNestSearchTime(20*60);
                        nester.setNestBuildingTime(20*60);
                    }
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return CCSounds.CARACARA_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return CCSounds.CARACARA_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return CCSounds.CARACARA_DEATH.get();
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return source.is(DamageTypes.CACTUS) || super.isInvulnerableTo(source);
    }
}
