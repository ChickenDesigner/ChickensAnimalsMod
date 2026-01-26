package chicken.creaturecorner.client.renderer.entity;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.entity.coyote.CoyoteModel;
import chicken.creaturecorner.client.model.entity.coyote.BabyCoyoteModel;
import chicken.creaturecorner.server.entity.obj.CoyoteEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoyoteRenderer extends MobRenderer<CoyoteEntity, HierarchicalModel<CoyoteEntity>> {

    private final CoyoteModel<CoyoteEntity> adultModel;
    private final BabyCoyoteModel<CoyoteEntity> babyModel;

    public CoyoteRenderer(EntityRendererProvider.Context context) {
        super(context, new CoyoteModel<>(context.bakeLayer(CCModelLayers.COYOTE)), 0.5f);

        adultModel = new CoyoteModel<>(context.bakeLayer(CCModelLayers.COYOTE));
        babyModel = new BabyCoyoteModel<>(context.bakeLayer(CCModelLayers.BABY_COYOTE));
    }

    @Override
    public void render(CoyoteEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {

        if (entity.isBaby()){
            this.model = babyModel;
        }else {
            this.model = adultModel;
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CoyoteEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID,
                "textures/entity/coyote/coyote_" + (entity.isBaby() ? "baby_" : "") + (entity.getVariantName()) + ".png");
    }
}
