package Morpheuss93.MorpheussTechCrops.seed;

import Morpheuss93.MorpheussTechCrops.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

public class SeedHandler {

	public static AnanasSeed ananasSeed;
	public static CottonSeed cottonSeed;
	
	public static void configure(){
		ananasSeed=new AnanasSeed();
		GameRegistry.registerItem(ananasSeed, Reference.MODID+"-"+ananasSeed.getUnlocalizedName().substring(5)); 
		
		cottonSeed=new CottonSeed();
		GameRegistry.registerItem(cottonSeed, Reference.MODID+"-"+cottonSeed.getUnlocalizedName().substring(5));
	}
}
