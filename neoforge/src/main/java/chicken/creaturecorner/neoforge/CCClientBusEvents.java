package chicken.creaturecorner.neoforge;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.block.loft.BabyPigeonInLoftModel;
import chicken.creaturecorner.client.model.block.loft.PigeonInLoftModel;
import chicken.creaturecorner.client.model.entity.coyote.BabyCoyoteModel;
import chicken.creaturecorner.client.model.entity.coyote.CoyoteModel;
import chicken.creaturecorner.client.model.entity.gallian.GallianChickModel;
import chicken.creaturecorner.client.model.entity.gallian.GallianModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.entity.pigeon.EndoveModel;
import chicken.creaturecorner.client.model.entity.pigeon.PigeonModel;
import chicken.creaturecorner.client.renderer.block.PigeonLoftRenderer;
import chicken.creaturecorner.client.renderer.entity.EndoveRenderer;
import chicken.creaturecorner.client.renderer.entity.GallianRenderer;
import chicken.creaturecorner.client.renderer.entity.PigeonRenderer;
import chicken.creaturecorner.client.renderer.entity.geckolib.CaracaraRenderer;
import chicken.creaturecorner.client.renderer.entity.CoyoteRenderer;
import chicken.creaturecorner.server.blockentity.CCBlockEntities;
import chicken.creaturecorner.server.entity.CCEntities;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.HashMap;

@EventBusSubscriber(modid = CCConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CCClientBusEvents {
    private static final HashMap<EntityType<?>, EntityRendererProvider<?>> renderers = new HashMap<>();

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(CCEntities.COYOTE_TYPE.get(), CoyoteRenderer::new);
        event.registerEntityRenderer(CCEntities.CARACARA_TYPE.get(), CaracaraRenderer::new);
        event.registerEntityRenderer(CCEntities.ENDOVE.get(), EndoveRenderer::new);
        event.registerEntityRenderer(CCEntities.PIGEON.get(), PigeonRenderer::new);
        event.registerEntityRenderer(CCEntities.GALLIAN.get(), GallianRenderer::new);


        event.registerBlockEntityRenderer(CCBlockEntities.PIGEON_LOFT.get(), PigeonLoftRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CCModelLayers.GALLIAN, GallianModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.GALLIAN_CHICK, GallianChickModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.PIGEON, PigeonModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_PIGEON, BabyPigeonModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.ENDOVE, EndoveModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_ENDOVE, BabyEndoveModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.COYOTE, CoyoteModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_COYOTE, BabyCoyoteModel::createBodyLayer);

        event.registerLayerDefinition(CCModelLayers.PIGEON_LOFT, PigeonInLoftModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_PIGEON_LOFT, BabyPigeonInLoftModel::createBodyLayer);
    }
}
