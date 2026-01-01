package chicken.creaturecorner.fabric.client;

import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.GallianChickModel;
import chicken.creaturecorner.client.model.GallianModel;
import chicken.creaturecorner.client.model.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.pigeon.EndoveModel;
import chicken.creaturecorner.client.model.pigeon.PigeonModel;
import chicken.creaturecorner.client.renderer.mob.EndoveRenderer;
import chicken.creaturecorner.client.renderer.mob.GallianRenderer;
import chicken.creaturecorner.client.renderer.mob.PigeonRenderer;
import chicken.creaturecorner.server.entity.CCEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class FabricAnimalModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(CCEntities.PIGEON_TYPE.get(), PigeonRenderer::new);
//        EntityRendererRegistry.register(CCEntities.NEW_PIGEON.get(), NewPigeonRenderer::new);
        EntityRendererRegistry.register(CCEntities.COYOTE_TYPE.get(), chicken.creaturecorner.client.renderer.geckolib.CoyoteRenderer::new);
        EntityRendererRegistry.register(CCEntities.CARACARA_TYPE.get(), chicken.creaturecorner.client.renderer.geckolib.CaracaraRenderer::new);
        EntityRendererRegistry.register(CCEntities.ENDOVE_TYPE.get(), EndoveRenderer::new);

        EntityRendererRegistry.register(CCEntities.GALLIAN.get(), GallianRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN, GallianModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.GALLIAN_CHICK, GallianChickModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.PIGEON, PigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_PIGEON, BabyPigeonModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.ENDOVE, EndoveModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CCModelLayers.BABY_ENDOVE, BabyEndoveModel::createBodyLayer);
    }
}
