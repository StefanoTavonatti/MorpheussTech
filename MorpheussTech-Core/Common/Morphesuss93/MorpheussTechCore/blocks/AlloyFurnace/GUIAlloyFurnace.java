package Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace;

import org.lwjgl.opengl.GL11;

import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace.TileEntityAlcoholAlloyFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIAlloyFurnace extends GuiContainer{

	//private static final ResourceLocation furnaceGuiTexture =new ResourceLocation("textures/gui/container/furnace.png");
	private static final ResourceLocation furnaceGuiTexture =new ResourceLocation(Reference.MODID+":"+"textures/gui/container/Alloyfurnace.png");
	private TileEntityAlloyFurnace tileFurnace;
	
	public GUIAlloyFurnace(InventoryPlayer invPlayer,TileEntityAlloyFurnace tile) {
		super(new ContainerAlloyFurnace(invPlayer, tile));
		this.tileFurnace=tile;
	}

	protected void drawGuiContainerForegroundLayer(int par1,int par2){
		String string=this.tileFurnace.hasCustomInventoryName() ?this.tileFurnace.getInventoryName(): I18n.format(this.tileFurnace.getInventoryName(),new Object[0] );
		this.fontRendererObj.drawString(string, this.xSize/2 -this.fontRendererObj.getStringWidth(string), 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize-94, 4210752);
		//this.fontRendererObj.drawString("cur="+tileFurnace.currentBurnTime+" furnBurn="+tileFurnace.furnaceBurnTime+" coock="+tileFurnace.furnaceCookTime, this.xSize/2 -this.fontRendererObj.getStringWidth(string), 6, 4210752);
		/*if(this.tileFurnace instanceof TileEntityAlcoholAlloyFurnace){
			string="Alcohol "+((TileEntityAlcoholAlloyFurnace)tileFurnace).getTankAmount();
			this.fontRendererObj.drawString(string, this.xSize/2 -this.fontRendererObj.getStringWidth(string), 60, 4210752);
		}*/
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTexture);
		int k= (this.width - this.xSize)/2;
		int l= (this.height - this.ySize)/2;
		
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		int i1;
		
		if(this.tileFurnace.isBurning()){
			i1=this.tileFurnace.getBurnTimeRemaningScaled(12);
			//System.out.println(i1);
			//this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
			this.drawTexturedModalRect(k + 149, l + 42 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}
		
		i1=this.tileFurnace.getCookProgressScaled(24);//freccia
		this.drawTexturedModalRect(k+79, l+34, 176, 14, i1+1,16);
		
	}

}
