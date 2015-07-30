package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Morphesuss93.MorpheussTechCore.Core;
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
	
	@Override
	public boolean onBlockActivated(World world,int x,int y,int z,EntityPlayer player,int par6,float par7,float par8,float par9){
		player.openGui(Core.instance, 1, world, x, y, z);
		return true;
	}

}
