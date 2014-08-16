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
		
		//////////Bronze/////////////
		temp.add(new ItemStack(ItemsHandler.tinIngot,1));
		temp.add(new ItemStack(ItemsHandler.copperIngot,1));
		temp.add(new ItemStack(ItemsHandler.copperIngot,1));
		temp.add(new ItemStack(ItemsHandler.copperIngot,1));
		
		addRecipie(temp, ItemsHandler.bronzeIngot, 4);
		
		//////Brass///////
		
		temp=new ArrayList();//temporanea da cambiare
		temp.add(new ItemStack(ItemsHandler.copperIngot));
		temp.add(new ItemStack(ItemsHandler.copperIngot));
		temp.add(new ItemStack(ItemsHandler.aluminiumIngot));
		temp.add(new ItemStack(ItemsHandler.aluminiumIngot));
		
		addRecipie(temp, ItemsHandler.brassIngot, 4);
		
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
					
					int[] id1=OreDictionary.getOreIDs(tempI);
					int[] id2=OreDictionary.getOreIDs(tempI2);
					
					String s1=OreDictionary.getOreName(id1[0]);
					String s2=OreDictionary.getOreName(id2[0]);
					
					
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
	
	
	

}
