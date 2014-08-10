package Morphesuss93.MorpheussTechCore.items.ingot;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.item.Item;

public class AluminiumIngot extends Item{

	public AluminiumIngot()
	{
		super();
		this.setUnlocalizedName("Aluminium Ingot");
		this.setTextureName(Reference.MODID+":"+"AluminiumIngot");
		this.setCreativeTab(Core.tabCore);
	}
}
