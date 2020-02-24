package occult.mod.blocks;

import occult.mod.OccultMod;
import occult.mod.init.ModBlocks;
import occult.mod.init.ModItems;
import occult.mod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{
	
	protected String n;

	public BlockBase(String name, Material materialIn) {
		super(materialIn);
		n = name;
		
		setUnlocalizedName(n);
		setRegistryName(n);
		ModBlocks.Blocks.add(this);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ModItems.ITEMS.add(itemBlock);
	}

	@Override
	public void registerModels() {
		Item itemBlock = Item.getItemFromBlock(this);
		OccultMod.proxy.registerItemRenderer(itemBlock, 0, "inventory");
		
	}



}
