package Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class AlloyFurnaceContainer extends Container{

	//private TileEntityAlloyFurnace inscriber;
	private int lastProgressTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		
		return false;
	}

}
