package Morphesuss93.MorpheussTechCore.blocks.AlcoholStill;

import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.ContainerAlloyFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GUIAlcoholStill extends GuiContainer{

	public GUIAlcoholStill(InventoryPlayer invPlayer,TileEntityAlcoholStillController tile) {
		super(new ContainerAlcoholStillController(invPlayer, tile));
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
