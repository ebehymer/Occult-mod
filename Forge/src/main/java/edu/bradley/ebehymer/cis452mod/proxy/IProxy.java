package edu.bradley.ebehymer.cis452mod.proxy;

import net.minecraft.item.Item;

public interface IProxy {

	public void registerItemRenderer(Item item, int meta, String name);
	public void registerKeyBindings();
	
}
