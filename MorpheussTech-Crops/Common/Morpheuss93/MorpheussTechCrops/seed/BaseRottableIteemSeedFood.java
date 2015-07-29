package Morpheuss93.MorpheussTechCrops.seed;

import Morpheuss93.MorpheussTechCrops.food.FoodHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BaseRottableIteemSeedFood extends BaseItemSeedFood{
	
	public static long old_time[];//a posizione par1
	public static int old_stack_pos=-1;
	public static boolean canRot=true;
	

	public BaseRottableIteemSeedFood(int parHealAmount,
			float parSaturationModifier, Block parBlockPlant, Block parSoilBlock) {
		super(parHealAmount, parSaturationModifier, parBlockPlant, parSoilBlock);
		
		this.setMaxDamage(25);
		
		old_time=new long[64];
		for(int i=0;i<64;i++){
			old_time[i]=0;
		}
		
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par1, boolean par2) {//par1=slot_pos
		super.onUpdate(itemstack, world, entity, par1, par2);//fare un rottable item
		
		
			int dam=itemstack.getItemDamage();
			long time=System.currentTimeMillis()/1000;
			
			if(time%24==0 )
			{
				
				if(dam <25 &&time!=old_time[par1])
				{
					old_time[par1]=time;
					//old_stack_pos=par1;
					itemstack.setItemDamage(dam+1);
					//System.out.println("Time Millis: "+System.currentTimeMillis());
				}
			}
			else{
				old_stack_pos=-1;
			}
			
			if(dam==24){
				if(entity instanceof EntityPlayer)
				{
					ItemStack it=new ItemStack(FoodHandler.rottenStuff,itemstack.stackSize);
					EntityPlayer player=(EntityPlayer) entity;
					player.inventory.setInventorySlotContents(par1, it);;
				}
				
			}
			
	}

}
