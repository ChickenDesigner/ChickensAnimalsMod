package chicken.creaturecorner.server.entity.obj.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;

public interface INestEggLayer extends IEggLayer{

    default boolean hasNest(){
        return getNestPos() != null;
    }

    void setNestPos(BlockPos pPos);

    @Nullable
    default BlockPos getNestPos(){
        return null;
    }

    int getBuildingNestCounter();

    void setBuildingNestCounter(int buildNestCounter);

    boolean isBuildingNest();

    void setBuildingNest(boolean buildingNest);

    void onNestBuilt(Level level, BlockPos blockPos);

    int getNestSearchCooldown();

    void setNestSearchCooldown(int cooldown);

    int getNestSearchTime();

    void setNestSearchTime(int searchTime);

    int getNestBuildingTime();

    void setNestBuildingTime(int searchTime);

    Block getNestType();
}
