package Morpheuss93.MorpheussTechCrops.food;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;

public class Corncob extends RottableFood{

	public Corncob() {
		super(2, 2.0F, false);
		this.setUnlocalizedName("Corncob");
		this.setTextureName(Reference.MODID+":Corncob");
		this.setCreativeTab(MCrops.tabCrop);
		this.setMaxStackSize(64);
	}

}
