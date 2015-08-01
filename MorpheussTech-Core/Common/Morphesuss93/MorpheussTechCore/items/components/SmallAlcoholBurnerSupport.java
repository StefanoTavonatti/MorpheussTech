package Morphesuss93.MorpheussTechCore.items.components;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class SmallAlcoholBurnerSupport extends Item{
	
	public SmallAlcoholBurnerSupport(){
		super();
		this.setUnlocalizedName("Small Alcohol Burner Support");
		this.setTextureName(Reference.MODID+":"+"SmallAlcoholBurnerSupport");
		this.setCreativeTab(Core.tabCore);
		this.setMaxStackSize(64);
	}

}
