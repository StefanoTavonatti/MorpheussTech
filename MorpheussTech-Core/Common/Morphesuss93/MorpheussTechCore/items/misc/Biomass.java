package Morphesuss93.MorpheussTechCore.items.misc;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class Biomass extends Item{
	
	public Biomass(){
		super();
		this.setUnlocalizedName("Biomass");
		this.setTextureName(Reference.MODID+":"+"Biomass");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}

}
