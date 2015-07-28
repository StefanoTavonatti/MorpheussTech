package Morpheuss93.MorpheussTechCrops.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.ContainerAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.GUIAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.ContainerFishTrap;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.GUIFishTrap;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.TileEntityFishTrap;

public class MGuiHandler implements IGuiHandler{

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			TileEntityFishTrap tileEntityFurnace =(TileEntityFishTrap) world.getTileEntity(x, y, z);
			return new GUIFishTrap(player.inventory,tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		if(ID==0){
			TileEntityFishTrap tileEntityFurnace =(TileEntityFishTrap) world.getTileEntity(x, y, z);
			return new ContainerFishTrap(player.inventory,tileEntityFurnace);
		}
		return null;
	}
}
