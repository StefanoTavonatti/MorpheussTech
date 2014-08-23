package Morpheuss93.MorpheussTechCrops.seed;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;

public class AnanasSeed extends SeedBase{//seed find when a player broke the grass with a machete
	
	public AnanasSeed() {
		this.thePlant=CropsHandler.ananasPlant;
		this.setUnlocalizedName("AnanasSeed");
		this.setTextureName(Reference.MODID+":"+"AnanasSeed");
		this.setCreativeTab(MCrops.tabCrop);
	}

}
