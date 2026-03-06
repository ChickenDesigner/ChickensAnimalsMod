package chicken.creaturecorner.server.block.obj.custom;

import chicken.creaturecorner.server.block.CCBlocks;
import chicken.creaturecorner.server.block.obj.custom.base.INestBlock;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.CaracaraEntity;
import chicken.creaturecorner.server.entity.obj.Endove;
import chicken.creaturecorner.server.entity.obj.NewPigeonEntity;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import chicken.creaturecorner.server.item.CCItems;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.function.IntFunction;

public class PigeonNestBlock extends Block implements INestBlock {

    public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
    public static final EnumProperty<EggType> EGG_1 = EnumProperty.create("egg_1", EggType.class);
    public static final EnumProperty<EggType> EGG_2 = EnumProperty.create("egg_2", EggType.class);

    public PigeonNestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, 0).setValue(EGG_1, EggType.EMPTY).setValue(EGG_2, EggType.EMPTY));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH, EGG_1, EGG_2);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Block.box(0, 0, 0, 16, 8, 16);
    }

    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (this.shouldUpdateHatchLevel(level, state)) {
            int i = state.getValue(HATCH);

            if (i < 2) {
                level.playSound(null, pos, CCSounds.GALLIAN_EGG_CRACK.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
                level.setBlock(pos, state.setValue(HATCH, this.getHatchLevel(state) + 1), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
            } else {
                level.playSound(null, pos, CCSounds.GALLIAN_EGG_HATCH.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);

                level.levelEvent(2001, pos, Block.getId(state));

                if (this.getEgg1(state) != EggType.EMPTY){

                    if (this.getEgg1(state) == EggType.ENDOVE){
                        Endove pigeon = CCEntities.ENDOVE.get().create(level);
                        if (pigeon != null) {
                            Vec3 vec3 = pos.getCenter();
                            pigeon.setBaby(true);

                            pigeon.moveTo(vec3.x() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    vec3.y()+0.5, vec3.z() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

                            level.addFreshEntity(pigeon);
                        }
                    }else {
                        Pigeon pigeon = CCEntities.PIGEON.get().create(level);
                        if (pigeon != null) {

                            switch (this.getEgg1(state)){
                                case WHITE -> pigeon.setVariant(1);
                                case RED -> pigeon.setVariant(2);
                                default -> pigeon.setVariant(0);
                            }

                            Vec3 vec3 = pos.getCenter();
                            pigeon.setBaby(true);

                            pigeon.moveTo(vec3.x() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    vec3.y()+0.5, vec3.z() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

                            level.addFreshEntity(pigeon);
                        }
                    }
                }

                if (this.getEgg2(state) != EggType.EMPTY){

                    if (this.getEgg2(state) == EggType.ENDOVE){
                        Endove pigeon = CCEntities.ENDOVE.get().create(level);
                        if (pigeon != null) {
                            Vec3 vec3 = pos.getCenter();
                            pigeon.setBaby(true);

                            pigeon.moveTo(vec3.x() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    vec3.y()+0.5, vec3.z() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

                            level.addFreshEntity(pigeon);
                        }
                    }else {
                        Pigeon pigeon = CCEntities.PIGEON.get().create(level);
                        if (pigeon != null) {

                            switch (this.getEgg2(state)){
                                case WHITE -> pigeon.setVariant(1);
                                case RED -> pigeon.setVariant(2);
                                default -> pigeon.setVariant(0);
                            }

                            Vec3 vec3 = pos.getCenter();
                            pigeon.setBaby(true);

                            pigeon.moveTo(vec3.x() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    vec3.y()+0.5, vec3.z() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                    Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

                            level.addFreshEntity(pigeon);
                        }
                    }
                }

                level.setBlock(pos, state.setValue(EGG_1, EggType.EMPTY).setValue(EGG_2, EggType.EMPTY).setValue(HATCH, 0),  2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
            }
        }
    }

    private boolean shouldUpdateHatchLevel(Level level, BlockState state) {
        return ((level.dimension() == level.OVERWORLD && level.isDay()) || (level.dimension() == level.END && state.is(CCBlocks.ENDOVE_NEST.get())))
                && !this.isEmpty(state) && level.random.nextInt(200) == 0;
    }

    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity te, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, te, stack);

        if (state.getValue(EGG_1) != EggType.EMPTY){
            popResource(level, pos, new ItemStack(state.getValue(EGG_1).eggType));
        }
        if (state.getValue(EGG_2) != EggType.EMPTY){
            popResource(level, pos, new ItemStack(state.getValue(EGG_2).eggType));
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (stack.isEmpty() && state.getValue(EGG_1) != EggType.EMPTY || state.getValue(EGG_2) != EggType.EMPTY) {

            if (state.getValue(EGG_2) != EggType.EMPTY){
                popResource(level, pos, new ItemStack(state.getValue(EGG_2).eggType));
                level.setBlock(pos, state.setValue(EGG_2, EggType.EMPTY),  2);
            }else if (state.getValue(EGG_1) != EggType.EMPTY){
                popResource(level, pos, new ItemStack(state.getValue(EGG_1).eggType));
                level.setBlock(pos, state.setValue(EGG_1, EggType.EMPTY),  2);
            }

            return ItemInteractionResult.SUCCESS;

        } else if (stack.is(CCItems.CARACARA_EGG.get()) && state.getValue(EGG_1) == EggType.EMPTY || state.getValue(EGG_2) == EggType.EMPTY) {


            if (state.getValue(EGG_1) == EggType.EMPTY){
                if (stack.is(CCItems.PIGEON_EGG_RED.get()))
                    level.setBlock(pos, state.setValue(EGG_1, EggType.RED),  2);
                else if (stack.is(CCItems.PIGEON_EGG_WHITE.get()))
                    level.setBlock(pos, state.setValue(EGG_1, EggType.WHITE),  2);
                else if (stack.is(CCItems.PIGEON_EGG_GREY.get()))
                    level.setBlock(pos, state.setValue(EGG_1, EggType.GREY),  2);
                else if (stack.is(CCItems.ENDOVE_EGG.get()))
                    level.setBlock(pos, state.setValue(EGG_1, EggType.ENDOVE),  2);
            } else if (state.getValue(EGG_2) == EggType.EMPTY){
                if (stack.is(CCItems.PIGEON_EGG_RED.get()))
                    level.setBlock(pos, state.setValue(EGG_2, EggType.RED),  2);
                else if (stack.is(CCItems.PIGEON_EGG_WHITE.get()))
                    level.setBlock(pos, state.setValue(EGG_2, EggType.WHITE),  2);
                else if (stack.is(CCItems.PIGEON_EGG_GREY.get()))
                    level.setBlock(pos, state.setValue(EGG_2, EggType.GREY),  2);
                else if (stack.is(CCItems.ENDOVE_EGG.get()))
                    level.setBlock(pos, state.setValue(EGG_2, EggType.ENDOVE),  2);
            }

            if (!player.getAbilities().instabuild)
                stack.shrink(1);

            return ItemInteractionResult.SUCCESS;
        }else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    public int getHatchLevel(BlockState state) {
        return state.getValue(HATCH);
    }

    public EggType getEgg1(BlockState state) {
        return state.getValue(EGG_1);
    }

    public EggType getEgg2(BlockState state) {
        return state.getValue(EGG_1);
    }

    @Override
    public boolean isEmpty(BlockState state) {
        return this.getEgg1(state) == EggType.EMPTY && this.getEgg2(state) == EggType.EMPTY;
    }

    public enum EggType implements StringRepresentable {
        EMPTY("empty", Items.AIR),
        WHITE("white", CCItems.PIGEON_EGG_WHITE.get()),
        RED("red", CCItems.PIGEON_EGG_RED.get()),
        GREY("grey", CCItems.PIGEON_EGG_RED.get()),
        ENDOVE("endove", CCItems.ENDOVE_EGG.get());

        private final String name;
        private final Item eggType;

        private EggType(String name, Item eggType) {
            this.name = name;
            this.eggType = eggType;
        }

        public String getSerializedName() {
            return this.name;
        }

        public Item getEggItem() {
            return this.eggType;
        }
    }
}
