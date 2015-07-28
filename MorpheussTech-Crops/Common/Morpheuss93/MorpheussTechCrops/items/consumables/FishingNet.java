package Morpheuss93.MorpheussTechCrops.items.consumables;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.item.Item;

public class FishingNet extends Item{
	
	public FishingNet(){
		super();
		this.setUnlocalizedName("FishingNet");
		this.setTextureName(Reference.MODID+":"+"FishingNet");
		this.setMaxDamage(64);
		this.setMaxStackSize(1);
		this.setCreativeTab(MCrops.tabCrop);
	}

}
