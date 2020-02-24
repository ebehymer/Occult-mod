package edu.bradley.ebehymer.cis452mod.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class BlockQueryMessage implements IMessage {

	private BlockPos blockPos;
	
	public BlockQueryMessage() {
		RayTraceResult mouseOver = Minecraft.getMinecraft().objectMouseOver;
		blockPos = mouseOver.getBlockPos();
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// Called when Message Received buf = packet buffer
		blockPos = BlockPos.fromLong(buf.readLong());
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// build the packet buffer from the message data
		buf.writeLong(blockPos.toLong());
	}
	
	public static class Handler implements IMessageHandler<BlockQueryMessage, IMessage>{

		@Override
		public IMessage onMessage(BlockQueryMessage message, MessageContext ctx) {
			Runnable task = () -> handle(message, ctx);
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(task);
			return null;
		}

		//main thread's handler like onMessage for the main thread
		private void handle(BlockQueryMessage message, MessageContext ctx) {
			
			EntityPlayerMP playerEntity = ctx.getServerHandler().player;
			World world = playerEntity.getEntityWorld();
			BlockPos position = message.blockPos;
			
			if(world.isBlockLoaded(position)){
				
			Block block = world.getBlockState(position).getBlock();
			TextComponentString msg = new TextComponentString(TextFormatting.GREEN + "Hit Block: " + block.getRegistryName());
			playerEntity.sendStatusMessage(msg, false);
			}
		}
	}

}
