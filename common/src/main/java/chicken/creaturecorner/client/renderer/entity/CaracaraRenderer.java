package chicken.creaturecorner.client.renderer.entity;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.entity.caracara.BabyCaracaraModel;
import chicken.creaturecorner.client.model.entity.caracara.CaracaraModel;
import chicken.creaturecorner.client.model.entity.coyote.BabyCoyoteModel;
import chicken.creaturecorner.client.model.entity.coyote.CoyoteModel;
import chicken.creaturecorner.server.entity.obj.CaracaraEntity;
import chicken.creaturecorner.server.entity.obj.CoyoteEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CaracaraRenderer extends MobRenderer<CaracaraEntity, HierarchicalModel<CaracaraEntity>> {

    private final CaracaraModel<CaracaraEntity> adultModel;
    private final BabyCaracaraModel<CaracaraEntity> babyModel;

    public CaracaraRenderer(EntityRendererProvider.Context context) {
        super(context, new CaracaraModel<>(context.bakeLayer(CCModelLayers.CARACARA)), 0.5f);

        adultModel = new CaracaraModel<>(context.bakeLayer(CCModelLayers.CARACARA));
        babyModel = new BabyCaracaraModel<>(context.bakeLayer(CCModelLayers.BABY_CARACARA));
    }

    @Override
    public void render(CaracaraEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            this.model = babyModel;
        }else {
            this.model = adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CaracaraEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID,
                "textures/entity/caracara/caracara" + (entity.isBaby() ? "_baby" : "") + ".png");
    }
}
