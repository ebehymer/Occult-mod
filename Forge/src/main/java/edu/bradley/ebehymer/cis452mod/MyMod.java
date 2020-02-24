package edu.bradley.ebehymer.cis452mod;

import edu.bradley.ebehymer.cis452mod.init.MessageManager;
import edu.bradley.ebehymer.cis452mod.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.MINECRAFT_VERSIONS)
public class MyMod {

	@Instance
	public static MyMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
	
		MessageManager.registerMessages("mymod_channel");
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
	
		proxy.registerKeyBindings();
	
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
	
	
	}
	
//	public MyMod() {
//		// TODO Auto-generated constructor stub
//		
//	}

}
