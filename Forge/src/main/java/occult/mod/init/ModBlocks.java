package occult.mod.init;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import occult.mod.blocks.BlockNonOpaque;

public class ModBlocks {

	public static List<Block> Blocks = new ArrayList<Block>();
	
	public static Block CANDLE_BLOCK = new BlockNonOpaque("candle_block", Material.WOOD);
			
}
