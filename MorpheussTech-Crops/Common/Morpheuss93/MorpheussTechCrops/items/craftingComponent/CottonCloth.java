package Morpheuss93.MorpheussTechCrops.items.craftingComponent;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.item.Item;

public class CottonCloth extends Item{
	
	public CottonCloth(){
		super();
		this.setUnlocalizedName("CottonCloth");
		this.setTextureName(Reference.MODID+":"+"CottonCloth");
		this.setMaxStackSize(64);
		this.setCreativeTab(MCrops.tabCrop);
	}
}
