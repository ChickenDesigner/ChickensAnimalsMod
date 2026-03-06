package chicken.creaturecorner.fabric.client;

import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.block.loft.BabyPigeonInLoftModel;
import chicken.creaturecorner.client.model.block.loft.PigeonInLoftModel;
import chicken.creaturecorner.client.model.entity.caracara.BabyCaracaraModel;
import chicken.creaturecorner.client.model.entity.caracara.CaracaraModel;
import chicken.creaturecorner.client.model.entity.coyote.BabyCoyoteModel;
import chicken.creaturecorner.client.model.entity.coyote.CoyoteModel;
import chicken.creaturecorner.client.model.entity.gallian.GallianChickModel;
import chicken.creaturecorner.client.model.entity.gallian.GallianModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.entity.pigeon.EndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.PigeonModel;
import chicken.creaturecorner.client.renderer.block.PigeonLoftRenderer;
import chicken.creaturecorner.client.renderer.entity.*;
import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.entity.CCEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class FabricAnimalModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CCEntities.PIGEON.get(), PigeonRenderer::new);
        EntityRendererRegistry.register(CCEntities.COYOTE.get(), CoyoteRenderer::new);
        EntityRendererRegistry.register(CCEntities.CARACARA.get(), CaracaraRenderer::new);
        EntityRendererRegistry.register(CCEntities.ENDOVE.get(), EndoveRenderer::new);
        EntityRendererRegistry.register(CCEntities.GALLIAN.get(), GallianRenderer::new);

        EntityRendererRegistry.register(CCEntities.CARACARA_EGG.get(), ThrownItemRenderer::new);
        EntityRendererRegistry.register(CCEntities.ENDOVE_EGG.get(), ThrownItemRenderer::new);
        EntityRendererRegistry.register(CCEntities.PIGEON_EGG.get(), ThrownItemRenderer::new);

        BlockEntityRenderers.register(CCBlockEntities.PIGEON_LOFT.get(), PigeonLoftRenderer::new);


        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN, GallianModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN_CHICK, GallianChickModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.PIGEON, PigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_PIGEON, BabyPigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.ENDOVE, EndoveModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_ENDOVE, BabyEndoveModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.COYOTE, CoyoteModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_COYOTE, BabyCoyoteModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.CARACARA, CaracaraModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_CARACARA, BabyCaracaraModel::createBodyLayer);

        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.PIGEON_LOFT, PigeonInLoftModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_PIGEON_LOFT, BabyPigeonInLoftModel::createBodyLayer);
    }
}
