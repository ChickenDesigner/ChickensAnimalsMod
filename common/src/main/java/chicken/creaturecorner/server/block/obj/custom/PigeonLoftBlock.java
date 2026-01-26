package chicken.creaturecorner.server.block.obj.custom;

import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.blockentity.custom.PigeonLoftBlockEntity;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class PigeonLoftBlock extends BaseEntityBlock {

    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final BooleanProperty UP = PipeBlock.UP;
    public static final BooleanProperty DOWN = PipeBlock.DOWN;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty PIGEONS = IntegerProperty.create("pigeons", 0, 1);
    public static final EnumProperty<PigeonType> PIGEON_TYPE = EnumProperty.create("pigeon_type", PigeonType.class);

    public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Util.make(Maps.newEnumMap(Direction.class), (p_55164_) -> {
        p_55164_.put(Direction.NORTH, NORTH);
        p_55164_.put(Direction.EAST, EAST);
        p_55164_.put(Direction.SOUTH, SOUTH);
        p_55164_.put(Direction.WEST, WEST);
        p_55164_.put(Direction.UP, UP);
        p_55164_.put(Direction.DOWN, DOWN);
    }));


    public PigeonLoftBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, false)
                .setValue(EAST, false)
                .setValue(SOUTH, false)
                .setValue(WEST, false)
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(PIGEONS, 0)
                .setValue(FACING, Direction.NORTH)
                .setValue(PIGEON_TYPE, PigeonType.ADULT_GREY));
    }

    public static final MapCodec<PigeonLoftBlock> CODEC = simpleCodec(PigeonLoftBlock::new);

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return true;
    }

    public BlockState rotate(BlockState pState, Rotation pRotation) {
        switch (pRotation) {
            case CLOCKWISE_180:
                return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING))).setValue(NORTH, pState.getValue(SOUTH)).setValue(EAST, pState.getValue(WEST)).setValue(SOUTH, pState.getValue(NORTH)).setValue(WEST, pState.getValue(EAST));
            case COUNTERCLOCKWISE_90:
                return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING))).setValue(NORTH, pState.getValue(EAST)).setValue(EAST, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(WEST)).setValue(WEST, pState.getValue(NORTH));
            case CLOCKWISE_90:
                return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING))).setValue(NORTH, pState.getValue(WEST)).setValue(EAST, pState.getValue(NORTH)).setValue(SOUTH, pState.getValue(EAST)).setValue(WEST, pState.getValue(SOUTH));
            default:
                return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
        }
    }

    public BlockState mirror(BlockState pState, Mirror pMirror) {
        switch (pMirror) {
            case LEFT_RIGHT:
                return pState.setValue(FACING, pMirror.mirror(pState.getValue(FACING)))
                        .setValue(NORTH, pState.getValue(SOUTH)).setValue(SOUTH, pState.getValue(NORTH));
            case FRONT_BACK:
                return pState.setValue(FACING, pMirror.mirror(pState.getValue(FACING)))
                        .setValue(EAST, pState.getValue(WEST)).setValue(WEST, pState.getValue(EAST));
            default:
                return super.mirror(pState, pMirror);
        }
    }
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockGetter blockgetter = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();

        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockPos blockpos5 = blockpos.above();
        BlockPos blockpos6 = blockpos.below();

        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        BlockState blockstate4 = blockgetter.getBlockState(blockpos5);
        BlockState blockstate5 = blockgetter.getBlockState(blockpos6);

        Direction direction = pContext.getHorizontalDirection().getOpposite();

        return super.getStateForPlacement(pContext)
                .setValue(NORTH, this.connectsTo(blockstate, direction))
                .setValue(EAST, this.connectsTo(blockstate1, direction))
                .setValue(SOUTH, this.connectsTo(blockstate2, direction))
                .setValue(WEST, this.connectsTo(blockstate3, direction))
                .setValue(UP, this.connectsTo(blockstate4, direction))
                .setValue(DOWN, this.connectsTo(blockstate5, direction))
                .setValue(FACING, direction)
                .setValue(PIGEONS, this.defaultBlockState().getValue(PIGEONS))
                .setValue(PIGEON_TYPE, this.defaultBlockState().getValue(PIGEON_TYPE));
    }

    private boolean connectsTo(BlockState pState, Direction direction) {
        if (pState.is(this)){
            return pState.getValue(FACING).getAxis() == direction.getAxis();
        }else {
            return false;
        }
    }

    public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (!pState.canSurvive(pLevel, pCurrentPos)) {
            pLevel.scheduleTick(pCurrentPos, this, 1);
            return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
        } else {
            boolean flag = pFacingState.is(this) && pFacingState.getValue(FACING).getAxis() == pState.getValue(FACING).getAxis();
            return pState.setValue(PROPERTY_BY_DIRECTION.get(pFacing), flag);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(NORTH, EAST, SOUTH, WEST, UP, DOWN, FACING, PIGEONS, PIGEON_TYPE);
    }

    public VoxelShape getVisualShape(BlockState pState, BlockGetter pReader, BlockPos pPos, CollisionContext pContext) {
        return Shapes.empty();
    }

    public Direction getDirection(BlockState state) {
        return state.getValue(FACING);
    }

    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }


    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PigeonLoftBlockEntity(blockPos, blockState);
    }

    @javax.annotation.Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return level.isClientSide ? createTickerHelper(blockEntityType, CCBlockEntities.PIGEON_LOFT.get(), PigeonLoftBlockEntity::clientTick)
                : createTickerHelper(blockEntityType, CCBlockEntities.PIGEON_LOFT.get(), PigeonLoftBlockEntity::serverTick);
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, blockState, blockEntity, itemStack);
        if (!level.isClientSide && blockEntity instanceof PigeonLoftBlockEntity pigeonLoftBlockEntity) {
            if (!EnchantmentHelper.hasTag(itemStack, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
                pigeonLoftBlockEntity.tryReleasePigeon(blockState, PigeonLoftBlockEntity.PigeonState.EMERGENCY, pigeonLoftBlockEntity);
                level.updateNeighbourForOutputSignal(blockPos, this);
            }
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {

        BlockEntity blockEntity;
        if (!level.isClientSide() && (player.isCreative()
//                || EnchantmentHelper.hasTag(player.getItemInHand(InteractionHand.MAIN_HAND),
//                EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)
        ) && level.getGameRules().getBoolean(GameRules.RULE_DOBLOCKDROPS)
                && (blockEntity = level.getBlockEntity(pos)) instanceof PigeonLoftBlockEntity) {

            PigeonLoftBlockEntity pigeonLoftBlockEntity = (PigeonLoftBlockEntity)blockEntity;
            ItemStack itemStack = new ItemStack(this);
            boolean bl = !pigeonLoftBlockEntity.isEmpty();

            if (bl) {
                CompoundTag nbtCompound = new CompoundTag();
                nbtCompound.put("Pigeons", pigeonLoftBlockEntity.getPigeons());
                BlockItem.setBlockEntityData(itemStack, CCBlockEntities.PIGEON_LOFT.get(), nbtCompound);
                nbtCompound = new CompoundTag();
                itemStack.applyComponents(pigeonLoftBlockEntity.collectComponents());
//                itemStack.set(DataComponents.CUSTOM_DATA, CustomData.of(nbtCompound));
                ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), itemStack);
                itemEntity.setDefaultPickUpDelay();
                level.addFreshEntity(itemEntity);
            }

        }
        return super.playerWillDestroy(level, pos, state, player);
    }

    public enum PigeonType implements StringRepresentable {
        ADULT_GREY("grey"),
        BABY_GREY("baby_grey_asleep"),
        ADULT_WHITE("white"),
        BABY_WHITE("baby_white_asleep"),
        ADULT_END("end"),
        BABY_END("baby_end_asleep"),
        ADULT_RED("red"),
        BABY_RED("baby_red_asleep"),
        ADULT_CANNOLI("canolli");

        private final String name;

        private PigeonType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String getSerializedName() {
            return this.name;
        }
    }
}
