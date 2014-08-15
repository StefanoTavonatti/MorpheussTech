package Morphesuss93.MorpheussTechCore.items.ingot;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class CopperIngot extends Item{
	
	public CopperIngot()
	{
		super();
		this.setUnlocalizedName("Copper Ingot");
		this.setTextureName(Reference.MODID+":"+"CopperIngot");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}

}
