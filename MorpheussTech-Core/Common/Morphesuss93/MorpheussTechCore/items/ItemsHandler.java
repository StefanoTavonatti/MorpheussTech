package Morphesuss93.MorpheussTechCore.items;

import cpw.mods.fml.common.registry.GameRegistry;
import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.items.ingot.*;
import Morphesuss93.MorpheussTechCore.items.ingot.alloy.BrassIngot;
import Morphesuss93.MorpheussTechCore.items.ingot.alloy.BronzeIngot;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class ItemsHandler {
	
	public static CopperIngot copperIngot;
	public static AluminiumIngot aluminiumIngot;
	public static SilverIngot silverIngot;
	public static TinIngot tinIngot;
	public static BronzeIngot bronzeIngot;
	public static BrassIngot brassIngot;
	public static SteelIngot steelIngot;
	
	
	public static void configureItems(Configuration config){
		copperIngot=new CopperIngot();
		GameRegistry.registerItem(copperIngot, Reference.MODID+"-"+copperIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotCopper", copperIngot);
		
		aluminiumIngot=new AluminiumIngot();
		GameRegistry.registerItem(aluminiumIngot, Reference.MODID+"-"+aluminiumIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotAluminium", aluminiumIngot);
		
		silverIngot=new SilverIngot();
		GameRegistry.registerItem(silverIngot, Reference.MODID+"-"+silverIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotSilver", silverIngot);
		
		tinIngot=new TinIngot();
		GameRegistry.registerItem(tinIngot, Reference.MODID+"-"+tinIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotTin", tinIngot);
		
		bronzeIngot=new BronzeIngot();
		GameRegistry.registerItem(bronzeIngot, Reference.MODID+"-"+bronzeIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		
		brassIngot=new BrassIngot();
		GameRegistry.registerItem(brassIngot, Reference.MODID+"-"+brassIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotBrass", brassIngot);
				
		steelIngot=new SteelIngot();
		GameRegistry.registerItem(steelIngot, Reference.MODID+"-"+steelIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotSteel", steelIngot);
		
		
	}

}
