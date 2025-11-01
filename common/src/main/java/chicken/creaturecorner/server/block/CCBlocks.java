package chicken.creaturecorner.server.block;

import chicken.creaturecorner.platform.Services;
import chicken.creaturecorner.server.block.obj.custom.GallianEggBlock;
import chicken.creaturecorner.server.item.CCItems;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CCBlocks {


    public static final Supplier<Block> GALLIAN_EGG = register("gallian_egg",
            () -> new GallianEggBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TURTLE_EGG)));


    public static Supplier<Block> register(String s, Supplier<Block> block) {
        block = Suppliers.memoize(block);
        Services.PLATFORM.register(BuiltInRegistries.BLOCK, s, block);
        Supplier<Block> finalBlock = block;
        Services.PLATFORM.register(BuiltInRegistries.ITEM, s, () -> new BlockItem(finalBlock.get(), new Item.Properties()));
        return block;
    }

    public static Supplier<Block> registerNoItem(String s, Supplier<Block> block) {
        block = Suppliers.memoize(block);
        Services.PLATFORM.register(BuiltInRegistries.BLOCK, s, block);
        return block;
    }
}
