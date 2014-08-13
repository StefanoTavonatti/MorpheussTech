package Morphesuss93.MorpheussTechCore.handler;

import ibxm.Player;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.ContainerAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.GUIAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class MGuiHandler implements IGuiHandler{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			TileEntityAlloyFurnace tileEntityFurnace =(TileEntityAlloyFurnace) world.getTileEntity(x, y, z);
			return new GUIAlloyFurnace(player.inventory,tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			TileEntityAlloyFurnace tileEntityFurnace =(TileEntityAlloyFurnace) world.getTileEntity(x, y, z);
			return new ContainerAlloyFurnace(player.inventory,tileEntityFurnace);
		}
		return null;
	}

}
