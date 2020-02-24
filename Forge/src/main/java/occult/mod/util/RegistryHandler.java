package occult.mod.util;

import occult.mod.Reference;
import occult.mod.init.ModBlocks;
import occult.mod.init.ModEntity;
import occult.mod.init.ModItems;
import occult.mod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {

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
	public static void preInitRegistries(FMLPreInitializationEvent event){
		
		ModEntity.registerEntities();
		RenderHandler.registerEntityRenders();
	}
	
	//Satan will not work if these are not here
	public static void initRegistries(FMLInitializationEvent event)
	{}
	
	
	public static void postInitRegistries(FMLPostInitializationEvent event)
	{}
}
