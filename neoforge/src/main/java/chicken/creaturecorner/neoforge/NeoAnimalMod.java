package chicken.creaturecorner.neoforge;

import chicken.creaturecorner.CCCommon;
import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.neoforge.loot.CCLootModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(CCConstants.MOD_ID)
public class NeoAnimalMod {

    public NeoAnimalMod(IEventBus modEventBus, ModContainer modContainer) {
        CCCommon.init();
        CCLootModifiers.register(modEventBus);
        modEventBus.addListener(NeoForgePlatformHelper::registerEvent);
    }

}
