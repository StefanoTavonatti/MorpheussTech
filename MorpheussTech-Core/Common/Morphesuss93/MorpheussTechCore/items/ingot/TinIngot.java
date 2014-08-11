package Morphesuss93.MorpheussTechCore.items.ingot;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class TinIngot extends Item{
	
	public TinIngot()
	{
		super();
		this.setUnlocalizedName("Tin Ingot");
		this.setTextureName(Reference.MODID+":"+"TinIngot");
		this.setCreativeTab(Core.tabCore);
	}

}
