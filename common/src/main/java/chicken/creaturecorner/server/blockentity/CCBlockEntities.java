package chicken.creaturecorner.server.blockentity;

import chicken.creaturecorner.platform.Services;
import chicken.creaturecorner.server.block.CCBlocks;
import chicken.creaturecorner.server.blockentity.custom.CCHangingSignBlockEntity;
import chicken.creaturecorner.server.blockentity.custom.CCSignBlockEntity;
import chicken.creaturecorner.server.blockentity.custom.PigeonLoftBlockEntity;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class CCBlockEntities {
    public static final Supplier<BlockEntityType<CCHangingSignBlockEntity>> HANGING_SIGN = register("hanging_sign",
            () -> Services.GENERIC.createBEType(CCHangingSignBlockEntity::new));

    public static final Supplier<BlockEntityType<CCSignBlockEntity>> SIGN = register("sign",
            () -> Services.GENERIC.createBEType(CCSignBlockEntity::new));

    public static final Supplier<BlockEntityType<PigeonLoftBlockEntity>> PIGEON_LOFT = register("pigeon_loft_entity",
            () -> Services.GENERIC.createBEType(PigeonLoftBlockEntity::new, CCBlocks.PIGEON_LOFT.get()));

    public static<T extends BlockEntity> Supplier<BlockEntityType<T>> register(String s, Supplier<BlockEntityType<T>> block) {
        block = Suppliers.memoize(block);
        Services.PLATFORM.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, s, block::get);
        return block;
    }
}
