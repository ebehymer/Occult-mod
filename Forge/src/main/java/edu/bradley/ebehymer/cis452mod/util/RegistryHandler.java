package edu.bradley.ebehymer.cis452mod.util;

import occult.mod.Reference;
import occult.mod.init.ModBlocks;
import occult.mod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {

	//Handler package??
//	public RegistryHandler() {
//		// TODO Auto-generated constructor stub
//	}
	
	@SubscribeEvent 
	public static void onItemRegister(RegistryEvent.Register<Item> event){
		
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
		
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event){
		
		event.getRegistry().registerAll(ModBlocks.Blocks.toArray(new Block[0]));
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){
		
		for(Item item : ModItems.ITEMS){
			
			if(item instanceof IHasModel){
				
				((IHasModel) item).registerModels();
			}
			
		}
		
	
	for(Block block : ModBlocks.Blocks){
		
		if(block instanceof IHasModel){
			
			((IHasModel) block).registerModels();
		}
		
	}
	
}
}
