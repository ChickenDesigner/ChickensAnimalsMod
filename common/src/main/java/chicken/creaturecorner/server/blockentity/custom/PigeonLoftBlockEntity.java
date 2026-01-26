package chicken.creaturecorner.server.blockentity.custom;

import chicken.creaturecorner.server.block.obj.custom.PigeonLoftBlock;
import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.entity.obj.Endove;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import chicken.creaturecorner.server.sound.CCSounds;
import com.google.common.collect.Lists;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.*;

import static chicken.creaturecorner.server.block.obj.custom.PigeonLoftBlock.PIGEONS;
import static chicken.creaturecorner.server.block.obj.custom.PigeonLoftBlock.PIGEON_TYPE;

public class PigeonLoftBlockEntity extends BlockEntity {

    public static final String MIN_OCCUPATION_TICKS_KEY = "MinOccupationTicks";
    public static final String ENTITY_DATA_KEY = "EntityData";
    public static final String TICKS_IN_DWELLING_KEY = "TicksInDwelling";
    public static final String PIGEONS_KEY = "Pigeons";
    static final List<String> IRRELEVANT_PIGEON_NBT_KEYS = Arrays.asList("Air",
            "ArmorDropChances",
            "ArmorItems",
            "Brain",
            "CanPickUpLoot",
            "DeathTime",
            "FallDistance",
            "FallFlying",
            "Fire",
            "HandDropChances",
            "HandItems",
            "HurtByTimestamp",
            "HurtTime",
            "LeftHanded",
            "Motion",
            "NoGravity",
            "OnGround",
            "PortalCooldown",
            "Pos",
            "Rotation",
            "SleepingX",
            "SleepingY",
            "SleepingZ",
            "CannotEnterHiveTicks",
            "Passengers",
            "leash",
            "UUID");
    private final List<PigeonData> pigeons = Lists.newArrayList();
    public int time;
    public boolean hasPigeon;

    public PigeonLoftBlockEntity(BlockPos pos, BlockState blockState) {
        super(CCBlockEntities.PIGEON_LOFT.get(), pos, blockState);
    }

    public boolean isEmpty() {
        return this.pigeons.isEmpty();
    }

    public boolean hasPigeon(){
        return this.hasPigeon;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        this.pigeons.clear();

        if (tag.contains(PIGEONS_KEY, 9)) {
            ListTag nbtList = tag.getList(PIGEONS_KEY, 10);
            CompoundTag nbtCompound = nbtList.getCompound(0);
            PigeonData pigeon = new PigeonData(nbtCompound.getCompound(ENTITY_DATA_KEY),
                    nbtCompound.getInt(TICKS_IN_DWELLING_KEY),
                    nbtCompound.getInt(MIN_OCCUPATION_TICKS_KEY));

            this.pigeons.add(pigeon);
        }
        super.loadAdditional(tag, registries);
        this.setChanged();
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put(PIGEONS_KEY, this.getPigeons());
    }

    public ListTag getPigeons() {
        ListTag nbtList = new ListTag();
        for (PigeonData pigeon : this.pigeons) {
            CompoundTag nbtCompound = pigeon.entityData.copy();
            nbtCompound.remove("UUID");
            CompoundTag nbtCompound2 = new CompoundTag();
            nbtCompound2.put(ENTITY_DATA_KEY, nbtCompound);
            nbtCompound2.putInt(IRRELEVANT_PIGEON_NBT_KEYS.toString(), PigeonData.ticksInDwelling);
            nbtCompound2.putInt(MIN_OCCUPATION_TICKS_KEY, pigeon.minOccupationTicks);
            nbtList.add(nbtCompound2);
        }
        return nbtList;
    }

    public PigeonLoftBlock.PigeonType getPigeonVariant(){

        for (PigeonData pigeon : this.pigeons){

            CompoundTag nbtCompound = pigeon.entityData.copy();

            Entity newPigeon = EntityType.loadEntityRecursive(nbtCompound, this.level, entity -> entity);

            if (newPigeon != null) {
                if (newPigeon instanceof Endove endove) {
                    return endove.isBaby() ? PigeonLoftBlock.PigeonType.BABY_END : PigeonLoftBlock.PigeonType.ADULT_END;

                }

                if (newPigeon instanceof Pigeon pigeonEntity) {
                    if (pigeonEntity.isCannoli())
                        return PigeonLoftBlock.PigeonType.ADULT_CANNOLI;

                    return switch (pigeonEntity.getVariant()){
                        case 1 -> pigeonEntity.isBaby() ? PigeonLoftBlock.PigeonType.BABY_WHITE : PigeonLoftBlock.PigeonType.ADULT_WHITE;
                        case 2 -> pigeonEntity.isBaby() ? PigeonLoftBlock.PigeonType.BABY_RED : PigeonLoftBlock.PigeonType.ADULT_RED;
                        default -> pigeonEntity.isBaby() ? PigeonLoftBlock.PigeonType.BABY_GREY : PigeonLoftBlock.PigeonType.ADULT_GREY;
                    };
                }
            }
        }
        return PigeonLoftBlock.PigeonType.ADULT_GREY;
    }

