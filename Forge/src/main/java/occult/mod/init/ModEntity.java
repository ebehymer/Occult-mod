package occult.mod.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import occult.mod.OccultMod;
import occult.mod.Reference;
import occult.mod.entity.EntitySatan;

public class ModEntity {

	public static void registerEntities(){
		registerEntity("satan", EntitySatan.class, Reference.ENTITY_SATAN, 55, 16711695, 000000);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2){
		
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID+":"+ name), entity, name, id, OccultMod.instance, range, 1, true, color1, color2);
	}
}
