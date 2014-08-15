package Morphesuss93.MorpheussTechCore.items.ingot.alloy;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class BrassIngot extends Item{
	
	public BrassIngot(){
		super();
		this.setUnlocalizedName("Brass Ingot");
		this.setTextureName(Reference.MODID+":"+"BrassIngot");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}

}
