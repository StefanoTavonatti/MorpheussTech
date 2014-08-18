package Morpheuss93.MorpheussTechCrops.items.tools;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class Machete extends ItemSword{

	public Machete(ToolMaterial material,String name) {
		super(material);
		this.setCreativeTab(MCrops.tabCrop);
		this.configure(name);
	}
	
	public void configure(String name){
		this.setUnlocalizedName(name);
		this.setTextureName(Reference.MODID+":"+name);
	}

	@Override
	 public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entity){
		 
		if(block.getUnlocalizedName().equals("tile.tallgrass")&& !world.isRemote){
			System.out.println(block.getUnlocalizedName()+ " "+itemstack.getItem().getUnlocalizedName());
			EntityItem item=new EntityItem(world,(double)x,(double)y,(double)z,new ItemStack(Items.baked_potato,1));
			world.spawnEntityInWorld(item);
			System.out.println("Danno prima= "+itemstack.getItemDamage());
			itemstack.damageItem(1, entity);
			System.out.println("Danno dopo= "+itemstack.getItemDamage());
		}
		
		/*if(block.getUnlocalizedName().equals("tile.tallgrass") && !world.isRemote){//funziona ma drop da playere
			 System.out.println();
			 entity.entityDropItem(new ItemStack(Items.porkchop,1),0.0F);
			 EntityPlayer pla=(EntityPlayer)entity;
			
			 
		 }*/
		 return super.onBlockDestroyed(itemstack, world, block, x, y, z, entity);
	 }
}
