package edu.bradley.ebehymer.cis452mod.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class ItemWand extends ItemBase {

	public ItemWand(String n) {
		super(n);
		
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand){
		
	if(! playerIn.world.isRemote){
		TextComponentString msg = new TextComponentString(TextFormatting.GREEN + "Hit Target" + target.getName());
		playerIn.sendStatusMessage(msg, false);
	}
		return true;
	}
	
}