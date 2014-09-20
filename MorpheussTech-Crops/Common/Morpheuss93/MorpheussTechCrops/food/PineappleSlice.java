package Morpheuss93.MorpheussTechCrops.food;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class PineappleSlice extends ItemFood{

	public PineappleSlice() {
		super(6,0.6F, false);
		this.setUnlocalizedName("PineappleSlice");
		this.setTextureName(Reference.MODID+":PineappleSlice");
		this.setCreativeTab(MCrops.tabCrop);
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par1, boolean par2) {
		super.onUpdate(itemstack, world, entity, par1, par2);
		
		int dam=itemstack.getItemDamage();
		System.out.println("asssssssssssssssss "+Minecraft.getMinecraft().getSystemTime());
		
		if(entity.ticksExisted%1000==0 && dam <25)
		{
			itemstack.setItemDamage(dam+1);
		}
		
		if(dam==25){
			
			if(entity instanceof EntityPlayer)
			{
				ItemStack it=new ItemStack(FoodHandler.rottenStuff,itemstack.stackSize);
				EntityPlayer player=(EntityPlayer) entity;
				player.inventory.setInventorySlotContents(par1, it);;
			}
			
		}
		
	}
}
