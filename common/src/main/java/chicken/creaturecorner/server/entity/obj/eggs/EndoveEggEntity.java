package chicken.creaturecorner.server.entity.obj.eggs;

import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.Endove;
import chicken.creaturecorner.server.item.CCItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EndoveEggEntity extends BaseThrownEggEntity{

    public EndoveEggEntity(EntityType<? extends EndoveEggEntity> entityType, Level level) {
        super(entityType, level);
    }

    public EndoveEggEntity(Level level, LivingEntity shooter) {
        super(CCEntities.ENDOVE_EGG.get(), level, shooter);
    }

    public EndoveEggEntity(Level level, double x, double y, double z) {
        super(CCEntities.ENDOVE_EGG.get(), level, x, y, z);
    }

    @Override
    public boolean onHatch() {
        Endove bird = CCEntities.ENDOVE.get().create(this.level());
        if (bird != null) {
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
        return CCItems.ENDOVE_EGG.get();
    }
}
