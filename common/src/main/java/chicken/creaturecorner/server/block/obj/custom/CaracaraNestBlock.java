package chicken.creaturecorner.server.block.obj.custom;

import chicken.creaturecorner.server.block.obj.custom.base.INestBlock;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.CaracaraEntity;
import chicken.creaturecorner.server.item.CCItems;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CaracaraNestBlock extends Block implements INestBlock {

    public static final IntegerProperty HATCH = BlockStateProperties.HATCH;
    public static final IntegerProperty EGGS = IntegerProperty.create("caracara_eggs", 0, 3);

    public CaracaraNestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, 0).setValue(EGGS, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH, EGGS);
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

                for (int j = this.getEggs(state); j > 0; j--){
                    CaracaraEntity caracara = CCEntities.CARACARA.get().create(level);
                    if (caracara != null) {
                        Vec3 vec3 = pos.getCenter();
                        caracara.setBaby(true);

                        caracara.moveTo(vec3.x() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                vec3.y()+0.5, vec3.z() + (level.random.nextBoolean() ? 0.15 : -0.15),
                                Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);

                        level.addFreshEntity(caracara);
                    }
                }

                level.setBlock(pos, state.setValue(EGGS, 0).setValue(HATCH, 0),  2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
            }
        }
    }

    private boolean shouldUpdateHatchLevel(Level level, BlockState state) {
        float f = level.getTimeOfDay(1.0F);
        return this.getEggs(state) > 0 && (f < 0.69 && (double)f > 0.65 || level.random.nextInt(100) == 0);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        for (int i = this.getEggs(state); i > 0; i--){
            popResource(level, pos, new ItemStack(CCItems.CARACARA_EGG.get()));
        }
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (!stack.is(CCItems.CARACARA_EGG.get()) && state.getValue(EGGS)>0) {
            popResource(level, pos, new ItemStack(CCItems.CARACARA_EGG.get()));

            level.setBlock(pos, state.setValue(EGGS, Math.max(0, this.getEggs(state)-1)),  2);

            return ItemInteractionResult.SUCCESS;
        } else if (stack.is(CCItems.CARACARA_EGG.get()) && state.getValue(EGGS)<3) {
            if (!player.getAbilities().instabuild)
                stack.shrink(1);

            level.setBlock(pos, state.setValue(EGGS, Math.min(3, this.getEggs(state)+1)),  2);

            return ItemInteractionResult.SUCCESS;
        }else {
            return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
        }
    }

    public int getHatchLevel(BlockState state) {
        return state.getValue(HATCH);
    }

    public int getEggs(BlockState state) {
        return state.getValue(EGGS);
    }

    @Override
    public boolean isEmpty(BlockState state) {
        return this.getEggs(state) == 0;
    }
}
