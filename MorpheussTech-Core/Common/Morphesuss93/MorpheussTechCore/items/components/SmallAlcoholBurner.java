package Morphesuss93.MorpheussTechCore.items.components;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class SmallAlcoholBurner extends Item{

	public SmallAlcoholBurner(){
		super();
		this.setUnlocalizedName("Small Alcohol Burner");
		this.setTextureName(Reference.MODID+":"+"SmallAlcoholBurner");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}
}
