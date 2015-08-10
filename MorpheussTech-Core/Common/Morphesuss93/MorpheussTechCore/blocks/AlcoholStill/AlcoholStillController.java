package Morphesuss93.MorpheussTechCore.blocks.AlcoholStill;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AlcoholStillController extends BlockContainer{
	
	boolean isActive;

	protected AlcoholStillController(boolean isActive) {
		super(Material.rock);
		this.isActive=isActive;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityAlcoholStillController(true);
	}

	public static void updateBlockState(boolean active, World worldObj, int xCoord,int yCoord, int zCoord) {
		// TODO Auto-generated method stub
		
	}

}
