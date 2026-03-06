package chicken.creaturecorner.server.item.custom;

import chicken.creaturecorner.server.entity.obj.eggs.CaracaraEggEntity;
import chicken.creaturecorner.server.entity.obj.eggs.EndoveEggEntity;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EndoveEggItem extends BaseEggItem{
    public EndoveEggItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onEggThrown(Level level, Player player, ItemStack itemstack) {
        EndoveEggEntity thrownegg = new EndoveEggEntity(level, player);
        thrownegg.setItem(itemstack);
        thrownegg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
        level.addFreshEntity(thrownegg);
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        EndoveEggEntity thrownegg = new EndoveEggEntity(level, pos.x(), pos.y(), pos.z());
        thrownegg.setItem(stack);
        return thrownegg;
    }
}
