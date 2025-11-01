package chicken.creaturecorner.server.block.obj.custom;

import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.GallianEntity;
import chicken.creaturecorner.server.sound.CCSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class GallianEggBlock extends Block {

    public static final IntegerProperty HATCH;
    private static final VoxelShape SHAPE = Block.box(5, 0, 5, 11, 8, 11);

    public GallianEggBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HATCH, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HATCH);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public int getHatchLevel(BlockState state) {
        return state.getValue(HATCH);
    }

    private boolean isReadyToHatch(BlockState state) {
        return this.getHatchLevel(state) == 2;
    }

//    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
//        if (!this.isReadyToHatch(state)) {
//            level.playSound(null, pos, CCSounds.GALLIAN_EGG_CRACK.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
//            level.setBlock(pos, state.setValue(HATCH, this.getHatchLevel(state) + 1), 2);
//        } else {
//            level.playSound(null, pos, CCSounds.GALLIAN_EGG_HATCH.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
//            level.destroyBlock(pos, false);
//            GallianEntity gallian = CCEntities.GALLIAN.get().create(level);
//            if (gallian != null) {
//                Vec3 vec3 = pos.getCenter();
//                gallian.setBaby(true);
//                gallian.tameFromHatching();
//                gallian.moveTo(vec3.x(), vec3.y(), vec3.z(), Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);
//                level.addFreshEntity(gallian);
//            }
//        }
//    }


    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (this.shouldUpdateHatchLevel(level)) {
            int i = (Integer)state.getValue(HATCH);

            if (i < 2) {
                level.playSound(null, pos, CCSounds.GALLIAN_EGG_CRACK.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
                level.setBlock(pos, state.setValue(HATCH, this.getHatchLevel(state) + 1), 2);
                level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(state));
            } else {
                level.playSound(null, pos, CCSounds.GALLIAN_EGG_HATCH.get(), SoundSource.BLOCKS, 0.7F, 0.9F + random.nextFloat() * 0.2F);
                level.removeBlock(pos, false);
                level.gameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Context.of(state));

                level.levelEvent(2001, pos, Block.getId(state));
                GallianEntity gallian = CCEntities.GALLIAN.get().create(level);
                if (gallian != null) {
                    Vec3 vec3 = pos.getCenter();
                    gallian.setBaby(true);
//                    gallian.tameFromHatching();
                    gallian.moveTo(vec3.x(), vec3.y(), vec3.z(), Mth.wrapDegrees(level.random.nextFloat() * 360.0F), 0.0F);
                    level.addFreshEntity(gallian);
                }
            }
        }
    }

    private boolean shouldUpdateHatchLevel(Level level) {
        float f = level.getTimeOfDay(1.0F);
        return level.random.nextInt(500) == 0;
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean movedByPiston) {
        boolean flag = hatchBoost(level, pos);
        if (!level.isClientSide() && flag) {
            level.levelEvent(3009, pos, 0);
        }
        level.gameEvent(GameEvent.BLOCK_PLACE, pos, GameEvent.Context.of(state));
    }

    public boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public static boolean hatchBoost(BlockGetter level, BlockPos pos) {
        return level.getBlockState(pos.below()).is(BlockTags.SNIFFER_EGG_HATCH_BOOST);
    }

    static {
        HATCH = BlockStateProperties.HATCH;
    }
}

