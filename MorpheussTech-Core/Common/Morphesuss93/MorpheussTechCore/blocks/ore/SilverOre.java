package Morphesuss93.MorpheussTechCore.blocks.ore;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SilverOre extends Block{

	public SilverOre() {
		super(Material.rock);
		this.setCreativeTab(Core.tabCore);
		this.setBlockName("Silver Ore");
		this.setBlockTextureName(Reference.MODID+":"+"SilverOre");
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
	}

}
