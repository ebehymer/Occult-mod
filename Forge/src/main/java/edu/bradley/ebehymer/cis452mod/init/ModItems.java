package edu.bradley.ebehymer.cis452mod.init;

import java.util.ArrayList;
import java.util.List;

import edu.bradley.ebehymer.cis452mod.items.ItemBase;
import edu.bradley.ebehymer.cis452mod.items.ItemWand;
import net.minecraft.item.Item;

public class ModItems {
	
	
	public static List<Item> ITEMS = new ArrayList<Item>();
	
	public static Item CHEESE = new ItemBase("cheese");

	public static Item CHEESE_CRAKER = new ItemBase("cheese_cracker");
	public static Item CRACKER = new ItemBase("cracker");

	public static Item JAR = new ItemBase("glass_jar");
	
	public static Item Wand = new ItemWand("wand");

}
