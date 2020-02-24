package edu.bradley.ebehymer.cis452mod.items;

import edu.bradley.ebehymer.cis452mod.MyMod;
import edu.bradley.ebehymer.cis452mod.init.ModItems;
import edu.bradley.ebehymer.cis452mod.util.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	protected String name;
	
	public ItemBase(String n) {
		// TODO Auto-generated constructor stub
		name = n;
		
		setUnlocalizedName(n);
		setRegistryName(n);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		MyMod.proxy.registerItemRenderer(this, 0, name);
	}
	


}
