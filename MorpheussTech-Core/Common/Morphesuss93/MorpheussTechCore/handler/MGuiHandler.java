package Morphesuss93.MorpheussTechCore.handler;

import ibxm.Player;
import Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace.ContainerAlcoholAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace.GUIAlcoholAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace.TileEntityAlcoholAlloyFurnace;
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
		
		if(ID==1){
			TileEntityAlcoholAlloyFurnace tileEntityAlcoholAlloyFurnace=(TileEntityAlcoholAlloyFurnace) world.getTileEntity(x, y, z);
			return new GUIAlcoholAlloyFurnace(player.inventory, tileEntityAlcoholAlloyFurnace);
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
		
		if(ID==1){
			TileEntityAlcoholAlloyFurnace tileEntityAlcoholAlloyFurnace=(TileEntityAlcoholAlloyFurnace) world.getTileEntity(x,y, z);
			return new ContainerAlcoholAlloyFurnace(player.inventory, tileEntityAlcoholAlloyFurnace);
		}
		return null;
	}

}
