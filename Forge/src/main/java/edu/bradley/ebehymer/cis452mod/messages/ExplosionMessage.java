package edu.bradley.ebehymer.cis452mod.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ExplosionMessage implements IMessage {

//	public ExplosionMessage() {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub

	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub

	}

	public static class Handler implements IMessageHandler<ExplosionMessage, IMessage>{

		@Override
		public IMessage onMessage(ExplosionMessage message, MessageContext ctx) {
			
			Runnable task = () -> handle(message, ctx);
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(task);
			return null;
		}
		
		//Called in the Minecraft main thread
		private static void handle(ExplosionMessage message, MessageContext ctx){
			
			EntityPlayerMP player = ctx.getServerHandler().player;
			World world = player.getEntityWorld();
			boolean SMOKING = true;
			
			if(! world.isRemote){
			world.createExplosion(player, player.posX, player.posY, player.posZ, 4.0f, SMOKING);
			}
		}
	}
}
