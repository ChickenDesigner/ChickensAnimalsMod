package chicken.creaturecorner.server.entity.obj.goal.nesting;

import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.base.INestEggLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;

import java.util.EnumSet;

public class GoToNestGoal extends Goal {

    protected final AbstractCornerCreature mob;
    public final double speedModifier;
    protected BlockPos blockPos;
    protected int nextStartTick;
    protected int tryTicks;
    private boolean reachedTarget;

    public GoToNestGoal(AbstractCornerCreature mob, double speedModifier) {
        this.mob = mob;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if (this.mob instanceof INestEggLayer nester)
            return nester.isPregnant() && nester.hasNest();
        return false;
    }

    @Override
    public void start() {
        if (this.mob instanceof INestEggLayer nester && nester.hasNest()){
            this.blockPos = nester.getNestPos();
            this.moveMobToBlock();
        }
    }

    @Override
    public void stop() {
        if (this.mob instanceof INestEggLayer nester && nester.hasNest()){
            if (!this.mob.level().getBlockState(nester.getNestPos()).is(nester.getNestType())) {
                this.blockPos = null;
                nester.setNestPos(null);
            }
            this.mob.getNavigation().stop();
        }
    }

    protected void moveMobToBlock() {
        this.mob.getNavigation().moveTo((double)this.blockPos.getX() + (double)0.5F, (double)(this.blockPos.getY() + 1), (double)this.blockPos.getZ() + (double)0.5F, this.speedModifier);
    }

    protected void moveMobToBlockWithOffset(double x, double y, double z) {
        this.mob.getNavigation().moveTo((double)this.blockPos.getX() + (double)0.5F + x, (double)(this.blockPos.getY() + 1) + y, (double)this.blockPos.getZ() + (double)0.5F + z, this.speedModifier);
    }

    public BlockPos getMoveToTarget() {
        return this.blockPos;
    }

    public double acceptedDistance() {
        return 0.5D;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        BlockPos blockpos = this.getMoveToTarget();


        if (!blockpos.closerToCenterThan(this.mob.position(), this.acceptedDistance())) {
            if (this.reachedTarget)
                this.onTryAgain();
            this.reachedTarget = false;

            ++this.tryTicks;
            if (this.shouldRecalculatePath()) {
                this.mob.getNavigation().moveTo((double)blockpos.getX() + (double)0.5F, (double)blockpos.getY()+0.5F, (double)blockpos.getZ() + (double)0.5F, this.speedModifier);
            }
        } else {
            if (this.shouldRecalculatePath()) {
                this.mob.getNavigation().moveTo((double)blockpos.getX() + (double)0.5F, (double)blockpos.getY()+0.15F, (double)blockpos.getZ() + (double)0.5F, this.speedModifier);
            }
            if (!this.reachedTarget)
                this.onLand();
            this.reachedTarget = true;

            if (this.mob instanceof INestEggLayer eggLayer){

                if (eggLayer.getLayEggCounter() < 1) {
                    eggLayer.setLayingEgg(true);
                } else if (eggLayer.getLayEggCounter() > this.adjustedTickDelay(100)) {
                    Level level = this.mob.level();

                    eggLayer.setPregnant(false);
                    eggLayer.setLayingEgg(false);
                    eggLayer.onEggLaid(level, blockpos);
                    this.mob.setInLoveTime(600);
                }

                if (eggLayer.isLayingEgg()) {
                    int prevLayEggCounter = eggLayer.getLayEggCounter();
                    eggLayer.setLayEggCounter(++prevLayEggCounter);
                }
            }

            --this.tryTicks;
        }
    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 40 == 0;
    }

    protected boolean isReachedTarget() {
        return this.reachedTarget;
    }

    public void onLand() {
    }

    public void onTryAgain() {
    }
}
