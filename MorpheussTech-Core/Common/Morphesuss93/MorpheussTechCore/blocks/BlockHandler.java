package Morphesuss93.MorpheussTechCore.blocks;

import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.blocks.ore.AluminiumOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.CopperOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.SilverOre;
import Morphesuss93.MorpheussTechCore.blocks.ore.TinOre;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

public class BlockHandler {
	
	public static CopperOre copperOre;
	public static TinOre tinOre;
	public static SilverOre silverOre;
	public static AluminiumOre aluminiumOre;
	
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
		
	}

}
