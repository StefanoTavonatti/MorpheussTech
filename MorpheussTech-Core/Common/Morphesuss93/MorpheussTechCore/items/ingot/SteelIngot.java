package Morphesuss93.MorpheussTechCore.items.ingot;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class SteelIngot extends Item{

	public SteelIngot() {
		
		super();
		this.setUnlocalizedName("Steel Ingot");
		this.setTextureName(Reference.MODID+":"+"SteelIngot");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}
}
