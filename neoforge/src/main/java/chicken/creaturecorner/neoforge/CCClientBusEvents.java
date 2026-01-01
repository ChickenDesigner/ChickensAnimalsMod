package chicken.creaturecorner.neoforge;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.client.CCModelLayers;
import chicken.creaturecorner.client.model.GallianChickModel;
import chicken.creaturecorner.client.model.GallianModel;
import chicken.creaturecorner.client.model.pigeon.BabyEndoveModel;
import chicken.creaturecorner.client.model.pigeon.BabyPigeonModel;
import chicken.creaturecorner.client.model.pigeon.EndoveModel;
import chicken.creaturecorner.client.model.pigeon.PigeonModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CCConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CCClientBusEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CCModelLayers.GALLIAN, GallianModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.GALLIAN_CHICK, GallianChickModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.PIGEON, PigeonModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_PIGEON, BabyPigeonModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.ENDOVE, EndoveModel::createBodyLayer);
        event.registerLayerDefinition(CCModelLayers.BABY_ENDOVE, BabyEndoveModel::createBodyLayer);
    }
}
