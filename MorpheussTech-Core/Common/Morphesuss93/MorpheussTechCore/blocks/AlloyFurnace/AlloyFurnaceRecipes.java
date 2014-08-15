package Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import Morphesuss93.MorpheussTechCore.items.ItemsHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class AlloyFurnaceRecipes {
	
	public static final AlloyFurnaceRecipes SMELTING_BASE = new AlloyFurnaceRecipes();
	
	private ArrayList smeltingRecipe;
	private ArrayList quantity;
	private ArrayList results;
	
	public AlloyFurnaceRecipes(){
		smeltingRecipe=new ArrayList();
		quantity=new ArrayList();
		results=new ArrayList();
		
		ArrayList temp=new ArrayList();
		temp.add(new ItemStack(ItemsHandler.tinIngot,1));
		temp.add(new ItemStack(ItemsHandler.copperIngot,1));
		
		addRecipie(temp, ItemsHandler.silverIngot, 4);
		
		temp=new ArrayList();
		temp.add(new ItemStack(ItemsHandler.tinIngot,1));
		temp.add(new ItemStack(ItemsHandler.tinIngot,1));
		temp.add(new ItemStack(ItemsHandler.copperIngot,1));
		
		addRecipie(temp, ItemsHandler.aluminiumIngot, 26);
	}
	
	public void addRecipie(ArrayList recipie, Item result,int num){
		
		smeltingRecipe.add(recipie);
		quantity.add(num);
		results.add(result);
		
	}
	
	public ItemStack getSmeltingResult(ArrayList recipie){
	
		ItemStack result=null;
		
		
		
		for(int i=0;i<smeltingRecipe.size();i++)
		{
			int t=((ArrayList)smeltingRecipe.get(i)).size();
			boolean uguali=false;
			if(recipie.size()==t){
				ArrayList temp=(ArrayList)smeltingRecipe.get(i);
				uguali=true;
				for(int j=0;j<t;j++)
				{
					ItemStack tempI=(ItemStack)temp.get(j);
					ItemStack tempI2=(ItemStack)recipie.get(j);
					String s1=OreDictionary.getOreName(tempI.getItem().getIdFromItem(tempI.getItem()));
					String s2=OreDictionary.getOreName(tempI2.getItem().getIdFromItem(tempI2.getItem()));
					if(!s1.equals(s2))
					{
						uguali=false;
					}
				}
				
			}
			if(uguali){
				result=new ItemStack((Item)results.get(i),(int)quantity.get(i));
			}
		}
		return result;
	}
	
	
	/*public static final AlloyFurnaceRecipes SMELTING_BASE = new AlloyFurnaceRecipes();
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
	}*/

}
