package chicken.creaturecorner.client.renderer.entity.geckolib;

import chicken.creaturecorner.client.model.entity.EndoveModel;
import chicken.creaturecorner.server.entity.obj.Endove;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EndoveRenderer extends GeoEntityRenderer<Endove> {

   public EndoveRenderer(EntityRendererProvider.Context renderManager) {
       super(renderManager, new EndoveModel());
   }

}
