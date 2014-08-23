package Morpheuss93.MorpheussTechCrops.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import Morphesuss93.MorpheussTechCore.Materials;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.food.FoodHandler;
import Morpheuss93.MorpheussTechCrops.items.tools.Knife;
import Morpheuss93.MorpheussTechCrops.items.tools.Machete;

public class ItemsHandler {

	public static Machete macheteStone,macheteIron,macheteGold,macheteDiamond,macheteBronze,macheteBrass,macheteWood,macheteSteel;
	public static Knife knife;
	
	
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
		
		GameRegistry.addRecipe(new ItemStack(Items.potato,1),new Object[]{" A "," K ","   ",'A',FoodHandler.ananas,'K',knife});
	}
}
