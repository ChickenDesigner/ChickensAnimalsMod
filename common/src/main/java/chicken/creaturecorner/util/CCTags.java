package chicken.creaturecorner.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class CCTags {

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> GALLIAN_DEFENDABLE = tag("gallian_defendable");

        private static TagKey<EntityType<?>> tag(String name){
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("creature_corner", name));
        }
    }
}
