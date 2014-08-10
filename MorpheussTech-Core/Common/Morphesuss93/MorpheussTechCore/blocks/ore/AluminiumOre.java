package Morphesuss93.MorpheussTechCore.blocks.ore;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class AluminiumOre extends Block{

	public AluminiumOre() {
		super(Material.rock);
		this.setCreativeTab(Core.tabCore);
		this.setBlockName("Aluminium Ore");
		this.setBlockTextureName(Reference.MODID+":"+"AluminiumOre");
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 1);
	}

}
