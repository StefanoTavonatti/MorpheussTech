package Morpheuss93.MorpheussTechCrops.seed;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;

public class CottonSeed extends SeedBase{
	
	public CottonSeed() {
		super();
		thePlant=CropsHandler.cottonCrop;
		this.setUnlocalizedName("CottonSeed");
		this.setTextureName(Reference.MODID+":CottonSeed");
		this.setCreativeTab(MCrops.tabCrop);
	}

}
