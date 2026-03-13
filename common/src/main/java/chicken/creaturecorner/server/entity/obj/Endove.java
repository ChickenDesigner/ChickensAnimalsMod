package chicken.creaturecorner.server.entity.obj;

import chicken.creaturecorner.server.block.CCBlocks;
import chicken.creaturecorner.server.block.obj.custom.PigeonNestBlock;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import static chicken.creaturecorner.server.block.obj.custom.PigeonNestBlock.EGG_1;
import static chicken.creaturecorner.server.block.obj.custom.PigeonNestBlock.EGG_2;

public class Endove extends Pigeon {

    public Endove(EntityType<? extends Pigeon> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean isSensitiveToWater() {
        return true;
    }

    public boolean hurt(@NotNull DamageSource pSource, float pAmount) {
        if (this.isInvulnerableTo(pSource)) {
            return false;
        } else {
            boolean flag = pSource.getDirectEntity() instanceof ThrownPotion;
            if (!pSource.is(DamageTypeTags.IS_PROJECTILE) && !flag) {
                boolean flag2 = super.hurt(pSource, pAmount);
                if (!this.level().isClientSide() && !(pSource.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
                    this.teleport();
                }

                return flag2;
            } else {
                boolean flag1 = flag && this.hurtWithCleanWater(pSource, (ThrownPotion) pSource.getDirectEntity(), pAmount);

                for (int i = 0; i < 64; ++i) {
                    if (this.teleport()) {
                        return true;
                    }
                }

                return flag1;
            }
        }
    }

    private boolean hurtWithCleanWater(DamageSource source, ThrownPotion potion, float amount) {
        ItemStack itemstack = potion.getItem();
        PotionContents potioncontents = itemstack.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
        return potioncontents.is(Potions.WATER) && super.hurt(source, amount);
    }

    @Override
    public void aiStep() {
        if (this.level().isClientSide) {
            this.level().addParticle(ParticleTypes.PORTAL, this.getRandomX(0.5), this.getRandomY() - 0.25, this.getRandomZ(0.5), (this.random.nextDouble() - 0.5) * 2.0, -this.random.nextDouble(), (this.random.nextDouble() - 0.5) * 2.0);
        }

        if (this.getLastDamageSource() != null) {
            teleport();
        }

        super.aiStep();
    }


    protected boolean teleport() {
        if (!this.level().isClientSide() && this.isAlive()) {
            double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getY() + (double) (this.random.nextInt(64) - 32);
            double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
            return this.teleport(d0, d1, d2);
        } else {
            return false;
        }
    }

    private boolean teleport(double pX, double pY, double pZ) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(pX, pY, pZ);

        while (blockpos$mutableblockpos.getY() > this.level().getMinBuildHeight() && !this.level().getBlockState(blockpos$mutableblockpos).blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level().getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            Vec3 vec3 = this.position();
            boolean flag2 = this.randomTeleport(pX, pY, pZ, true);
            if (flag2) {
                this.level().gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    this.level().playSound(null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                    this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            }

            return flag2;
        } else {
            return false;
        }
    }

    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel serverLevel, @NotNull AgeableMob ageableMob) {

        Endove entity = (Endove) CCEntities.ENDOVE.get().create(serverLevel);

        if (entity != null) {
            entity.setBaby(true);
        }

        return entity;
    }

    @Override
    public void onEggLaid(Level level, BlockPos pos) {
        if (!this.level().isClientSide()){
            PigeonNestBlock.EggType egg1 = PigeonNestBlock.EggType.ENDOVE;
            PigeonNestBlock.EggType egg2 = this.getRandom().nextBoolean() ? PigeonNestBlock.EggType.EMPTY : PigeonNestBlock.EggType.ENDOVE;

            if (this.hasNest()){
                BlockState blockstate = CCBlocks.ENDOVE_NEST.get().defaultBlockState();

                if (blockstate.getBlock() instanceof PigeonNestBlock){

                    level.setBlockAndUpdate(pos, blockstate.setValue(EGG_1, egg1).setValue(EGG_2, egg2));

                    level.playSound(null, pos, SoundEvents.MOSS_PLACE, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);
                    level.playSound(null, pos, SoundEvents.TURTLE_LAY_EGG, SoundSource.BLOCKS, 0.3F, 0.9F + level.random.nextFloat() * 0.2F);

                    level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(this, blockstate.setValue(EGG_1, egg1).setValue(EGG_2, egg2)));
                }
            }
        }
    }

    public static boolean canEndoveSpawn(EntityType<? extends Mob> animal, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {

        if (!level.getBlockState(pos.below()).isAir() && level.getBlockState(pos).isAir()){

            Endove endove = (Endove) CCEntities.ENDOVE.get().create(level.getLevel());
            if (endove != null) {
                endove.moveTo(pos.getX(), pos.getY(), pos.getZ(), random.nextInt(360), 0.0F);
                endove.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.NATURAL, null);
                level.addFreshEntity(endove);
            }

            return true;
        }

        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return CCSounds.ENDOVE_IDLE.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return CCSounds.ENDOVE_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return CCSounds.ENDOVE_DEATH.get();
    }
}
