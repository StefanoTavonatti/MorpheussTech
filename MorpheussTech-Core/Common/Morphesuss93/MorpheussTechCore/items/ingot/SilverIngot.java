package Morphesuss93.MorpheussTechCore.items.ingot;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class SilverIngot extends Item{
	
	public SilverIngot()
	{
		super();
		this.setUnlocalizedName("Silver Ingot");
		this.setTextureName(Reference.MODID+":"+"SilverIngot");
		this.setCreativeTab(Core.tabCore);
	}

}
