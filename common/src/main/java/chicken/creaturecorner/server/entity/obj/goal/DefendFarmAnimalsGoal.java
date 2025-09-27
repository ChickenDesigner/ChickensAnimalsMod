package chicken.creaturecorner.server.entity.obj.goal;

import chicken.creaturecorner.server.entity.obj.GallianEntity;
import chicken.creaturecorner.server.entity.obj.PigeonEntity;
import chicken.creaturecorner.util.CCTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.animal.sniffer.Sniffer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class DefendFarmAnimalsGoal extends TargetGoal {
    private final GallianEntity gallian;
    @Nullable
    private LivingEntity potentialTarget;
    private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range((double)64.0F);

    public DefendFarmAnimalsGoal(GallianEntity gallian) {
        super(gallian, false, true);
        this.gallian = gallian;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        AABB aABB = this.gallian.getBoundingBox().inflate((double)10.0F, (double)8.0F, (double)10.0F);
        List<? extends LivingEntity> list = this.gallian.level().getNearbyEntities(Animal.class, this.attackTargeting, this.gallian, aABB);

        for(LivingEntity livingEntity : list) {
            if (livingEntity.getType().is(CCTags.EntityTypes.GALLIAN_DEFENDABLE) ){

                if (livingEntity.getLastHurtByMob() != null){
                    this.potentialTarget = livingEntity.getLastHurtByMob();
                }
            }
        }

        if (this.potentialTarget == null) {
            return false;
        } else if (!(this.potentialTarget instanceof Player) || !this.potentialTarget.isSpectator() && !((Player)this.potentialTarget).isCreative()) {
            return true;
        } else {
            return false;
        }
    }

    public void start() {
        this.gallian.setTarget(this.potentialTarget);
        super.start();
    }
}
