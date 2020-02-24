package edu.bradley.ebehymer.cis452mod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockNonOpaque extends BlockBase {

	public BlockNonOpaque(String n, Material material) {
		super(n, material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isFullCube(IBlockState state){	
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
}
