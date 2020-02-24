package edu.bradley.ebehymer.cis452mod.util;

import edu.bradley.ebehymer.cis452mod.Reference;
import edu.bradley.ebehymer.cis452mod.init.KeyBindings;
import edu.bradley.ebehymer.cis452mod.init.MessageManager;
import edu.bradley.ebehymer.cis452mod.messages.BlockQueryMessage;
import edu.bradley.ebehymer.cis452mod.messages.ExplosionMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@EventBusSubscriber(modid=Reference.MOD_ID)
public class InputHandler {

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent event){
		
		if (KeyBindings.queryKey.isPressed()){
			
			if(Minecraft.getMinecraft().objectMouseOver.getBlockPos() != null){
				
			MessageManager.INSTANCE.sendToServer(new BlockQueryMessage());
			}
		}
		
		if (KeyBindings.explodeKey.isPressed()){
			
			MessageManager.INSTANCE.sendToServer(new ExplosionMessage());
		}
	}
//	public InputHandler() {
//		// TODO Auto-generated constructor stub
//	}

}
