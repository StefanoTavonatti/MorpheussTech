package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
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
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister){
		this.blockIcon=iconregister.registerIcon(Reference.MODID+":AlcoholAlloyFurnaceSide");
		this.front=iconregister.registerIcon(this.isBurning2 ? Reference.MODID+":AlcoholAlloyFurnaceActive" : Reference.MODID+":AlcoholAlloyFurnace");
		this.top=iconregister.registerIcon(Reference.MODID+":AlloyFurnaceTop");
	}
	
	public static void updateBlockStateAlcoholAlloyFurnace(boolean burning,World world,int x,int y,int z){
		int direction =world.getBlockMetadata(x, y, z);
		TileEntity tileentity=world.getTileEntity(x, y, z);
		isBurning=true;
		
		if(burning){
			world.setBlock(x, y, z, BlockHandler.alcoholAlloyFurnaceActive);
		}else{
			world.setBlock(x, y, z, BlockHandler.alcoholAlloyFurnace);
		}
		
		isBurning=false;
		
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
		if(tileentity !=null){
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity); 
		}
	}

}
