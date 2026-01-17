package chicken.creaturecorner.fabric.client;

import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.block.loft.BabyPigeonInLoftModel;
import chicken.creaturecorner.client.model.block.loft.PigeonInLoftModel;
import chicken.creaturecorner.client.model.entity.GallianChickModel;
import chicken.creaturecorner.client.model.entity.GallianModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.entity.pigeon.EndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.PigeonModel;
import chicken.creaturecorner.client.renderer.block.PigeonLoftRenderer;
import chicken.creaturecorner.client.renderer.entity.EndoveRenderer;
import chicken.creaturecorner.client.renderer.entity.GallianRenderer;
import chicken.creaturecorner.client.renderer.entity.PigeonRenderer;
import chicken.creaturecorner.client.renderer.entity.geckolib.CaracaraRenderer;
import chicken.creaturecorner.client.renderer.entity.geckolib.CoyoteRenderer;
import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.entity.CCEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class FabricAnimalModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CCEntities.PIGEON.get(), PigeonRenderer::new);
//        EntityRendererRegistry.register(CCEntities.NEW_PIGEON.get(), NewPigeonRenderer::new);
        EntityRendererRegistry.register(CCEntities.COYOTE_TYPE.get(), CoyoteRenderer::new);
        EntityRendererRegistry.register(CCEntities.CARACARA_TYPE.get(), CaracaraRenderer::new);
        EntityRendererRegistry.register(CCEntities.ENDOVE.get(), EndoveRenderer::new);
        BlockEntityRenderers.register(CCBlockEntities.PIGEON_LOFT.get(), PigeonLoftRenderer::new);

        EntityRendererRegistry.register(CCEntities.GALLIAN.get(), GallianRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN, GallianModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN_CHICK, GallianChickModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.PIGEON, PigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_PIGEON, BabyPigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.ENDOVE, EndoveModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_ENDOVE, BabyEndoveModel::createBodyLayer);

        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.PIGEON_LOFT, PigeonInLoftModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_PIGEON_LOFT, BabyPigeonInLoftModel::createBodyLayer);
    }
}
