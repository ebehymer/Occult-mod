package occult.mod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import occult.mod.proxy.IProxy;
import occult.mod.util.RegistryHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MINECRAFT_VERSIONS)
public class OccultMod {

	
		@Instance
		public static OccultMod instance;
		
		@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
		public static IProxy proxy;
		
		
		@EventHandler
		public void preInit(FMLPreInitializationEvent event){
		
			RegistryHandler.preInitRegistries(event);
		}
		
		
		@EventHandler
		public static void init(FMLInitializationEvent event)
		{
			RegistryHandler.initRegistries(event);
		}
		
		@EventHandler
		public static void postInit(FMLPostInitializationEvent event) 
		{
			RegistryHandler.postInitRegistries(event);
		}


}
