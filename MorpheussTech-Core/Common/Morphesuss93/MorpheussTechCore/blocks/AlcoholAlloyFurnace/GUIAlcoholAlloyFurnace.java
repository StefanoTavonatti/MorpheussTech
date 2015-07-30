package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import net.minecraft.entity.player.InventoryPlayer;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.GUIAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;

public class GUIAlcoholAlloyFurnace extends GUIAlloyFurnace{

	private TileEntityAlcoholAlloyFurnace tileEntityAlcoholAlloyFurnace;
	
	public GUIAlcoholAlloyFurnace(InventoryPlayer invPlayer,
			TileEntityAlcoholAlloyFurnace tile) {
		super(invPlayer, tile);
		tileEntityAlcoholAlloyFurnace=tile;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int par1,int par2){
		super.drawGuiContainerForegroundLayer(par1, par2);
		if(this.tileEntityAlcoholAlloyFurnace instanceof TileEntityAlcoholAlloyFurnace){
			String string="Alcohol "+((TileEntityAlcoholAlloyFurnace)tileEntityAlcoholAlloyFurnace).getTankAmount();
			System.out.println("string "+string);
			this.fontRendererObj.drawString(string, this.xSize/2 -this.fontRendererObj.getStringWidth(string), 60, 4210752);
		}
	}

}
