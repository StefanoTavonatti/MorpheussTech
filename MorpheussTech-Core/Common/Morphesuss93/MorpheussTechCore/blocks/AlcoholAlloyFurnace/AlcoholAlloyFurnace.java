package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Morphesuss93.MorpheussTechCore.blocks.BlockHandler;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.AlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;

public class AlcoholAlloyFurnace extends AlloyFurnace{

	public AlcoholAlloyFurnace(boolean isActive) {
		super(isActive);
		
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int par2) {
		return new TileEntityAlcoholAlloyFurnace();
	}

}
