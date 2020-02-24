package occult.mod.items;

import occult.mod.init.ModItems;
import net.minecraft.item.Item;
import occult.mod.OccultMod;
import occult.mod.util.IHasModel;

public class ItemBase extends Item implements IHasModel {

protected String name;
	
	public ItemBase(String n) {
		
		name = n;
		
		setUnlocalizedName(n);
		setRegistryName(n);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		
		OccultMod.proxy.registerItemRenderer(this, 0, name);
	}

}
