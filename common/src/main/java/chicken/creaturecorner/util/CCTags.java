package chicken.creaturecorner.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class CCTags {

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> GALLIAN_DEFENDABLE = tag("gallian_defendable");

        private static TagKey<EntityType<?>> tag(String name){
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("creature_corner", name));
        }
    }

    public static class Blocks {
        public static final TagKey<Block> PIGEON_LOFTS = tag("pigeon_lofts");

        private static TagKey<Block> tag(String name){
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("creature_corner", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PIGEON_EGGS = tag("pigeon_eggs");

        private static TagKey<Item> tag(String name){
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("creature_corner", name));
        }
    }


    public static class POITypes {
        public static final TagKey<PoiType> PIGEON_LOFT_POI = tag("pigeon_loft_poi");

        private static TagKey<PoiType> tag(String name){
            return TagKey.create(Registries.POINT_OF_INTEREST_TYPE, ResourceLocation.fromNamespaceAndPath("creature_corner", name));
        }
    }
}
