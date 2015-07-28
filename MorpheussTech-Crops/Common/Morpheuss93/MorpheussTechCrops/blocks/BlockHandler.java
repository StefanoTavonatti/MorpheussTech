package Morpheuss93.MorpheussTechCrops.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.FishTrap;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.TileEntityFishTrap;

public class BlockHandler {
	
	public static FishTrap fishTrap;
	
	public static void configureBlocks(){
		fishTrap=(FishTrap) new FishTrap(false).setBlockName("Fish Trap");
		GameRegistry.registerBlock(fishTrap, fishTrap.getUnlocalizedName().substring(5));
	}
	
	public static void configureTile(){
		GameRegistry.registerTileEntity(TileEntityFishTrap.class, Reference.MODID+"TileEntityFishTrap");
	}

}
