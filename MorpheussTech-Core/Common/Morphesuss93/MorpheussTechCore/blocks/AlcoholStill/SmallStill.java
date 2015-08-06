package Morphesuss93.MorpheussTechCore.blocks.AlcoholStill;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SmallStill extends BlockContainer{

	protected SmallStill() {
		super(Material.rock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityAlcoholStillController(false);
	}

}
