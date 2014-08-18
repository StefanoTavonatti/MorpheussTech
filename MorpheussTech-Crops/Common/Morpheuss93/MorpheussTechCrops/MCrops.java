package Morpheuss93.MorpheussTechCrops;


import Morpheuss93.MorpheussTechCrops.items.ItemsHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.SidedProxy;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class MCrops {
	
	@Instance(Reference.MODID)
	public static MCrops instance;
	
	@SidedProxy(clientSide="Morpheuss93.MorpheussTechCrops.client.ClientProxy",serverSide="Morpheuss93.MorpheussTechCrops.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabCrop =new CreativeTabs("MorpheussTech-Crops") {
		
		@Override
		public Item getTabIconItem() {
			return Items.potato;
		}
	};
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		
		ItemsHandler.configureItems();
		ItemsHandler.configureRecipes();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
	}

}
