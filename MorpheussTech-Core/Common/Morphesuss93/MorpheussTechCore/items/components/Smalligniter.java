package Morphesuss93.MorpheussTechCore.items.components;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class Smalligniter extends Item{

	public Smalligniter(){
		super();
		this.setUnlocalizedName("Small Igniter");
		this.setTextureName(Reference.MODID+":"+"SmallIgniter");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}
}
