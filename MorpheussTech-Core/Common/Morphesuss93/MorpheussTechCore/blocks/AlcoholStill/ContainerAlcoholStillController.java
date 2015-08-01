package Morphesuss93.MorpheussTechCore.blocks.AlcoholStill;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerAlcoholStillController extends Container{

	private TileEntityAlcoholStillController tileEntity;
	
	public ContainerAlcoholStillController(InventoryPlayer invPlayer,TileEntityAlcoholStillController tile) {
		this.tileEntity=tile;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.tileEntity.isUseableByPlayer(player);
	}

}
