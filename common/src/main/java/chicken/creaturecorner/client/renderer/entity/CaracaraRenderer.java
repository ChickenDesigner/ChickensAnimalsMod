package chicken.creaturecorner.client.renderer.entity;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.entity.caracara.BabyCaracaraModel;
import chicken.creaturecorner.client.model.entity.caracara.CaracaraModel;
import chicken.creaturecorner.server.entity.obj.Caracara;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CaracaraRenderer extends MobRenderer<Caracara, HierarchicalModel<Caracara>> {

    private final CaracaraModel<Caracara> adultModel;
    private final BabyCaracaraModel<Caracara> babyModel;

    public CaracaraRenderer(EntityRendererProvider.Context context) {
        super(context, new CaracaraModel<>(context.bakeLayer(CCModelLayers.CARACARA)), 0.5f);

        adultModel = new CaracaraModel<>(context.bakeLayer(CCModelLayers.CARACARA));
        babyModel = new BabyCaracaraModel<>(context.bakeLayer(CCModelLayers.BABY_CARACARA));
    }

    @Override
    public void render(Caracara entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            this.model = babyModel;
        }else {
            this.model = adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Caracara entity) {
        return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID,
                "textures/entity/caracara/caracara" + (entity.isBaby() ? "_baby" : "") + ".png");
    }
}
