package occult.mod.util;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import occult.mod.entity.EntitySatan;
import occult.mod.entity.render.RenderSatan;

public class RenderHandler {

	public static void registerEntityRenders(){
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySatan.class, new IRenderFactory<EntitySatan>(){
			
			@Override
			public Render<? super EntitySatan> createRenderFor(RenderManager manager){
				
				return new RenderSatan(manager);
			}
		});
	}
}
