package Morphesuss93.MorpheussTechCore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import Morphesuss93.MorpheussTechCore.blocks.BlockHandler;
import Morphesuss93.MorpheussTechCore.handler.MGuiHandler;
import Morphesuss93.MorpheussTechCore.items.ItemsHandler;

//import com.example.examplemod.ExampleMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Core {
	
	@Instance(Reference.MODID)
	public static Core instance;
    
	@SidedProxy(clientSide = "Morphesuss93.MorpheussTechCore.client.ClientProxy",serverSide="Morphesuss93.MorpheussTechCore.CommonProxy")
	public static CommonProxy proxy;
	
	 public static CreativeTabs tabCore= new CreativeTabs("MorpheussTech-Core") {
			@Override
			public Item getTabIconItem() {
				return Items.redstone;
			}
			
	    };
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config=new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockHandler.configureBlock(config);
		ItemsHandler.configureItems(config);
		BlockHandler.configureWGen();
		BlockHandler.configureRecipes();
		BlockHandler.configureTile();
		config.save();
		
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerRenders();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new MGuiHandler());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }
   
   
}
