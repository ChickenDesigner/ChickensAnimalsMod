package chicken.creaturecorner.server.entity.obj.goal.nesting;

import chicken.creaturecorner.server.entity.obj.base.AbstractCornerCreature;
import chicken.creaturecorner.server.entity.obj.base.IEggLayer;
import chicken.creaturecorner.server.entity.obj.base.INestEggLayer;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.level.GameRules;

public class EggLayerBreedGoal extends BreedGoal {
    private final AbstractCornerCreature animal;

    public EggLayerBreedGoal(AbstractCornerCreature pAnimal, double pSpeedModifier) {
        super(pAnimal, pSpeedModifier);
        this.animal = pAnimal;
    }

    public boolean canUse() {
        if (this.animal instanceof IEggLayer eggLayer)
            return super.canUse() && !eggLayer.isPregnant();

        return false;
    }

    protected void breed() {
        ServerPlayer serverplayer = this.animal.getLoveCause();
        if (serverplayer == null && this.partner.getLoveCause() != null) {
            serverplayer = this.partner.getLoveCause();
        }

        if (serverplayer != null) {
            serverplayer.awardStat(Stats.ANIMALS_BRED);
            CriteriaTriggers.BRED_ANIMALS.trigger(serverplayer, this.animal, this.partner, (AgeableMob)null);
        }

        if (this.animal instanceof IEggLayer eggLayer){
            eggLayer.onBreed((AbstractCornerCreature) this.partner);
            eggLayer.setPregnant(true);
        }
        if (this.animal instanceof INestEggLayer nestEggLayer){
            if (!nestEggLayer.hasNest()){
                nestEggLayer.setNestSearchTime(20*60);
                nestEggLayer.setNestBuildingTime(20*60);
            }
        }

        this.animal.setAge(6000);
        this.partner.setAge(6000);
        this.animal.resetLove();
        this.partner.resetLove();
        RandomSource randomsource = this.animal.getRandom();
        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            this.level.addFreshEntity(new ExperienceOrb(this.level, this.animal.getX(), this.animal.getY(), this.animal.getZ(), randomsource.nextInt(7) + 1));
        }
    }
}
