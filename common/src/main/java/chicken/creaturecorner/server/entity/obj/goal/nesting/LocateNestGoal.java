package chicken.creaturecorner.server.entity.obj.goal.nesting;

import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.base.INestEggLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.LevelReader;

import java.util.EnumSet;

public abstract class LocateNestGoal extends Goal {

    protected final AbstractCornerCreature creature;
    protected BlockPos blockPos;
    private final int searchRange;
    private final int verticalSearchRange;
    protected int verticalSearchStart;

    public LocateNestGoal(AbstractCornerCreature mob, int searchRange) {
        this(mob, searchRange, 5);
    }

    public LocateNestGoal(AbstractCornerCreature mob, int searchRange, int verticalSearchRange) {
        this.blockPos = BlockPos.ZERO;
        this.creature = mob;
        this.searchRange = searchRange;
        this.verticalSearchStart = 0;
        this.verticalSearchRange = verticalSearchRange;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if (creature instanceof INestEggLayer nestEggLayer)
            return !nestEggLayer.hasNest() && nestEggLayer.isPregnant() && nestEggLayer.getNestSearchCooldown() == 0 && nestEggLayer.getNestSearchTime()>0;
        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return false;
    }
    public void start() {
        if (creature instanceof INestEggLayer nestEggLayer){
            nestEggLayer.setNestSearchCooldown(100);

            BlockPos nestPos = findNearestBlock();
            if (nestPos != null){
                nestEggLayer.setNestPos(nestPos);
            }
        }
    }

    protected BlockPos findNearestBlock() {
        int searchRange = this.searchRange;
        int verticalSearchRange = this.verticalSearchRange;
        BlockPos blockpos = this.creature.blockPosition();
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int k = this.verticalSearchStart; k <= verticalSearchRange; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < searchRange; ++l) {
                for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                    for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                        blockpos$mutableblockpos.setWithOffset(blockpos, i1, k - 1, j1);
                        if (this.creature.isWithinRestriction(blockpos$mutableblockpos) && this.isValidTarget(this.creature.level(), blockpos$mutableblockpos)) {
                            this.blockPos = blockpos$mutableblockpos;
                            return this.blockPos;
                        }
                    }
                }
            }
        }

        return null;
    }

    protected abstract boolean isValidTarget(LevelReader var1, BlockPos var2);
}