    public Boolean isPigeonBaby(){

        for (PigeonData pigeon : this.pigeons){

            CompoundTag nbtCompound = pigeon.entityData.copy();

            Entity newPigeon = EntityType.loadEntityRecursive(nbtCompound, this.level, entity -> entity);

            if (newPigeon != null) {
                if (newPigeon instanceof Pigeon pigeonEntity) {
                    return pigeonEntity.isBaby();
                }
            }
        }
        return false;
    }

    public static class PigeonData {
        public final CompoundTag entityData;
        static int ticksInDwelling;
        final int minOccupationTicks;

        PigeonData(CompoundTag entityData, int ticksInDwelling, int minOccupationTicks) {
            PigeonLoftBlockEntity.removeIrrelevantNbtKeys(entityData);
            this.entityData = entityData;
            PigeonData.ticksInDwelling = ticksInDwelling;
            this.minOccupationTicks = minOccupationTicks;
        }
    }

    public List<Entity> tryReleasePigeon(BlockState state, PigeonState pigeonState, PigeonLoftBlockEntity pigeonLoftBlockEntity) {
        ArrayList<Entity> list = Lists.newArrayList();
        this.pigeons.removeIf(pigeon -> {
            assert this.level != null;
            return PigeonLoftBlockEntity.releasePigeon(this.level, this.worldPosition, state, pigeon, null, pigeonState, pigeonLoftBlockEntity);
        });
        if (!list.isEmpty()) {
            super.setChanged();
        }
        return list;
    }

    public void tryEnterDwelling(Entity entity) {
        this.tryEnterDwelling(entity, 0);
    }

    public void tryEnterDwelling(Entity entity, int ticksInDwelling) {
        if (!this.isEmpty()) {
            return;
        }
        entity.stopRiding();
        entity.ejectPassengers();
        CompoundTag nbtCompound = new CompoundTag();
        entity.save(nbtCompound);
        BlockPos blockPos = this.getBlockPos();
        this.pigeons.clear();
        this.addPigeon(nbtCompound, ticksInDwelling);
        if (this.level != null) {
//            this.level.playSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), SpeciesSoundEvents.BLOCK_PIGEON_DWELLING_ENTER.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(entity, this.getBlockState()));
        }
        entity.discard();
        super.setChanged();
    }

    public void addPigeon(CompoundTag nbtCompound, int ticksInDwelling) {
        assert this.level != null;
        this.pigeons.add(new PigeonData(nbtCompound, ticksInDwelling, 1200));
    }


    public void setChanged() {
        if (this.isFireNearby()) {
            this.tryReleasePigeon(this.level.getBlockState(this.getBlockPos()), PigeonState.EMERGENCY, this);
        }

        super.setChanged();
    }

    public boolean isFireNearby() {
        if (this.level == null) {
            return false;
        } else {
            for(BlockPos blockPos : BlockPos.betweenClosed(this.worldPosition.offset(-1, -1, -1), this.worldPosition.offset(1, 1, 1))) {
                if (this.level.getBlockState(blockPos).getBlock() instanceof FireBlock) {
                    return true;
                }
            }

            return false;
        }
    }


