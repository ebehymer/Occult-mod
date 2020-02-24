package edu.bradley.ebehymer.cis452mod.init;

import java.util.ArrayList;
import java.util.List;

import edu.bradley.ebehymer.cis452mod.blocks.BlockBase;
import edu.bradley.ebehymer.cis452mod.blocks.BlockNonOpaque;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

public static List<Block> Blocks = new ArrayList<Block>();	
	
	public static Block CHEESE_BLOCK = new BlockBase("cheese_block", Material.ROCK);
	
	public static Block CHAIR_BLOCK = new BlockNonOpaque("chair_block", Material.WOOD);
	
	public static Block MAYA_BLOCK = new BlockNonOpaque("maya_block",Material.PLANTS);

}
