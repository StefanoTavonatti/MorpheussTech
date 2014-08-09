package Morphesuss93.MorpheussTechCore;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import Morphesuss93.MorpheussTechCore.blocks.BlockHandler;
import Morphesuss93.MorpheussTechCore.items.ItemsHandler;

import com.example.examplemod.ExampleMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;


@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class Core {
	
	@Instance(Reference.MODID)
	public static Core instance;
    
	@SidedProxy(clientSide = "Morphesuss93.MorpheussTechCore.client.ClientProxy",serverSide="Morphesuss93.MorpheussTechCore.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config=new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		BlockHandler.configureBlock();
		ItemsHandler.configureItems();
		config.save();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.registerRenders();
        
    }

}
