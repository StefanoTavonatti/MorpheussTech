package Morpheuss93.MorpheussTechCrops.food;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.seed.BaseItemSeedFood;
import Morpheuss93.MorpheussTechCrops.seed.BaseRottableIteemSeedFood;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;

public class Ananas extends BaseRottableIteemSeedFood{

	public Ananas(){
		super(6,0.6F,CropsHandler.ananasPlant,Blocks.farmland);
		setUnlocalizedName("Ananas");
		setTextureName(Reference.MODID+":Ananas");
		setCreativeTab(MCrops.tabCrop);
		
		this.setMaxStackSize(1);
		
		/*old_time=new long[64];
		for(int i=0;i<64;i++){
			old_time[i]=0;
		}*/
		
		
	}
	
	/*public static long old_time[];//a posizione par1
	public static int old_stack_pos=-1;*/
	//public static int[] giaUtdatati;//imp questo
	
	/*public void onUpdate(ItemStack itemstack, World world, Entity entity, int par1, boolean par2) {//par1=slot_pos
		super.onUpdate(itemstack, world, entity, par1, par2);
		
		int dam=itemstack.getItemDamage();
		//System.out.println("asssssssssssssssss "+entity.ticksExisted);
		//System.out.println("Time Millis: "+par1);
		//if(entity.ticksExisted%1000==0 && dam <25)
		long time=System.currentTimeMillis()/1000;
		
		if(time%24==0 )
		{
			
			if(dam <25 &&time!=old_time[par1])
			{
				old_time[par1]=time;
				//old_stack_pos=par1;
				itemstack.setItemDamage(dam+1);
				System.out.println("Time Millis: "+System.currentTimeMillis());
			}
		}
		else{
			old_stack_pos=-1;
		}
		
		if(dam==25){
			//itemstack=new ItemStack(Items.rotten_flesh,itemstack.stackSize);//oncrafting
			
			if(entity instanceof EntityPlayer)
			{
				ItemStack it=new ItemStack(FoodHandler.rottenStuff,itemstack.stackSize);
				EntityPlayer player=(EntityPlayer) entity;
				player.inventory.setInventorySlotContents(par1, it);;
			}
			
		}
		
	}*/
}
