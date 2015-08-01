package Morpheuss93.MorpheussTechCrops.items;


import java.util.ArrayList;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import Morphesuss93.MorpheussTechCore.Materials;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.AlloyFurnaceRecipes;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.CraftingManager.ShaplessRecipeDamages;
import Morpheuss93.MorpheussTechCrops.food.FoodHandler;
import Morpheuss93.MorpheussTechCrops.items.consumables.FishingNet;
import Morpheuss93.MorpheussTechCrops.items.craftingComponent.CottonCloth;
import Morpheuss93.MorpheussTechCrops.items.tools.Knife;
import Morpheuss93.MorpheussTechCrops.items.tools.Machete;

public class ItemsHandler {

	public static Machete macheteStone,macheteIron,macheteGold,macheteDiamond,macheteBronze,macheteBrass,macheteWood,macheteSteel;
	public static Knife knife;
	public static FishingNet fishingNet;
	public static CottonCloth cottonCloth;
	
	
	public static void configureItems(){
		
		
		macheteStone=new Machete(ToolMaterial.STONE,"MacheteStone");
		GameRegistry.registerItem(macheteStone, Reference.MODID+"-"+macheteStone.getUnlocalizedName().substring(5));
		
		macheteIron=new Machete(ToolMaterial.IRON,"MacheteIron");
		GameRegistry.registerItem(macheteIron, Reference.MODID+"-"+macheteIron.getUnlocalizedName().substring(5));
		
		macheteGold=new Machete(ToolMaterial.GOLD, "MacheteGold");
		GameRegistry.registerItem(macheteGold,Reference.MODID+"-"+macheteGold.getUnlocalizedName().substring(5));
		
		macheteDiamond=new Machete(ToolMaterial.EMERALD, "MacheteDiamond");
		GameRegistry.registerItem(macheteDiamond, Reference.MODID+"-"+macheteDiamond.getUnlocalizedName().substring(5));
		
		macheteBronze=new Machete(Materials.MaterialBronze,"MacheteBronze");
		GameRegistry.registerItem(macheteBronze,Reference.MODID+"-"+macheteBronze.getUnlocalizedName().substring(5));
		
		macheteBrass=new Machete(Materials.MaterialBrass,"MacheteBrass");
		GameRegistry.registerItem(macheteBrass, Reference.MODID+"-"+macheteBrass.getUnlocalizedName().substring(5));
		
		macheteWood=new Machete(ToolMaterial.WOOD,"MacheteWood");
		GameRegistry.registerItem(macheteWood, Reference.MODID+"-"+macheteWood.getUnlocalizedName().substring(5));
		
		macheteSteel=new Machete(Materials.MaterialSteel, "MacheteSteel");
		GameRegistry.registerItem(macheteSteel, Reference.MODID+"-"+macheteSteel.getUnlocalizedName().substring(5));
		
		knife=new Knife();
		GameRegistry.registerItem(knife, Reference.MODID+"-"+knife.getUnlocalizedName().substring(5));
		knife.setContainerItem(knife);
		
		fishingNet=new FishingNet();
		GameRegistry.registerItem(fishingNet, Reference.MODID+"-"+fishingNet.getUnlocalizedName().substring(5));
		
		cottonCloth=new CottonCloth();
		GameRegistry.registerItem(cottonCloth, Reference.MODID+"-"+cottonCloth.getUnlocalizedName().substring(5));
		
	}
	
	public static void configureRecipes(){
		
		////Crafting Recipes////
		GameRegistry.addShapedRecipe(new ItemStack(macheteStone), new Object[]{"  d"," d ","s  ",'d',Item.getItemFromBlock(Blocks.cobblestone),'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteIron), new Object[]{"  d"," d ","s  ",'d',Items.iron_ingot,'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteGold), new Object[]{"  d"," d ","s  ",'d',Items.gold_ingot,'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteDiamond), new Object[]{"  d"," d ","s  ",'d',Items.diamond,'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteWood), new Object[]{"  d"," d ","s  ",'d',Item.getItemFromBlock(Blocks.planks),'s',Items.stick});
		//GameRegistry.addRecipe(new ItemStack(macheteBronze), new Object[]{"  d"," d ","s  ",'d',"ingotBronze",'s',Items.stick});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(macheteBronze), true, new Object[]{"  d"," d ","s  ",'d',"ingotBronze",'s',Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(macheteBrass), true, new Object[]{"  d"," d ","s  ",'d',"ingotBrass",'s',Items.stick}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(macheteSteel), true, new Object[]{"  d"," d ","s  ",'d',"ingotSteel",'s',Items.stick}));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(knife), true, new Object[]{" d "," s ","   ",'d',"ingotSteel",'s',Items.stick}));
		//GameRegistry.addRecipe(new ShaplessRecipeDamages(new ItemStack(Items.potato,1), new Object[]{FoodHandler.ananas,knife}));
		
		List l=new ArrayList();
		l.add(new ItemStack(FoodHandler.ananas));
		l.add(new ItemStack(knife));
		GameRegistry.addRecipe(new ShaplessRecipeDamages(new ItemStack(FoodHandler.pineappleSlice,6),l));
		
		GameRegistry.addShapedRecipe(new ItemStack(cottonCloth,1), new Object[]{"sss","sss","sss",'s',Items.string});
		GameRegistry.addShapedRecipe(new ItemStack(fishingNet), new Object[]{"scs","scs","scs",'s',Items.stick,'c',cottonCloth});
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Morphesuss93.MorpheussTechCore.items.ItemsHandler.smallAlcoholBurnerComponent), true, new Object[]{"scs","scs","sbs",'s',"ingotBronze",'b',Items.bucket,'c',cottonCloth}));
		
	}
}
