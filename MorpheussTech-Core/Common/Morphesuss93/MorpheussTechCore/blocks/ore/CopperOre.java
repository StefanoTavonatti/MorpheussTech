package Morphesuss93.MorpheussTechCore.blocks.ore;

import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CopperOre extends Block{

	public CopperOre() {
		super(Material.rock);
		this.setCreativeTab(Core.tabCore);
		this.setBlockName("Copper Ore");
		this.setBlockTextureName(Reference.MODID+":"+"CopperOre");
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", 1);
	}
	
}
