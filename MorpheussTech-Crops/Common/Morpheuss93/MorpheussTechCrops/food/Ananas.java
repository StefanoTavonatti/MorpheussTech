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
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;

public class Ananas extends BaseItemSeedFood{

	public Ananas(){
		super(6,0.6F,CropsHandler.ananasPlant,Blocks.farmland);
		setUnlocalizedName("Ananas");
		setTextureName(Reference.MODID+":Ananas");
		setCreativeTab(MCrops.tabCrop);
		
		this.setMaxStackSize(64);
		this.setMaxDamage(25);
		
	}
	
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par1, boolean par2) {
		super.onUpdate(itemstack, world, entity, par1, par2);
		
		int dam=itemstack.getItemDamage();
		
		if(entity.ticksExisted%1000==0 && dam <25)
		{
			itemstack.setItemDamage(dam+1);
		}
		
		if(dam==25){
			//itemstack=new ItemStack(Items.rotten_flesh,itemstack.stackSize);//oncrafting
			
			if(entity instanceof EntityPlayer)
			{
				ItemStack it=new ItemStack(Items.rotten_flesh,itemstack.stackSize);
				EntityPlayer player=(EntityPlayer) entity;
				player.inventory.setInventorySlotContents(par1, it);;
			}
			
		}
		
	}
}
