package chicken.creaturecorner.client;

import chicken.creaturecorner.CCConstants;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class CCModelLayers {

    public static final ModelLayerLocation GALLIAN =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "gallian"), "main");

    public static final ModelLayerLocation GALLIAN_CHICK =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "gallian_chick"), "main");


    public static final ModelLayerLocation PIGEON =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "pigeon"), "main");
    public static final ModelLayerLocation BABY_PIGEON =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "baby_pigeon"), "main");
    public static final ModelLayerLocation ENDOVE =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "endove"), "main");
    public static final ModelLayerLocation BABY_ENDOVE =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "baby_endove"), "main");

    public static final ModelLayerLocation PIGEON_LOFT =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "pigeon_loft"), "main");
    public static final ModelLayerLocation BABY_PIGEON_LOFT =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CCConstants.MOD_ID, "baby_pigeon_loft"), "main");
}
