package occult.mod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import occult.mod.Reference;
import occult.mod.entity.EntitySatan;
import occult.mod.entity.model.ModelSatan;

public class RenderSatan extends RenderLiving<EntitySatan>{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID+ ":textures/entity/satan.png");
	
	public RenderSatan(RenderManager manager) {
		super(manager, new ModelSatan(), 0.5f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySatan entity) {
		
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntitySatan entityLiving, float p_77043_2_, float rotationYaw, float partialTicks){
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
