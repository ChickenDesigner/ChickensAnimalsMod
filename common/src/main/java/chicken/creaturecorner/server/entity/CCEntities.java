package chicken.creaturecorner.server.entity;

import chicken.creaturecorner.CCConstants;
import chicken.creaturecorner.platform.Services;
import chicken.creaturecorner.server.entity.obj.*;
import chicken.creaturecorner.server.entity.obj.eggs.CaracaraEggEntity;
import chicken.creaturecorner.server.entity.obj.eggs.EndoveEggEntity;
import chicken.creaturecorner.server.entity.obj.eggs.PigeonEggEntity;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class CCEntities {

    public static final Supplier<EntityType<Pigeon>> PIGEON =
            register("pigeon",
                    () -> EntityType.Builder.of(Pigeon::new, MobCategory.CREATURE)
                            .sized(0.7f, 0.9f)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "pigeon").toString()));

    public static final Supplier<EntityType<Endove>> ENDOVE =
            register("endove",
                    () -> EntityType.Builder.of(Endove::new, MobCategory.CREATURE)
                            .sized(0.7f, 0.9f)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "endove").toString()));

    public static final Supplier<EntityType<CaracaraEntity>> CARACARA =
            register("caracara",
                    () -> EntityType.Builder.of(CaracaraEntity::new, MobCategory.CREATURE)
                            .sized(1f, 1f)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "caracara").toString()));

    public static final Supplier<EntityType<CoyoteEntity>> COYOTE =
            register("coyote",
                    () -> EntityType.Builder.of(CoyoteEntity::new, MobCategory.CREATURE)
                            .sized(0.7F, 0.8F)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "coyote").toString()));


    public static final Supplier<EntityType<GallianEntity>> GALLIAN =
            register("gallian",
                    () -> EntityType.Builder.of(GallianEntity::new, MobCategory.CREATURE)
                            .sized(1.25f, 2.9f)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "gallian").toString()));

    public static final Supplier<EntityType<CaracaraEggEntity>> CARACARA_EGG =
            register("caracara_egg",
                    () -> EntityType.Builder.<CaracaraEggEntity>of(CaracaraEggEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "caracara_egg").toString()));

    public static final Supplier<EntityType<PigeonEggEntity>> PIGEON_EGG =
            register("pigeon_egg",
                    () -> EntityType.Builder.<PigeonEggEntity>of(PigeonEggEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "pigeon_egg").toString()));

    public static final Supplier<EntityType<EndoveEggEntity>> ENDOVE_EGG =
            register("endove_egg",
                    () -> EntityType.Builder.<EndoveEggEntity>of(EndoveEggEntity::new, MobCategory.MISC)
                            .sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
                            .build(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "endove_egg").toString()));


    public static<T extends Entity> Supplier<EntityType<T>> register(String s, Supplier<EntityType<T>> item) {
        item = Suppliers.memoize(item);
        Services.PLATFORM.register(BuiltInRegistries.ENTITY_TYPE, s, item::get);
        return item;
    }
}
