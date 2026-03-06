package chicken.creaturecorner.server.entity.obj.base;

import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public interface INestEggLayer extends IEggLayer{

    boolean hasNest();

    void setNestPos(BlockPos pPos);

    @Nullable
    BlockPos getNestPos();
}
