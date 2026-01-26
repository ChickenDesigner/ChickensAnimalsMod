package chicken.creaturecorner.client.renderer.block;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.block.loft.BabyPigeonInLoftModel;
import chicken.creaturecorner.client.model.block.loft.PigeonInLoftModel;
import chicken.creaturecorner.server.block.obj.custom.PigeonLoftBlock;
import chicken.creaturecorner.server.blockentity.custom.PigeonLoftBlockEntity;
import chicken.creaturecorner.server.entity.obj.Pigeon;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PigeonLoftRenderer implements BlockEntityRenderer<PigeonLoftBlockEntity> {

    private final PigeonInLoftModel adultModel;
    private final BabyPigeonInLoftModel babyModel;

    public PigeonLoftRenderer(BlockEntityRendererProvider.Context pContext) {
        this.adultModel = new PigeonInLoftModel(pContext.bakeLayer(CCModelLayers.PIGEON_LOFT));
        this.babyModel = new BabyPigeonInLoftModel(pContext.bakeLayer(CCModelLayers.BABY_PIGEON_LOFT));
    }

    @Override
    public void render(PigeonLoftBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pPoseStack.pushPose();
            pPoseStack.mulPose(Axis.XN.rotationDegrees(180));
            pPoseStack.translate(0.5, -1.2, -0.5);
            float scale = 0.5f;
            pPoseStack.scale(scale, scale, scale);

            int rotation = switch (pBlockEntity.getBlockState().getOptionalValue(PigeonLoftBlock.FACING).get()) {
                case Direction.EAST -> 3;
                case Direction.SOUTH -> 0;
                case Direction.WEST -> 1;
                default -> 2;
            };

            float f = (float)pBlockEntity.time + pPartialTick;

            if (pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEONS) > 0){
                Material MATERIAL = new Material(TextureAtlas.LOCATION_BLOCKS,
                        ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "entity/pigeon/pigeon_" +
                                pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEON_TYPE).toString()));

                VertexConsumer vertexconsumer = MATERIAL.buffer(pBuffer, RenderType::entityTranslucentCull);

                if (pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEON_TYPE) == PigeonLoftBlock.PigeonType.BABY_END
                || pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEON_TYPE) == PigeonLoftBlock.PigeonType.BABY_GREY
                || pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEON_TYPE) == PigeonLoftBlock.PigeonType.BABY_WHITE
                || pBlockEntity.getBlockState().getValue(PigeonLoftBlock.PIGEON_TYPE) == PigeonLoftBlock.PigeonType.BABY_RED){
                    pPoseStack.mulPose(Axis.YP.rotationDegrees(90));
                    this.babyModel.setupAnim(f, rotation);
                    this.babyModel.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, -1);
                }else{
                    this.adultModel.setupAnim(f, rotation);
                    this.adultModel.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, pPackedOverlay, -1);
                }
            }

        pPoseStack.popPose();
    }

}
