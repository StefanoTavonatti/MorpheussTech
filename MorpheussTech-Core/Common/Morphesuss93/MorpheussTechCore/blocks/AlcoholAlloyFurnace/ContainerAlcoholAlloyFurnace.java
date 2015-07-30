package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.ContainerAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;

public class ContainerAlcoholAlloyFurnace extends ContainerAlloyFurnace{
	
	TileEntityAlcoholAlloyFurnace tileEntityAlcoholAlloyFurnace;
	int fluidAmount;

	public ContainerAlcoholAlloyFurnace(InventoryPlayer player, TileEntityAlcoholAlloyFurnace tileEntityFurnace) {
		super(player, tileEntityFurnace);
		tileEntityAlcoholAlloyFurnace=tileEntityFurnace;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 3, tileEntityAlcoholAlloyFurnace.getTankAmount());
	}

	@Override
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		
		for(int i=0;i<this.crafters.size();++i){
			ICrafting craft= (ICrafting)this.crafters.get(i);
			
			if(this.fluidAmount!=tileEntityAlcoholAlloyFurnace.getTankAmount()){
				System.out.println("fluidAm "+this.fluidAmount+" tile "+tileEntityAlcoholAlloyFurnace.getTankAmount()); 
				craft.sendProgressBarUpdate(this, 3, tileEntityAlcoholAlloyFurnace.getTankAmount());
			}
		}
		//System.out.println("Container "+tileEntityAlcoholAlloyFurnace.getTankAmount()); 
		this.fluidAmount=tileEntityAlcoholAlloyFurnace.getTankAmount();
	}
	
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int par1,int par2){
		System.out.println("quiiiiiiii222");
		super.updateProgressBar(par1, par2);
		if(par1==3){
			tileEntityAlcoholAlloyFurnace.setTankAmount(par2);
		}
	}

}
