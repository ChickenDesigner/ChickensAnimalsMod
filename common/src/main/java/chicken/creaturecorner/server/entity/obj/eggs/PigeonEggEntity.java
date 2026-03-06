package chicken.creaturecorner.server.entity.obj.eggs;

import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import chicken.creaturecorner.server.item.CCItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PigeonEggEntity extends BaseThrownEggEntity{
    private static final EntityDataAccessor<Integer> PIGEON_VARIANT = SynchedEntityData.defineId(PigeonEggEntity.class, EntityDataSerializers.INT);

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(PIGEON_VARIANT, 0);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setVariant(compound.getInt("Variant"));
    }

    public void setVariant(int variant) {
        this.getEntityData().set(PIGEON_VARIANT, variant);
    }

    public int getVariant() {
        return this.getEntityData().get(PIGEON_VARIANT);
    }

    public PigeonEggEntity(EntityType<? extends PigeonEggEntity> entityType, Level level) {
        super(entityType, level);
    }

    public PigeonEggEntity(Level level, LivingEntity shooter) {
        super(CCEntities.PIGEON_EGG.get(), level, shooter);
    }

    public PigeonEggEntity(Level level, double x, double y, double z) {
        super(CCEntities.PIGEON_EGG.get(), level, x, y, z);
    }

    @Override
    public boolean onHatch() {
        Pigeon bird = CCEntities.PIGEON.get().create(this.level());
        if (bird != null) {
            bird.setVariant(this.getVariant());
            bird.setAge(-24000);
            bird.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
            if (!bird.fudgePositionAfterSizeChange(ZERO_SIZED_DIMENSIONS)) {
                return true;
            }

            this.level().addFreshEntity(bird);
        }
        return false;
    }

    @Override
    public Item getDefaultItem() {
        return CCItems.PIGEON_EGG_GREY.get();
    }
}
