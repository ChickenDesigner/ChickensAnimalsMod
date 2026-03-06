package chicken.creaturecorner.server.entity.obj.eggs;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

abstract class BaseThrownEggEntity extends ThrowableItemProjectile {
    public static final EntityDimensions ZERO_SIZED_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F);

    public BaseThrownEggEntity(EntityType<? extends BaseThrownEggEntity> entityType, Level level) {
        super(entityType, level);
    }

    public BaseThrownEggEntity(EntityType<? extends BaseThrownEggEntity> entityType, Level level, LivingEntity shooter) {
        super(entityType, shooter, level);
    }

    public BaseThrownEggEntity(EntityType<? extends BaseThrownEggEntity> entityType, Level level, double x, double y, double z) {
        super(entityType, x, y, z, level);
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            double d = 0.08;

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08);
            }
        }

    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 0.0F);
    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            if (this.random.nextInt(8) == 0) {
                int i = 1;
                if (this.random.nextInt(32) == 0) {
                    i = 4;
                }

                for(int j = 0; j < i; ++j) {
                    if (onHatch()) break;
                }
            }

            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    public boolean onHatch() {
        return true;
    }

    public Item getDefaultItem() {
        return Items.EGG;
    }
}
