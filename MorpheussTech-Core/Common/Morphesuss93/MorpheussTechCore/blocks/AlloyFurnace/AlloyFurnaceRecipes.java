package Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Morphesuss93.MorpheussTechCore.items.ItemsHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyFurnaceRecipes {
	
	private static final AlloyFurnaceRecipes SMELTING_BASE = new AlloyFurnaceRecipes();
	private Map smeltingList=new HashMap();
	private Map experienceList=new HashMap();
	//private Set recipe=new TreeSet();
	
	public AlloyFurnaceRecipes(){
		Set recipie=new TreeSet();
		recipie.add(new ItemStack(ItemsHandler.copperIngot,1));
		recipie.add(new ItemStack (ItemsHandler.tinIngot,1));
		
		this.addRecipie(ItemsHandler.silverIngot,recipie,0.5F);
	}
	
	public void addRecipie(Item item, Set recipie,float experience){
		smeltingList.put(recipie,new ItemStack(item,1));
		experienceList.put(new ItemStack(item,1), experience);
	}
	
	public ItemStack getSmeltingResult(Set recipie){
		
		Iterator iterator=this.smeltingList.entrySet().iterator();
		
		ItemStack itemstack=(ItemStack) smeltingList.get(recipie);
		return itemstack;
	}

}
