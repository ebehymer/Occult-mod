package edu.bradley.ebehymer.cis452mod.capabilities;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class CapabilityProvider<INTERFACE> implements ICapabilityProvider, INBTSerializable<NBTBase> {

	protected final Capability<INTERFACE> c; // c  means capability
	protected final EnumFacing f; //f means facing
	protected final INTERFACE i; //i means instance
	
	public CapabilityProvider(final Capability<INTERFACE> capability,@Nullable final EnumFacing facing,@Nullable final INTERFACE instance ) {
		
		c = capability;
		f = facing;
		i = instance;
	}
	
	@Nullable
	public EnumFacing getFacing(){
		
		return f;
	}
	
	@Nullable
	public final INTERFACE getInstance(){
		
		return i;
	}
	
	public final Capability<INTERFACE> getCapability(){
		
		return c;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		
		return c == getCapability();
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		
		if(hasCapability(c,f)){
			
			return getCapability().cast(getInstance());
		}
		
		return null;
	}

	@Override
	public NBTBase serializeNBT() {
		
		if(c != null){
			
			return c.writeNBT(i, f);
		}
		return null;
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		
		if(c != null){
			
			c.readNBT(i, f, nbt);
		}
		
	}

}
