package Morpheuss93.MorpheussTechCrops.seed;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.CraftingManager.ShaplessRecipeDamages;
import Morpheuss93.MorpheussTechCrops.food.FoodHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class SeedHandler {

	public static AnanasSeed ananasSeed;
	public static CottonSeed cottonSeed;
	public static Corn corn;
	
	public static void configure(){
		ananasSeed=new AnanasSeed();
		GameRegistry.registerItem(ananasSeed, Reference.MODID+"-"+ananasSeed.getUnlocalizedName().substring(5)); 
		
		cottonSeed=new CottonSeed();
		GameRegistry.registerItem(cottonSeed, Reference.MODID+"-"+cottonSeed.getUnlocalizedName().substring(5));
		
		corn=new Corn();
		GameRegistry.registerItem(corn, Reference.MODID+"-"+corn.getUnlocalizedName().substring(5));
		
		
		configureRecipe();
	}
	
	public static void configureRecipe(){
		List l=new ArrayList();
		l.add(new ItemStack(FoodHandler.corncob));
		GameRegistry.addRecipe(new ShaplessRecipeDamages(new ItemStack(corn,8),l));
	}
}
