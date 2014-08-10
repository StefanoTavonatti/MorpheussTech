package Morphesuss93.MorpheussTechCore.blocks.ore;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TinOre extends Block{

	public TinOre() {
		super(Material.rock);
		this.setCreativeTab(Core.tabCore);
		this.setBlockName("Tin Ore");
		this.setBlockTextureName(Reference.MODID+":"+"TinOre");
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 1);
	}

}
