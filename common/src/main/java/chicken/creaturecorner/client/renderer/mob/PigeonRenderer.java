package chicken.creaturecorner.client.renderer.mob;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.pigeon.PigeonModel;
import chicken.creaturecorner.server.entity.obj.PigeonEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PigeonRenderer extends MobRenderer<PigeonEntity, HierarchicalModel<PigeonEntity>> {

    private final PigeonModel<PigeonEntity> adultModel;
    private final BabyPigeonModel<PigeonEntity> babyModel;

    public PigeonRenderer(EntityRendererProvider.Context context) {
        super(context, new PigeonModel<>(context.bakeLayer(CCModelLayers.PIGEON)), 0.15f);

        adultModel = new PigeonModel<>(context.bakeLayer(CCModelLayers.PIGEON));
        babyModel = new BabyPigeonModel<>(context.bakeLayer(CCModelLayers.BABY_PIGEON));
    }

    @Override
    public void render(PigeonEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            this.model = babyModel;
        }else {
            this.model = adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(PigeonEntity pigeon) {
        String s = ChatFormatting.stripFormatting(pigeon.getName().getString());

        if (s.toLowerCase().equals("cannoli") && !pigeon.isBaby()){
            return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "textures/entity/pigeon/pigeon_canolli.png");
        }

        return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID,
                "textures/entity/pigeon/pigeon_" + (pigeon.isBaby() ? "baby_" : "") + pigeon.getVariantName() + ".png");
    }
}
