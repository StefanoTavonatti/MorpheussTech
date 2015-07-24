package Morpheuss93.MorpheussTechCrops.seed;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class Corn extends BaseItemSeedFood{

	public Corn() {
		super(1, 0.5F, CropsHandler.cornCrop, Blocks.farmland);
		this.setUnlocalizedName("Corn");
		this.setTextureName(Reference.MODID+":Corn");
		this.setCreativeTab(MCrops.tabCrop);
	}

}
