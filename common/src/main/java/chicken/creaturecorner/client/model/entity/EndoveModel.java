package chicken.creaturecorner.client.model.entity;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.server.entity.obj.Endove;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EndoveModel extends GeoModel<Endove> {

    @Override
    public ResourceLocation getModelResource(Endove object) {
        if (object.isBaby()){
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "geo/animal/pigeon/pigeon_baby.geo.json");
        }
        else {
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "geo/animal/pigeon/pigeon.geo.json");
        }
    }

    @Override
    public ResourceLocation getTextureResource(Endove object) {

        if (object.isBaby()){
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "textures/entity/pigeon/pigeon_baby_end.png");
        }
        else {
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "textures/entity/pigeon/pigeon_end.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Endove object) {
        if (object.isBaby()){
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "animations/animal/pigeon/pigeon_baby.animation.json");
        }
        else {
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "animations/animal/pigeon/pigeon.animation.json");
        }
    }

    @Override
    public void setCustomAnimations(Endove object, long instanceId, AnimationState<Endove> animationEvent) {

        super.setCustomAnimations(object, instanceId, animationEvent);

        if (animationEvent == null) return;

        GeoBone head = this.getAnimationProcessor().getBone("head_look");

        EntityModelData entityData = animationEvent.getData(DataTickets.ENTITY_MODEL_DATA);
        head.setRotX(-(entityData.headPitch() * ((float) Math.PI / 180F)));
        head.setRotY(entityData.netHeadYaw() * ((float) Math.PI / 180F));
    }

}
