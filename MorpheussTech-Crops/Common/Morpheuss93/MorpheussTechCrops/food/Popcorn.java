package Morpheuss93.MorpheussTechCrops.food;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.item.ItemFood;

public class Popcorn extends ItemFood{

	public Popcorn() {
		super(2,1.0F,false);
		this.setUnlocalizedName("Popcorn");
		this.setTextureName(Reference.MODID+":Popcorn");
		this.setCreativeTab(MCrops.tabCrop);
		this.setMaxStackSize(64);
	}

}
