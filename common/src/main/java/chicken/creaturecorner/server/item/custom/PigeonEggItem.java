package chicken.creaturecorner.server.item.custom;

import chicken.creaturecorner.server.entity.obj.eggs.EndoveEggEntity;
import chicken.creaturecorner.server.entity.obj.eggs.PigeonEggEntity;
import chicken.creaturecorner.server.item.CCItems;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PigeonEggItem extends BaseEggItem{

    private final int variant;

    public PigeonEggItem(Properties properties, int variant) {
        super(properties);
        this.variant = variant;
    }

    @Override
    public void onEggThrown(Level level, Player player, ItemStack itemstack) {
        PigeonEggEntity thrownegg = new PigeonEggEntity(level, player);

        ItemStack item = switch (variant) {
            case 1 -> new ItemStack(CCItems.PIGEON_EGG_WHITE.get());
            case 2 -> new ItemStack(CCItems.PIGEON_EGG_RED.get());
            default -> new ItemStack(CCItems.PIGEON_EGG_GREY.get());
        };

        thrownegg.setItem(item);
        thrownegg.setVariant(variant);
        thrownegg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
        level.addFreshEntity(thrownegg);
    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        PigeonEggEntity thrownegg = new PigeonEggEntity(level, pos.x(), pos.y(), pos.z());
        thrownegg.setItem(stack);
        ItemStack item = switch (variant) {
            case 1 -> new ItemStack(CCItems.PIGEON_EGG_WHITE.get());
            case 2 -> new ItemStack(CCItems.PIGEON_EGG_RED.get());
            default -> new ItemStack(CCItems.PIGEON_EGG_GREY.get());
        };

        thrownegg.setItem(item);
        return thrownegg;
    }
}
