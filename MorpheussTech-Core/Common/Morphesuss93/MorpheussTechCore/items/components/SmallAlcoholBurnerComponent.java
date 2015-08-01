package Morphesuss93.MorpheussTechCore.items.components;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class SmallAlcoholBurnerComponent extends Item{

	public SmallAlcoholBurnerComponent(){
		super();
		this.setUnlocalizedName("Small Alcohol Burner Component");
		this.setTextureName(Reference.MODID+":"+"SmallAlcoholBurnerComponent");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}
}
