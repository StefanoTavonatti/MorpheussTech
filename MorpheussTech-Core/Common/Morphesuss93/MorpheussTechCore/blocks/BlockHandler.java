package Morphesuss93.MorpheussTechCore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.blocks.WorldGenerator.AluminiumWGenerator;
import Morphesuss93.MorpheussTechCore.blocks.WorldGenerator.CopperWGenerator;
import Morphesuss93.MorpheussTechCore.blocks.WorldGenerator.SilverWGenerator;
import Morphesuss93.MorpheussTechCore.blocks.WorldGenerator.TinWGenerator;
import Morphesuss93.MorpheussTechCore.blocks.ore.AluminiumOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.CopperOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.SilverOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.TinOre;
import Morphesuss93.MorpheussTechCore.fluids.AlcoholBlock;
import Morphesuss93.MorpheussTechCore.items.ItemsHandler;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHandler {
	
	public static CopperOre copperOre;
	public static TinOre tinOre;
	public static SilverOre silverOre;
	public static AluminiumOre aluminiumOre;
	public static Block AlloyFurnace;
	public static Block AlloyFurnaceActive;
	public static Fluid alcohol = new Fluid("Alcohol");
	public static AlcoholBlock alcoholBlock;
	
	public static void configureBlock(Configuration config)
	{
		copperOre= new CopperOre();
		GameRegistry.registerBlock(copperOre, Reference.MODID+"-"+copperOre.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("oreCopper", copperOre);
		
		tinOre=new TinOre();
		GameRegistry.registerBlock(tinOre, Reference.MODID+"-"+tinOre.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("oreTin", tinOre);
		
		silverOre=new SilverOre();
		GameRegistry.registerBlock(silverOre, Reference.MODID+"-"+silverOre.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("oreSilver", silverOre);
		
		aluminiumOre=new AluminiumOre();
		GameRegistry.registerBlock(aluminiumOre, Reference.MODID+"-"+aluminiumOre.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("oreAluminium", aluminiumOre);
		
		
		
		
		AlloyFurnace=new AlloyFurnace(false).setBlockName("AlloyFurnace");
		AlloyFurnaceActive=new AlloyFurnace(true).setBlockName("AlloyFurnaceActive");
		GameRegistry.registerBlock(AlloyFurnace, Reference.MODID+"-"+AlloyFurnace.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(AlloyFurnaceActive, Reference.MODID+"-"+AlloyFurnaceActive.getUnlocalizedName().substring(5));
	
		
		
		FluidRegistry.registerFluid(alcohol);
		alcoholBlock = new AlcoholBlock(alcohol, Material.water);
		alcoholBlock.setBlockName("Alcohol");
		GameRegistry.registerBlock(alcoholBlock, Reference.MODID + "_" + alcoholBlock.getUnlocalizedName().substring(5));
		alcohol.setUnlocalizedName(alcoholBlock.getUnlocalizedName());
		
		
		
		
	}
	
	public static void configureWGen()
	{
		GameRegistry.registerWorldGenerator(new CopperWGenerator(),0);
		GameRegistry.registerWorldGenerator(new AluminiumWGenerator(), 0);
		GameRegistry.registerWorldGenerator(new SilverWGenerator(), 0);
		GameRegistry.registerWorldGenerator(new TinWGenerator(), 0);
	}
	
	public static void configureRecipes(){
		
		////////smelting/////////
		GameRegistry.addSmelting(copperOre, new ItemStack(ItemsHandler.copperIngot), 0.8F);
		GameRegistry.addSmelting(aluminiumOre, new ItemStack(ItemsHandler.aluminiumIngot), 0.8F);
		GameRegistry.addSmelting(silverOre, new ItemStack(ItemsHandler.silverIngot), 0.8F);
		GameRegistry.addSmelting(tinOre, new ItemStack(ItemsHandler.tinIngot), 0.8F);
		
		
		////crafting////
		GameRegistry.addShapedRecipe(new ItemStack(AlloyFurnace,1), new Object[]{"BFB","B B","BFB",'B',Blocks.brick_block,'F',Blocks.furnace});
	}
	
	public static void configureTile()
	{
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, Reference.MODID+"TileEntityAlloyFurnace");
	}

}
