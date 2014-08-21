package Morpheuss93.MorpheussTechCrops.crops;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class CropsHandler {
	
	public final static Block ananasPlant=new AnanasPlant();
	
	public static void configure(){
		GameRegistry.registerBlock(ananasPlant, "AnanasPlant");
	}

}
