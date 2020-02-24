package edu.bradley.ebehymer.cis452mod.init;

import org.lwjgl.input.Keyboard;

import edu.bradley.ebehymer.cis452mod.Reference;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Note that SideOnly remove the class from the server JAR. This is called ..
@SideOnly(Side.CLIENT)
public class KeyBindings {

	public static KeyBinding queryKey;
	public static KeyBinding explodeKey;
	
	public static void init(){
		
		queryKey = new KeyBinding("key."+ Reference.MOD_ID + ".query", Keyboard.KEY_G, "key.categories"+ Reference.MOD_ID);
		ClientRegistry.registerKeyBinding(queryKey);
		
		explodeKey = new KeyBinding("key."+ Reference.MOD_ID + ".explode", Keyboard.KEY_H, "key.categories"+ Reference.MOD_ID);
		ClientRegistry.registerKeyBinding(explodeKey);
	}
	
//	public KeyBindings() {
//		// TODO Auto-generated constructor stub
//	}

}
