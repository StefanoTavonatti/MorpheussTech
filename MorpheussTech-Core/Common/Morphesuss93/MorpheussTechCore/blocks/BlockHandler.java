package Morphesuss93.MorpheussTechCore.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.blocks.WorldGenerator.CopperWGenerator;
import Morphesuss93.MorpheussTechCore.blocks.ore.AluminiumOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.CopperOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.SilverOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.TinOre;
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
		
	}
	
	public static void configureWGen()
	{
		GameRegistry.registerWorldGenerator(new CopperWGenerator(),0);
	}
	
	public static void configureRecipes(){
		
		////////smelting/////////
		GameRegistry.addSmelting(copperOre, new ItemStack(ItemsHandler.copperIngot), 0.8F);
		GameRegistry.addSmelting(aluminiumOre, new ItemStack(ItemsHandler.aluminiumIngot), 0.8F);
		GameRegistry.addSmelting(silverOre, new ItemStack(ItemsHandler.silverIngot), 0.8F);
		GameRegistry.addSmelting(tinOre, new ItemStack(ItemsHandler.tinIngot), 0.8F);
	}
	
	public static void configureTile()
	{
		GameRegistry.registerTileEntity(TileEntityAlloyFurnace.class, Reference.MODID+"TileEntityAlloyFurnace");
	}

}
