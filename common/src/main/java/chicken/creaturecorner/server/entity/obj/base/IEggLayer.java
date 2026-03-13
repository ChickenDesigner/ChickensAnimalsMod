package chicken.creaturecorner.server.entity.obj.base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface IEggLayer {

    boolean isPregnant();

    void setPregnant(boolean pregnant);

    int getLayEggCounter();

    void setLayEggCounter(int layEggCounter);

    boolean isLayingEgg();

    void setLayingEgg(boolean pregnant);

    void onEggLaid(Level level, BlockPos pos);

    void onBreed(AbstractCornerCreature partner);
}
