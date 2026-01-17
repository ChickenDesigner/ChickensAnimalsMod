package chicken.creaturecorner.server.block;

import chicken.creaturecorner.platform.Services;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class CCPoiTypes {

    public static final Supplier<PoiType> PIGEON_LOFT_POI = register("pigeon_loft_poi",
            () -> new PoiType(ImmutableSet.copyOf(CCBlocks.PIGEON_LOFT.get().getStateDefinition().getPossibleStates()), 1, 1));

    public static Supplier<PoiType> register(String s, Supplier<PoiType> item) {
        item = Suppliers.memoize(item);
        Services.PLATFORM.register(BuiltInRegistries.POINT_OF_INTEREST_TYPE, s, item);
        return item;
    }

}
