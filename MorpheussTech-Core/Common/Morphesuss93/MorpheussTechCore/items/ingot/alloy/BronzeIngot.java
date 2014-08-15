package Morphesuss93.MorpheussTechCore.items.ingot.alloy;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class BronzeIngot extends Item{

	public BronzeIngot(){
		super();
		this.setUnlocalizedName("Bronze Ingot");
		this.setTextureName(Reference.MODID+":"+"BronzeIngot");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}
}
