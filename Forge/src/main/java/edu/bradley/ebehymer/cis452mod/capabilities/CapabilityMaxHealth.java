package edu.bradley.ebehymer.cis452mod.capabilities;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class CapabilityMaxHealth {

	@CapabilityInject(IMaxHealth.class)
	public static final Capability<IMaxHealth> MAX_HEALTH_CAPABILITY = null;
	public static final EnumFacing DEFAULT_FACING = null;
	
	@Nullable
	public static IMaxHealth getMaxHealth(final EntityLivingBase entity){
		
		if((entity == null)||(!entity.hasCapability(MAX_HEALTH_CAPABILITY, DEFAULT_FACING))){
			return null;
		}
		return entity.getCapability(MAX_HEALTH_CAPABILITY, DEFAULT_FACING);
	}
	
	public static ICapabilityProvider createProvider(final IMaxHealth maxHealth){
		
		return new CapabilityProvider<>(MAX_HEALTH_CAPABILITY, DEFAULT_FACING, maxHealth);
	}
	
	public static void register(){
		
		class Storage implements Capability.IStorage<IMaxHealth>{

			@Override
			public NBTBase writeNBT(Capability<IMaxHealth> capability, IMaxHealth instance, EnumFacing side) {
				
				return new NBTTagFloat(instance.getBonusMaxHealth());
			}

			@Override
			public void readNBT(Capability<IMaxHealth> capability, IMaxHealth instance, EnumFacing side, NBTBase nbt) {
			
				NBTTagFloat tagValue = (NBTTagFloat) nbt;
				instance.setBonusMaxHealth(tagValue.getFloat());
				
			}
			
			
		}
	}
}
