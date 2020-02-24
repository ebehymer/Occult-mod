package occult.mod.entity;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import occult.mod.util.LootTableHandler;


public class EntitySatan extends EntityBlaze {


	public EntitySatan(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.95F);
		
	}
	
	@Override
	public boolean isImmuneToExplosions() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	protected void initEntityAI() {
		
		this.tasks.addTask(7, new EntitySatan.AIFireballAttack(this));
		
		 this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));  
	}
	
	@Override
	protected ResourceLocation getLootTable() {
		
		return LootTableHandler.SATAN;
	}
	
	@Override
	protected void applyEntityAttributes() {
		
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D); //Sets health to 150 hearts = Wither
	}

	//Modified so that Satan would shoot large fireballs instead of small ones
	  static class AIFireballAttack extends EntityAIBase
      {
          private final EntitySatan satan;
          private int attackStep;
          private int attackTime;

          public AIFireballAttack(EntitySatan satanIn)
          {
              this.satan = satanIn;
              this.setMutexBits(3);
          }

          /**
           * Returns whether the EntityAIBase should begin execution.
           */
          public boolean shouldExecute()
          {
              EntityLivingBase entitylivingbase = this.satan.getAttackTarget();
              return entitylivingbase != null && entitylivingbase.isEntityAlive();
          }

          /**
           * Execute a one shot task or start executing a continuous task
           */
          public void startExecuting()
          {
              this.attackStep = 0;
          }

          /**
           * Reset the task's internal state. Called when this task is interrupted by another one
           */
          public void resetTask()
          {
              this.satan.setOnFire(false);
          }

          /**
           * Keep ticking a continuous task that has already been started
           */
          public void updateTask()
          {
              --this.attackTime;
              EntityLivingBase entitylivingbase = this.satan.getAttackTarget();
              double d0 = this.satan.getDistanceSq(entitylivingbase);

              if (d0 < 4.0D)
              {
                  if (this.attackTime <= 0)
                  {
                      this.attackTime = 20;
                      this.satan.attackEntityAsMob(entitylivingbase);
                  }

                  this.satan.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
              }
              else if (d0 < this.getFollowDistance() * this.getFollowDistance())
              {
                  double d1 = entitylivingbase.posX - this.satan.posX;
                  double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.satan.posY + (double)(this.satan.height / 2.0F));
                  double d3 = entitylivingbase.posZ - this.satan.posZ;

                  if (this.attackTime <= 0)
                  {
                      ++this.attackStep;

                      if (this.attackStep == 1)
                      {
                          this.attackTime = 60;
                          this.satan.setOnFire(true);
                      }
                      else if (this.attackStep <= 4)
                      {
                          this.attackTime = 6;
                      }
                      else
                      {
                          this.attackTime = 100;
                          this.attackStep = 0;
                          this.satan.setOnFire(false);
                      }

                      if (this.attackStep > 1)
                      {
                          float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                          this.satan.world.playEvent((EntityPlayer)null, 1018, new BlockPos((int)this.satan.posX, (int)this.satan.posY, (int)this.satan.posZ), 0);

                          for (int i = 0; i < 1; ++i)
                          {
                              EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.satan.world, this.satan, d1 + this.satan.getRNG().nextGaussian() * (double)f, d2, d3 + this.satan.getRNG().nextGaussian() * (double)f);
                              entitylargefireball.posY = this.satan.posY + (double)(this.satan.height / 2.0F) + 0.5D;
                              this.satan.world.spawnEntity(entitylargefireball);
                          }
                      }
                  }

                  this.satan.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
              }
              else
              {
                  this.satan.getNavigator().clearPath();
                  this.satan.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
              }

              super.updateTask();
          }

          private double getFollowDistance()
          {
              IAttributeInstance iattributeinstance = this.satan.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
              return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
          }
      }


}
