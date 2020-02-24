package edu.bradley.ebehymer.cis452mod.proxy;

import edu.bradley.ebehymer.cis452mod.init.KeyBindings;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy implements IProxy {

//	public ClientProxy() {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void registerItemRenderer(Item item, int meta, String name) {

		ModelResourceLocation location = new ModelResourceLocation(item.getRegistryName(), name);
		System.out.println("setting model resource location model" + item.getUnlocalizedName());
		ModelLoader.setCustomModelResourceLocation(item, meta, location);

	}

	@Override
	public void registerKeyBindings() {
		
		KeyBindings.init();

	}

}
