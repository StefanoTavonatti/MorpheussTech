package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.ContainerAlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;

public class ContainerAlcoholAlloyFurnace extends ContainerAlloyFurnace{
	
	TileEntityAlcoholAlloyFurnace tileEntityAlcoholAlloyFurnace;
	int fluidAmount;
	

	public ContainerAlcoholAlloyFurnace(InventoryPlayer player, TileEntityAlcoholAlloyFurnace tileEntityFurnace) {
		super(tileEntityFurnace);
		//tileEntityFurnace=tileEntityAlcoholAlloyFurnace;
		tileEntityAlcoholAlloyFurnace=tileEntityFurnace;
		this.addSlotToContainer(new Slot(tileEntityFurnace,9,147,63));//combustibile prima 1 148 65
		this.addSlotToContainer(new SlotFurnace(player.player,tileEntityFurnace,10,116,35));//risultato
		int i;
		
		for(int n=0;n<3;n++)
		{
			for(int m=0;m<3;m++)
			{
				this.addSlotToContainer(new Slot(tileEntityFurnace,m+n*3,22+18*(m),18+17*n));
			}
		}
		
		for(i=0;i<3;++i){
			for(int j=0;j<9;++j){
				this.addSlotToContainer(new Slot(player,j+i*9+9,8+j*18,84+i*18));
			}
		}
		
		for(i=0;i<9;++i){
			this.addSlotToContainer(new Slot(player,i, 8+i*18,142));
		}
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
