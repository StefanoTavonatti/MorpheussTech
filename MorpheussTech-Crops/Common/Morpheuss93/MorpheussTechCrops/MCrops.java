package Morpheuss93.MorpheussTechCrops;

import java.util.ArrayList;

import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.AlloyFurnaceRecipes;
import Morpheuss93.MorpheussTechCrops.blocks.BlockHandler;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;
import Morpheuss93.MorpheussTechCrops.food.FoodHandler;
import Morpheuss93.MorpheussTechCrops.handler.MGuiHandler;
import Morpheuss93.MorpheussTechCrops.items.ItemsHandler;
import Morpheuss93.MorpheussTechCrops.seed.SeedHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Reference.MODID, version = Reference.VERSION,dependencies = "required-after:MorpheussTech-Core")
public class MCrops {
	
	@Instance(Reference.MODID)
	public static MCrops instance;
	
	@SidedProxy(clientSide="Morpheuss93.MorpheussTechCrops.client.ClientProxy",serverSide="Morpheuss93.MorpheussTechCrops.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabCrop =new CreativeTabs("MorpheussTech-Crops") {
		
		@Override
		public Item getTabIconItem() {
			return FoodHandler.ananas;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		
		ItemsHandler.configureItems();
		ItemsHandler.configureRecipes();
		CropsHandler.configure();
		FoodHandler.configure();
		SeedHandler.configure();
		BlockHandler.configureBlocks();
		BlockHandler.configureRecipes();
		BlockHandler.configureTile();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.registerRenders();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new MGuiHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
