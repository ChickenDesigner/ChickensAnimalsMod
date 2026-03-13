package chicken.creaturecorner.neoforge;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.server.entity.CCEntities;
import chicken.creaturecorner.server.entity.obj.*;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = CCConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CCEventBusEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(CCEntities.PIGEON.get(), Pigeon.createAttributes().build());
//        event.put(CCEntities.NEW_PIGEON.get(), NewPigeonEntity.createAttributes().build());
        event.put(CCEntities.ENDOVE.get(), Endove.createAttributes().build());
        event.put(CCEntities.CARACARA.get(), Caracara.createAttributes().build());
        event.put(CCEntities.COYOTE.get(), CoyoteEntity.createAttributes().build());

        event.put(CCEntities.GALLIAN.get(), GallianEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerAdditionalSpawns(RegisterSpawnPlacementsEvent e) {
        e.register(CCEntities.PIGEON.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE, Pigeon::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(CCEntities.ENDOVE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Endove::canEndoveSpawn, RegisterSpawnPlacementsEvent.Operation.OR);
        e.register(CCEntities.CARACARA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Caracara::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        e.register(CCEntities.COYOTE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CoyoteEntity::checkCoyoteSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
