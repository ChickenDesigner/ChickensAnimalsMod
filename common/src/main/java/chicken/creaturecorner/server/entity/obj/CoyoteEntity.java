package chicken.creaturecorner.server.entity.obj;

import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.control.AnimalMoveControl;
import chicken.creaturecorner.server.entity.obj.base.GeoTamableEntity;
import chicken.creaturecorner.server.entity.obj.base.goal.LookForFoodGoal;
import chicken.creaturecorner.server.entity.obj.goal.ModSitWhenOrdererdGoal;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.ResetUniversalAngerTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class CoyoteEntity extends GeoTamableEntity implements NeutralMob {

    public final net.minecraft.world.entity.AnimationState scratchAnimationState = new net.minecraft.world.entity.AnimationState();
    public final net.minecraft.world.entity.AnimationState idleAnimationState = new net.minecraft.world.entity.AnimationState();
    public final net.minecraft.world.entity.AnimationState idleTongueAnimationState = new net.minecraft.world.entity.AnimationState();
    public final net.minecraft.world.entity.AnimationState howlAnimationState = new net.minecraft.world.entity.AnimationState();
    private int scratchTimeout;
    
    private static final UniformInt PERSISTENT_ANGER_TIME = TimeUtil.rangeOfSeconds(20, 39);
    private UUID persistentAngerTarget;
//    private boolean attackedOnce;
//    private boolean shouldAttackOnce;
    public int prevScratchTime;
    private final int scratchAnimTime = 83;
    private LookForFoodGoal forFoodGoal;
    private static final EntityDataAccessor<Integer> DATA_REMAINING_ANGER_TIME;
    private static final EntityDataAccessor<Integer> VARIANT;
    private static final EntityDataAccessor<Integer> SCRATCHING_TIME;
    private static final EntityDataAccessor<Boolean> SCRATCHING;

    public CoyoteEntity(EntityType<? extends CoyoteEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        //this.setTame(false, false);
        this.lookControl = new CoyoteLookControl(this);
        this.moveControl = new CoyoteMoveControl(this);
        this.setPathfindingMalus(PathType.DANGER_OTHER, 0.0F);
    }

    protected void registerGoals() {
        this.forFoodGoal = new LookForFoodGoal(this, ItemTags.MEAT);
        this.goalSelector.addGoal(3, this.forFoodGoal);
        this.goalSelector.addGoal(1, new FloatGoal(this));
        //this.goalSelector.addGoal(1, new GeoTamableEntity.TamableAnimalPanicGoal((double) 1.5F, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new ModSitWhenOrdererdGoal(this));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, (double) 2.0F, true));
        this.goalSelector.addGoal(5, new CoyoteAvoidGoal<Player>(this, Player.class, 6.0F, 1.2f, 1.5f));
        this.goalSelector.addGoal(7, new BreedGoal(this, (double) 1.0F));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, (double) 1.0F) {
            public boolean canUse() {
                return !CoyoteEntity.this.orderedToSit && !CoyoteEntity.this.isScratching() && super.canUse();
            }

            public boolean canContinueToUse() {
                return !CoyoteEntity.this.orderedToSit && !CoyoteEntity.this.isScratching() && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(9, new TemptGoal(this, (double) 1.1F, Ingredient.of(new ItemLike[]{Items.CHICKEN}), false) {
            public boolean canUse() {
                return CoyoteEntity.this.canMove() && super.canUse();
            }

            public boolean canContinueToUse() {
                return CoyoteEntity.this.canMove() && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(10, new RandomLookAroundGoal(this));

        //this.targetSelector.addGoal(2, (new CoyoteHurtByTargetGoal(this)));

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Player.class, 10, true, false, this::isAngryAt));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)));
        this.targetSelector.addGoal(8, new ResetUniversalAngerTargetGoal<>(this, true));

        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Pigeon.class, false, (living) -> this.isHungry()));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Sheep.class, false, (entity) -> entity.isBaby() && this.isHungry()));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Chicken.class, false, (living) -> this.isHungry()));
        this.targetSelector.addGoal(7, new NearestAttackableTargetGoal<>(this, Rabbit.class, false, (living) -> this.isHungry()));

    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, (double) 10.0F).add(Attributes.ATTACK_DAMAGE, (double) 3.0F).add(Attributes.MOVEMENT_SPEED, 0.16).add(Attributes.ATTACK_KNOCKBACK, 0.8);
    }

    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(Items.CHICKEN);
    }

    boolean canMove() {
        return !this.isScratching() && !this.orderedToSit;
    }

    @Override
    protected boolean isImmobile() {
        return super.isImmobile() || this.isScratching() || this.isOrderedToSit();
    }

    public void tick() {
        if (this.level().isClientSide()){
            this.setupAnimationStates();
        }
        super.tick();
        if (!this.isAggressive()) {
            if (this.getRandom().nextInt(5000) == 0 && !this.isScratching() && this.onGround() && !this.orderedToSit && this.navigation.isDone()) {
                this.setScratchingTime(83);
            }

            if (this.getScratchingTime() > 0) {
                this.goalSelector.getAvailableGoals().forEach(WrappedGoal::stop);
                this.getNavigation().stop();
                this.prevScratchTime = this.getScratchingTime();
                this.setScratchingTime(this.prevScratchTime - 1);

                if (this.isOrderedToSit())
                    this.setScratchingTime(0);
            }
        }

    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, 0);
        builder.define(DATA_REMAINING_ANGER_TIME, 0);
        builder.define(SCRATCHING_TIME, 0);
        builder.define(SCRATCHING, false);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(pCompound.getInt("Variant"));
        this.setScratchingTime(pCompound.getInt("scratchingTime"));
    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getVariant());
        pCompound.putInt("scratchingTime", this.getScratchingTime());
    }

    public int getScratchingTime() {
        return (Integer) this.entityData.get(SCRATCHING_TIME);
    }

    public void setScratchingTime(int scratchingTime) {
        this.entityData.set(SCRATCHING_TIME, scratchingTime);
    }

    public boolean isScratching() {
        return this.getScratchingTime()>0;
    }


    private void setVariant(int variant) {
        this.entityData.set(VARIANT, variant);
    }

    public int getVariant() {
        return this.entityData.get(VARIANT);
    }

    public void travel(Vec3 pTravelVector) {
        if (this.isScratching()) {
            if (this.getNavigation().isDone()) {
                this.getNavigation().stop();
            }

            super.travel(Vec3.ZERO);
        } else {
            super.travel(pTravelVector);
        }

    }

    public void swing(InteractionHand hand) {
        super.swing(hand);
//        if (this.shouldAttackOnce) {
//            this.shouldAttackOnce = false;
//            this.attackedOnce = true;
//            this.forgetCurrentTargetAndRefreshUniversalAnger();
//        }

    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (this.level().isClientSide && (!this.isBaby() || !this.isFood(itemstack))) {
            boolean flag = this.isOwnedBy(player) || this.isTame() || this.isFood(itemstack) && !this.isTame() && !this.isAngry();
            return flag ? InteractionResult.CONSUME : InteractionResult.PASS;
        } else if (this.isTame()) {
            if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
                float f = foodproperties != null ? (float) foodproperties.nutrition() : 1.0F;
                this.heal(2.0F * f);
                itemstack.consume(1, player);
                this.gameEvent(GameEvent.EAT);
                return InteractionResult.sidedSuccess(this.level().isClientSide());
            } else {
                InteractionResult interactionresult = super.mobInteract(player, hand);
                if (!interactionresult.consumesAction() && this.isOwnedBy(player)) {
                    this.setOrderedToSit(!this.isOrderedToSit());
                    this.setInSittingPose(this.isOrderedToSit());
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget(null);
                    return InteractionResult.SUCCESS_NO_ITEM_USED;
                } else {
                    return interactionresult;
                }
            }
        } else {
            return super.mobInteract(player, hand);
        }
    }

    public boolean canPickUpLoot() {
        return this.isHungry();
    }

    protected void starve() {
        this.triggerFoodSearch();
    }

    public boolean hasHunger() {
        return !this.isTame();
    }

    private void triggerFoodSearch() {
        if (this.forFoodGoal != null) {
            this.forFoodGoal.trigger();
        } else {
            this.navigation.stop();
            Predicate<ItemEntity> predicate = (p_25258_) -> p_25258_.getItem().is(ItemTags.MEAT);
            List<? extends ItemEntity> list = this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate((double) 32.0F, (double) 8.0F, (double) 32.0F), predicate);
            if (!list.isEmpty()) {
                this.navigation.moveTo((Entity) list.getFirst(), 1.1);
            }
        }

    }

    public int maxFood() {
        return 100;
    }

    public boolean killedEntity(ServerLevel level, LivingEntity entity) {
        if (!(entity instanceof Player)) {
            this.killed(entity);
        }

        return super.killedEntity(level, entity);
    }

    public void killed(LivingEntity entity) {
        int food = this.getFoodLevel();
        if (entity instanceof Sheep) {
            this.setFoodLevel(food + 75);
        } else {
            this.setFoodLevel(food + 25);
        }

    }

    public void customServerAiStep() {
        if (this.getMoveControl().hasWanted()) {
            double d0 = this.getMoveControl().getSpeedModifier();
            this.setPose(Pose.STANDING);
            this.setSprinting(d0 >= 1.25D);
        } else {
            this.setPose(Pose.STANDING);
            this.setSprinting(false);
        }

        super.customServerAiStep();
    }

    public void aiStep() {
        ItemStack stack = this.getItemBySlot(EquipmentSlot.MAINHAND);
        if (stack != null && stack.is(ItemTags.MEAT) && this.isHungry()) {
            this.setFoodLevel(this.getFoodLevel() + 50);
            this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, stack), this.getX(), this.getY(), this.getZ(), (double) 0.0F, (double) 0.0F, (double) 0.0F);
            this.level().playSound((Player) null, this.getX(), this.getY(), this.getZ(), SoundEvents.GENERIC_EAT, SoundSource.AMBIENT);
            stack.setCount(0);
            this.setItemInHand(InteractionHand.MAIN_HAND, Items.AIR.getDefaultInstance());
        }

        if (this.isAlmostStarving() && (double) this.random.nextFloat() <= 0.2) {
            this.triggerFoodSearch();
        }

        Vec3 vec3 = this.getDeltaMovement();
        if ((this.isOrderedToSit() || this.isScratching()) && !this.navigation.isDone()) {
            this.setDeltaMovement(vec3.multiply((double) 0.0F, (double) 1.0F, (double) 0.0F));
        }

        super.aiStep();
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

    public boolean shouldTryTeleportToOwner() {
        return false;
    }

    public void spawnChildFromBreeding(ServerLevel level, Animal mate) {
        AgeableMob ageablemob = this.getBreedOffspring(level, mate);
        if (ageablemob != null) {
            ageablemob.setBaby(true);
            ageablemob.moveTo(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            if (ageablemob instanceof GeoTamableEntity) {
                GeoTamableEntity entity = (GeoTamableEntity) ageablemob;
                Player matePlayer = mate.getLoveCause();
                Player myPlayer = this.getLoveCause();
                if (matePlayer != null && myPlayer != null && matePlayer == myPlayer) {
                    entity.tame(myPlayer);
                }
            }

            this.finalizeSpawnChildFromBreeding(level, mate, ageablemob);
            level.addFreshEntityWithPassengers(ageablemob);
        }

    }

    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target);
    }

    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        CoyoteEntity baby = CCEntities.COYOTE.get().create(serverLevel);

        if (baby != null && ageableMob instanceof CoyoteEntity otherParent) {
            if (this.random.nextInt(0, 10) == 0)
                baby.setVariant(3);
            else {
                if (this.getRandom().nextBoolean())
                    baby.setVariant(this.getVariant());
                else
                    baby.setVariant(otherParent.getVariant());
            }
        }

        return baby;
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, SpawnGroupData spawnGroupData) {

        Holder<Biome> holder = level.getBiome(this.blockPosition());

        if (holder.is(BiomeTags.SPAWNS_COLD_VARIANT_FROGS) && holder.is(BiomeTags.IS_OVERWORLD) && this.getRandom().nextInt(0, 10) == 0)
            this.setVariant(3);
        else
            this.setVariant(this.random.nextInt(0, 3));

        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    public String getVariantName() {
        return switch (this.getVariant()) {
            case 1 -> "rusty";
            case 2 -> "jackal";
            case 3 -> "white";
            default -> "orange";
        };
    }

    public int getMaxHeadXRot() {
        return 16;
    }

    public int getMaxHeadYRot() {
        return 16;
    }

    private void setupAnimationStates() {

        this.idleAnimationState.animateWhen(true, this.tickCount);
        this.idleTongueAnimationState.animateWhen(this.isAlive() && this.isTame(), this.tickCount);

        if(this.isScratching() && scratchTimeout <= 0) {
            scratchTimeout = 82;
            scratchAnimationState.start(this.tickCount);
        } else {
            --this.scratchTimeout;
        }

    }

    public int getRemainingPersistentAngerTime() {
        return this.entityData.get(DATA_REMAINING_ANGER_TIME);
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

    public boolean hurt(DamageSource source, float amount) {
        if (!this.level().isClientSide) {
            if (this.isTame() && !source.is(DamageTypes.THORNS)) {
                Entity var4 = source.getDirectEntity();
                if (var4 instanceof Player owner) {
                    if (this.getOwner() == owner) {
                        if (!owner.getAbilities().instabuild) {
                            this.playSound(SoundEvents.PANDA_BITE);

                            owner.hurt(this.damageSources().thorns(this), 2.0F);

                            this.lookControl.setLookAt(owner);
                        }
                    }
                }
            }
        }
        return super.hurt(source, amount);
    }

    static {
        DATA_REMAINING_ANGER_TIME = SynchedEntityData.defineId(CoyoteEntity.class, EntityDataSerializers.INT);
        VARIANT = SynchedEntityData.defineId(CoyoteEntity.class, EntityDataSerializers.INT);
        SCRATCHING_TIME = SynchedEntityData.defineId(CoyoteEntity.class, EntityDataSerializers.INT);
        SCRATCHING = SynchedEntityData.defineId(CoyoteEntity.class, EntityDataSerializers.BOOLEAN);
    }

    public static class CoyoteLookControl extends LookControl {
        CoyoteEntity coyote;

        public CoyoteLookControl(CoyoteEntity pCoyote) {
            super(pCoyote);
            this.coyote = pCoyote;
        }

        public void tick() {
            if (!this.coyote.isScratching()) {
                super.tick();
            }

        }
    }

    static class CoyoteMoveControl extends AnimalMoveControl {
        CoyoteEntity coyote;

        public CoyoteMoveControl(CoyoteEntity pCoyote) {
            super(pCoyote, 6);
            this.coyote = pCoyote;
        }

        public void tick() {
            if (this.coyote.canMove()) {
                super.tick();
            }

        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return CCSounds.COYOTE_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return CCSounds.COYOTE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return CCSounds.COYOTE_DEATH.get();
    }

    public boolean isCowardly(){
        return this.getLastHurtByMob() == null && !this.isTame();
    }

    class CoyoteAvoidGoal<T extends LivingEntity> extends AvoidEntityGoal<T>{

        private final CoyoteEntity Coyote;

        public CoyoteAvoidGoal(CoyoteEntity pCoyote, Class<T> pEntityClassToAvoid, float pMaxDist, double pWalkSpeedModifier, double pSprintSpeedModifier) {
            super(pCoyote, pEntityClassToAvoid, pMaxDist, pWalkSpeedModifier, pSprintSpeedModifier, EntitySelector.NO_SPECTATORS::test);
            this.Coyote = pCoyote;
        }

        public boolean canUse() {
            if (super.canUse()){
                return this.Coyote.isCowardly();
            }else {
                return false;
            }
        }

        public boolean canContinueToUse() {
            return super.canContinueToUse() && this.Coyote.isCowardly();
        }

//        public void start() {
//            CoyoteEntity.this.setTarget(null);
//            super.start();
//        }

//        public void tick() {
//            CoyoteEntity.this.setTarget(null);
//            super.tick();
//        }
    }


    public static boolean checkCoyoteSpawnRules(EntityType<CoyoteEntity> entityType, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).is(BlockTags.ARMADILLO_SPAWNABLE_ON) && isBrightEnoughToSpawn(level, pos);
    }



}
