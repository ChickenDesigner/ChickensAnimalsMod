package chicken.creaturecorner.client.renderer.mob;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.pigeon.EndoveModel;
import chicken.creaturecorner.server.entity.obj.EndoveEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EndoveRenderer extends MobRenderer<EndoveEntity, HierarchicalModel<EndoveEntity>> {

    private final EndoveModel<EndoveEntity> adultModel;
    private final BabyEndoveModel<EndoveEntity> babyModel;

    public EndoveRenderer(EntityRendererProvider.Context context) {
        super(context, new EndoveModel<>(context.bakeLayer(CCModelLayers.ENDOVE)), 0.15f);

        adultModel = new EndoveModel<>(context.bakeLayer(CCModelLayers.ENDOVE));
        babyModel = new BabyEndoveModel<>(context.bakeLayer(CCModelLayers.BABY_ENDOVE));
    }

    @Override
    public void render(EndoveEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            this.model = babyModel;
        }else {
            this.model = adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(EndoveEntity pigeon) {

        return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID,
                "textures/entity/pigeon/pigeon_" + (pigeon.isBaby() ? "baby_" : "") + "_end.png");
    }
}
