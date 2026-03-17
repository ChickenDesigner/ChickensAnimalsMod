package chicken.creaturecorner.server.entity.obj.goal;

import chicken.creaturecorner.server.entity.obj.Caracara;
import chicken.creaturecorner.server.entity.obj.CoyoteEntity;
import chicken.creaturecorner.server.entity.obj.GallianEntity;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import chicken.creaturecorner.util.CCTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class DefendFarmAnimalsGoal extends TargetGoal {
    private final GallianEntity gallian;
    @Nullable
    private LivingEntity potentialTarget;
    private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0F);

    public DefendFarmAnimalsGoal(GallianEntity gallian) {
        super(gallian, false, true);
        this.gallian = gallian;
        this.setFlags(EnumSet.of(Flag.TARGET));
    }

    public boolean canUse() {
        AABB aABB = this.gallian.getBoundingBox().inflate(10.0F, 8.0F, 10.0F);
        List<? extends LivingEntity> list = this.gallian.level().getNearbyEntities(Animal.class, this.attackTargeting, this.gallian, aABB);

        for(LivingEntity livingEntity : list) {
            if (!(livingEntity instanceof TamableAnimal)){

                if (livingEntity.getLastHurtByMob() != null){
                    this.potentialTarget = livingEntity.getLastHurtByMob();
                }
            }
        }

        if (this.potentialTarget == null) {
            return false;
        } else if (this.potentialTarget instanceof Player player) {
            return gallian.getOwner() != player && !(player.isSpectator() || player.isCreative());
        } else {
            return true;
        }
    }

    public void start() {
        this.gallian.setTarget(this.potentialTarget);
        super.start();
    }
}
