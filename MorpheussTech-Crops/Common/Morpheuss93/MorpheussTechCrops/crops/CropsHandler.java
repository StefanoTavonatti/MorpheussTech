package Morpheuss93.MorpheussTechCrops.crops;

import Morphesuss93.MorpheussTechCore.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class CropsHandler {
	
	public final static Block ananasPlant=new AnanasPlant();
	public final static Block cottonCrop=new CottonCrop();
	public final static Block cottonUp=new CottonUp();
	
	public static void configure(){
		GameRegistry.registerBlock(ananasPlant, Reference.MODID+"-"+"AnanasPlant");
		GameRegistry.registerBlock(cottonCrop, Reference.MODID+"-"+"CottonCrop");
		GameRegistry.registerBlock(cottonUp, Reference.MODID+"-"+"CottonUp");
	}

}
