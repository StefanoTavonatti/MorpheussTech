package Morpheuss93.MorpheussTechCrops.items.tools;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class Knife extends ItemSword{

	public Knife() {
		super(ToolMaterial.STONE);
		this.setUnlocalizedName("Knife");
		this.setTextureName(Reference.MODID+":Knife");
		this.setCreativeTab(MCrops.tabCrop);
		this.setMaxStackSize(1);
		this.setMaxDamage(192);
		
	}
	
	 public boolean doesContainerItemLeaveCraftingGrid(ItemStack p_77630_1_)
	    {
	        return false;
	    }
	 
	 @Override
	public ItemStack getContainerItem(ItemStack itemStack) {
		// TODO Auto-generated method stub
		//return super.getContainerItem(itemStack);
		 ItemStack it=new ItemStack(itemStack.getItem());
		 it.setItemDamage(itemStack.getItemDamage()+1);
		 return it;
	}
}
