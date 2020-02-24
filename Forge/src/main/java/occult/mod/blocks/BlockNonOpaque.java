package occult.mod.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockNonOpaque extends BlockBase {

	public BlockNonOpaque(String name, Material materialIn) {
		super(name, materialIn);
		
	}
	
	@Override
	public boolean isFullCube(IBlockState state){	
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	//Since Candle is the only Block I created I added this in so it would give off light
	@Override
	public int getLightValue(IBlockState state) {
		
		return 200;
	}

}
