package edu.bradley.ebehymer.cis452mod.blocks;

import edu.bradley.ebehymer.cis452mod.MyMod;
import edu.bradley.ebehymer.cis452mod.init.ModBlocks;
import edu.bradley.ebehymer.cis452mod.init.ModItems;
import edu.bradley.ebehymer.cis452mod.util.IHasModel;
import net.minecraft.block.Block;
//import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {
	
	protected String name;

	public BlockBase(String n, Material material) {
		super(material);
		
		name = n;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.Blocks.add(this);
		
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(this.getRegistryName());
		ModItems.ITEMS.add(itemBlock);
	}

//	public BlockBase(Material blockMaterialIn, MapColor blockMapColorIn) {
//		super(blockMaterialIn, blockMapColorIn);
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void registerModels() {
		// TODO Auto-generated method stub

		Item itemBlock = Item.getItemFromBlock(this);
		MyMod.proxy.registerItemRenderer(itemBlock, 0, "inventory");
	}

}
