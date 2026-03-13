package chicken.creaturecorner.server.entity.obj.goal.nesting;

import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.base.INestEggLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

public class BuildNestGoal extends MoveToBlockGoal {
    private final double acceptedDistance;

    public BuildNestGoal(AbstractCornerCreature pEggLayer, double pSpeedModifier, double acceptedDistance) {
        this(pEggLayer, pSpeedModifier, acceptedDistance, 5);
    }

    public BuildNestGoal(AbstractCornerCreature pEggLayer, double pSpeedModifier, double acceptedDistance, int verticalSearchRange) {
        super(pEggLayer, pSpeedModifier, 25, verticalSearchRange);
        this.acceptedDistance = acceptedDistance;
    }

    public boolean canUse() {
        if (mob instanceof INestEggLayer eggLayer){
            if (eggLayer.isPregnant() && !eggLayer.hasNest())
                return super.canUse();
        }

        return false;
    }

    protected int nextStartTick(PathfinderMob creature) {
        return 60;
    }

    public boolean canContinueToUse() {
        if (mob instanceof INestEggLayer eggLayer)
            return eggLayer.isPregnant() && !eggLayer.hasNest() && super.canContinueToUse();

        return false;
    }

    public void tick() {
        super.tick();
        if (!this.mob.isInWater() && this.mob instanceof INestEggLayer eggLayer) {

            System.out.println(eggLayer.getBuildingNestCounter());

            if (eggLayer.getBuildingNestCounter() < 1) {
                eggLayer.setBuildingNest(true);
            } else if (eggLayer.getBuildingNestCounter() > 100) {
                Level level = this.mob.level();
                BlockPos blockpos1 = this.blockPos.above();

                eggLayer.setBuildingNest(false);
                eggLayer.onNestBuilt(level, blockpos1);
            }

            if (eggLayer.isBuildingNest()) {
                int buildingNestCounter = eggLayer.getBuildingNestCounter();
                eggLayer.setBuildingNestCounter(++buildingNestCounter);
            }
        }

    }

    protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
        return pLevel.isEmptyBlock(pPos.above()) && pLevel.getBlockState(pPos).isSolid();
    }

    public double acceptedDistance() {
        return acceptedDistance;
    }
}
