package Morpheuss93.MorpheussTechCrops.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.items.tools.Machete;

public class ItemsHandler {

	public static Machete macheteStone,macheteIron,macheteGold,macheteDiamond;
	
	public static void configureItems(){
		
		macheteStone=new Machete(ToolMaterial.STONE,"MacheteStone");
		GameRegistry.registerItem(macheteStone, Reference.MODID+"-"+macheteStone.getUnlocalizedName().substring(5));
		
		macheteIron=new Machete(ToolMaterial.IRON,"MacheteIron");
		GameRegistry.registerItem(macheteIron, Reference.MODID+"-"+macheteIron.getUnlocalizedName().substring(5));
		
		macheteGold=new Machete(ToolMaterial.GOLD, "MacheteGold");
		GameRegistry.registerItem(macheteGold,Reference.MODID+"-"+macheteGold.getUnlocalizedName().substring(5));
		
		macheteDiamond=new Machete(ToolMaterial.EMERALD, "MacheteDiamond");
		GameRegistry.registerItem(macheteDiamond, Reference.MODID+"-"+macheteDiamond.getUnlocalizedName().substring(5));
	}
	
	public static void configureRecipes(){
		
		////Crafting Recipes////
		GameRegistry.addShapedRecipe(new ItemStack(macheteStone), new Object[]{"  d"," d ","s  ",'d',Item.getItemFromBlock(Blocks.cobblestone),'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteIron), new Object[]{"  d"," d ","s  ",'d',Items.iron_ingot,'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteGold), new Object[]{"  d"," d ","s  ",'d',Items.gold_ingot,'s',Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(macheteDiamond), new Object[]{"  d"," d ","s  ",'d',Items.diamond,'s',Items.stick});
		
	}
}