    private static boolean releasePigeon(Level world, BlockPos pos, BlockState state, PigeonData pigeon, @Nullable List<Entity> entities, PigeonState pigeonState, PigeonLoftBlockEntity blockEntity) {
        if ((world.isNight() || world.isRaining()) && pigeonState != PigeonState.EMERGENCY) {
            return false;
        }
        CompoundTag nbtCompound = pigeon.entityData.copy();
        PigeonLoftBlockEntity.removeIrrelevantNbtKeys(nbtCompound);
        nbtCompound.put("LoftPos", NbtUtils.writeBlockPos(pos));
        Direction direction = state.getValue(PigeonLoftBlock.FACING);
        BlockPos blockPos = pos.relative(direction);
        boolean bl = !world.getBlockState(blockPos).getCollisionShape(world, blockPos).isEmpty();

        if (bl && pigeonState != PigeonState.EMERGENCY) return false;
        Entity newPigeon = EntityType.loadEntityRecursive(nbtCompound, world, entity -> entity);
        if (newPigeon != null) {
            if (newPigeon instanceof chicken.creaturecorner.server.entity.obj.Pigeon pigeonEntity) {
                PigeonLoftBlockEntity.agePigeon(PigeonData.ticksInDwelling, pigeonEntity);
                if (entities != null) entities.add(pigeonEntity);
                float f = newPigeon.getBbWidth();
                double d = bl ? 0.0 : 0.55 + (double)(f / 2.0f);
                double x = (double)pos.getX() + 0.5 + d * (double)direction.getStepX();
                double y = (double)pos.getY() + 0.5 - (double)(newPigeon.getBbHeight() / 2.0f);
                double z = (double)pos.getZ() + 0.5 + d * (double)direction.getStepZ();
                newPigeon.moveTo(x, y, z, newPigeon.getYRot(), newPigeon.getXRot());

//            world.playSound(null, pos, SpeciesSoundEvents.BLOCK_PIGEON_DWELLING_EXIT.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
                world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(newPigeon, world.getBlockState(pos)));
                pigeonEntity.setLoftPos(pos);
                blockEntity.setChanged();
                blockEntity.pigeons.clear();

//                blockEntity.pigeons.removeIf(pigeonData -> world.addFreshEntity(pigeonEntity));

                return world.addFreshEntity(pigeonEntity);

            } else {
                return false;
            }
        }
        return false;
    }

    private static void agePigeon(int ticks, chicken.creaturecorner.server.entity.obj.Pigeon pigeon) {
        int i = pigeon.getAge();
        if (i < 0) pigeon.setAge(Math.min(0, i + ticks));
        else if (i > 0) pigeon.setAge(Math.max(0, i - ticks));
    }

    public List<PigeonData> getPigeonDataList(){
        return pigeons;
    }

    private static void tickPigeons(Level world, BlockPos pos, BlockState state, List<PigeonData> pigeons, PigeonLoftBlockEntity blockEntity) {
        boolean bl = false;
        world.setBlockAndUpdate(pos, state.setValue(PIGEONS, blockEntity.pigeons.size())
                .setValue(PIGEON_TYPE, blockEntity.getPigeonVariant()));
        if (!pigeons.isEmpty()) {
            PigeonData pigeon = pigeons.getFirst();
            if ((PigeonLoftBlockEntity.PigeonData.ticksInDwelling > pigeon.minOccupationTicks) || (world.isDay() && !world.isRaining())) {
                if (PigeonLoftBlockEntity.releasePigeon(world, pos, state, pigeon, null, PigeonState.PIGEON_RELEASED, blockEntity)) {
                    bl = true;
                }
            }
            ++PigeonLoftBlockEntity.PigeonData.ticksInDwelling;
        }
        if (bl) PigeonLoftBlockEntity.setChanged(world, pos, state);
    }

    public static void clientTick(Level world, BlockPos pos, BlockState state, PigeonLoftBlockEntity blockEntity) {
        ++blockEntity.time;

    }

    public static void serverTick(Level world, BlockPos pos, BlockState state, PigeonLoftBlockEntity blockEntity) {

        PigeonLoftBlockEntity.tickPigeons(world, pos, state, blockEntity.pigeons, blockEntity);

        if (!blockEntity.pigeons.isEmpty() && !blockEntity.hasPigeon ){
            blockEntity.hasPigeon = true;
        }
        if (blockEntity.pigeons.isEmpty() && blockEntity.hasPigeon){
            blockEntity.hasPigeon = false;
        }

        if (!blockEntity.pigeons.isEmpty() && world.getRandom().nextDouble() < 0.005) {
            double d = (double)pos.getX() + 0.5;
            double e = pos.getY();
            double f = (double)pos.getZ() + 0.5;
            world.playSound(null, d, e, f, CCSounds.PIGEON_IDLE.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
        }
    }

    static void removeIrrelevantNbtKeys(CompoundTag compound) {
        for (String string : IRRELEVANT_PIGEON_NBT_KEYS) compound.remove(string);
    }

    @Override
    protected void collectImplicitComponents(DataComponentMap.Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.CUSTOM_DATA, this.getPigeonData());
    }

    @Override
    protected void applyImplicitComponents(BlockEntity.DataComponentInput componentInput) {
        super.applyImplicitComponents(componentInput);
        this.pigeons.clear();
        CustomData data = componentInput.get(DataComponents.CUSTOM_DATA);
        if (data != null){
            ListTag nbtList = data.copyTag().getList(PIGEONS_KEY, 10);
            for (int i = 0; i < nbtList.size(); ++i) {
                CompoundTag nbtCompound = nbtList.getCompound(i);
                PigeonData pigeon = new PigeonData(nbtCompound.getCompound(ENTITY_DATA_KEY), nbtCompound.getInt(TICKS_IN_DWELLING_KEY), nbtCompound.getInt(MIN_OCCUPATION_TICKS_KEY));
                this.pigeons.add(pigeon);
            }
        }
    }

    @Override
    public void removeComponentsFromTag(CompoundTag tag) {
        super.removeComponentsFromTag(tag);
        tag.remove("Pigeons");
    }

    private CustomData getPigeonData() {

        CompoundTag nbtCompound = new CompoundTag();
        nbtCompound.put("Pigeons", this.getPigeons());

        return CustomData.of(nbtCompound);
    }

    public enum PigeonState {
        PIGEON_RELEASED,
        EMERGENCY
    }
}
