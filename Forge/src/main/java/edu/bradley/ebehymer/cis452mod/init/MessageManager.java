package edu.bradley.ebehymer.cis452mod.init;

import edu.bradley.ebehymer.cis452mod.messages.BlockQueryMessage;
import edu.bradley.ebehymer.cis452mod.messages.ExplosionMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class MessageManager {

//	public MessageManager() {
//		// TODO Auto-generated constructor stub
//	}

	private static int packetID = 0; //packet type
	
	public static SimpleNetworkWrapper INSTANCE = null;
	
	private static int nextID(){
		
		return packetID++;
	}
	
	public static void registerMessages(String channelName){
		
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		registerMessages();
	}
	public static void registerMessages(){
		INSTANCE.registerMessage(BlockQueryMessage.Handler.class, BlockQueryMessage.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(ExplosionMessage.Handler.class, ExplosionMessage.class, nextID(), Side.SERVER);
	}
}
