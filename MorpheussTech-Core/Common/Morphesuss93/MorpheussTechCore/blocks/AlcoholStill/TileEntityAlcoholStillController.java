package Morphesuss93.MorpheussTechCore.blocks.AlcoholStill;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.AlloyFurnace;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.AlloyFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityAlcoholStillController extends TileEntity implements ISidedInventory,IFluidHandler{

	private static final int[] slotsTop=new int[]{0};
	private static final int[] slotsBottom=new int[]{0};
	private static final int[] slotsSides=new int[]{0};
	
	public int furnaceBurnTime;
	public int currentBurnTime;//per quanto brucia il carburante
	
	public int furnaceCookTime;
	
	public boolean multiblock;
	protected ItemStack stillItemStacks[]=new ItemStack[4];//3 fuel
	protected FluidTank watherTank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME*2);
	protected FluidTank lavaTank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME*2); 
	protected FluidTank resultTank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME*2);
	
	private static int lavaCost=20;
	 
	private String stillName;
	
	public TileEntityAlcoholStillController(boolean multiblock) {
		this.multiblock=multiblock;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ?false :player.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord +0.5D, (double) this.zCoord+0.5D) <= 64.0D;
	}

	@Override
	public int getSizeInventory() {
		return this.stillItemStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.stillItemStacks[slot];
	}

	@Override
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.stillItemStacks[par1] != null) {
			ItemStack itemstack;
			if (this.stillItemStacks[par1].stackSize <= par2) {
				itemstack = this.stillItemStacks[par1];
				this.stillItemStacks[par1] = null;
				return itemstack;
			} else {
				itemstack = this.stillItemStacks[par1].splitStack(par2);

				if (this.stillItemStacks[par1].stackSize == 0) {
					this.stillItemStacks[par1] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if(this.stillItemStacks[slot]!=null){
			ItemStack itemstack=this.stillItemStacks[slot];
			this.stillItemStacks[slot]=null;
			return itemstack;
		}
		else{
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.stillItemStacks[slot]=itemstack;
		
		if(itemstack!=null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize=this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.stillName:"Small Still";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.stillName!=null && this.stillName.length()>0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
		// TODO INSERIMENTO automatico mulch
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
			int p_102007_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
			int p_102008_3_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		
		int result=0;
		boolean flag=false;
		
		if(resource.getFluid()==FluidRegistry.WATER){
			result=watherTank.fill(resource, doFill);
			flag=true;
		}else if(resource.getFluid()==FluidRegistry.LAVA){
			result=lavaTank.fill(resource, doFill);
			flag=true;
		}
		
		if(flag){
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
			this.markDirty();
		}
		
		return result;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(resultTank.getFluid()))
        {
            return null;
        }
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		this.markDirty();
        return resultTank.drain(resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		FluidStack res=resultTank.drain(maxDrain, doDrain);
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		this.markDirty();
		return res;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if(fluid==FluidRegistry.WATER || fluid==FluidRegistry.LAVA)
			return true;
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if(fluid==resultTank.getFluid().getFluid())
			return true;
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { resultTank.getInfo() };
		//TODO ricontrollare
	}
	
	@Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, tag);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        readFromNBT(pkt.func_148857_g());
    }
    
    public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		NBTTagList tagList=tagCompound.getTagList("Items", 10);
		this.stillItemStacks=new ItemStack[this.getSizeInventory()];
		
		for(int i=0;i<tagList.tagCount();++i){
			NBTTagCompound tagCompound1=tagList.getCompoundTagAt(i);
			byte byte0=tagCompound1.getByte("Slot");
			
			if(byte0 >= 0 && byte0 <this.stillItemStacks.length ){
				this.stillItemStacks[byte0]=ItemStack.loadItemStackFromNBT(tagCompound1);
			}
		}
		
		this.furnaceBurnTime=tagCompound.getShort("BurnTime");
		this.furnaceCookTime=tagCompound.getShort("CookTime");
		//this.currentBurnTime=getItemBurnTime(this.furnaceItemStacks[1]);
		this.currentBurnTime=tagCompound.getShort("currentBurnTime");//camb
		if(tagCompound.hasKey("CustomName",8)){
			this.stillName=tagCompound.getString("CustomName");
		}
		
		watherTank.readFromNBT(tagCompound);
		lavaTank.readFromNBT(tagCompound);
		resultTank.readFromNBT(tagCompound);
	}
    
    public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		tagCompound.setShort("BurnTime",(short)this.furnaceBurnTime);
		tagCompound.setShort("CookTime",(short)this.furnaceCookTime);
		tagCompound.setShort("currentBurnTime",(short)this.currentBurnTime);//camb
		
		NBTTagList tagList=new NBTTagList();
		
		for(int i=0;i<this.stillItemStacks.length;++i){
			if(this.stillItemStacks[i]!=null){
				NBTTagCompound tagCompound1=new NBTTagCompound();
				tagCompound1.setByte("Slot",(byte) i);
				this.stillItemStacks[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}
		
		tagCompound.setTag("Items", tagList);
		
		if(this.hasCustomInventoryName()){
			tagCompound.setString("CustomName",this.stillName);
		}
		
		watherTank.writeToNBT(tagCompound);
		lavaTank.writeToNBT(tagCompound);
		resultTank.writeToNBT(tagCompound);
	}
    
	public boolean isBurning(){
		return this.furnaceBurnTime>0;
	}
    
    
    public void updateEntity(){
		boolean flag=this.furnaceBurnTime>0;
		boolean flag1=false;
		
		if(this.furnaceBurnTime>0){
			--this.furnaceBurnTime;
		}
		
		if(!this.worldObj.isRemote){
			if(this.furnaceBurnTime==0 && this.canSmelt()){
				if(watherTank.getFluidAmount()>=200 && lavaTank.getFluidAmount()>=lavaCost){
					int time=200;
					if(multiblock){
						time=50;
					}else{
						time=200;
					}
					
					this.currentBurnTime=this.furnaceBurnTime=time;
				}
				
				if(this.furnaceBurnTime>0){
					flag1=true;
					if(this.stillItemStacks[9]!=null){
						--this.stillItemStacks[9].stackSize;
					}
					
					if(this.stillItemStacks[9].stackSize==0){
						this.stillItemStacks[9]=stillItemStacks[9].getItem().getContainerItem(this.stillItemStacks[9]);
					}
				}
			}
			
			if(this.isBurning() && this.canSmelt()){
				++this.furnaceCookTime;
				if(this.furnaceCookTime==200){
					this.furnaceCookTime=0;
					this.smeltItem();
					flag1=true;
				}
			}else{
				this.furnaceCookTime=0;
			}
		}
		
		if(flag !=this.furnaceBurnTime>0){
			flag1=true;
			AlloyFurnace.updateBlockState(this.furnaceBurnTime>0, this.worldObj, this.xCoord,this.yCoord , this.zCoord);
		}
		
		if(flag1){
			this.markDirty();
		}
	}
    
    protected boolean canSmelt(){
    	if(!(watherTank.getFluidAmount()>=1000))
    		return false;
    	if(multiblock && lavaTank.getFluidAmount()<lavaCost)
    		return false;
    	//if(!multiblock && !(lavaTank.getFluidAmount()<lavaCost || stillItemStacks[3].getItem()!=null )) //TODO controllare elementi//TODO using ItemBurnTime and is Itemfuel
    	
    	return true;
    }
    
	public void smeltItem(){
			
			ArrayList temp=new ArrayList();
			boolean vuoto=true;
			for(int i=0;i<9;i++){
				if(stillItemStacks[i]!=null)
				{
					vuoto=false;
					temp.add(stillItemStacks[i]);
				}
			}
			
			if(this.canSmelt()){
				ItemStack itemstack=AlloyFurnaceRecipes.SMELTING_BASE.getSmeltingResult(temp);
				
				if(this.stillItemStacks[10]==null){
					this.stillItemStacks[10]=itemstack.copy();
				}else if(this.stillItemStacks[10].getItem()==itemstack.getItem()){
					this.stillItemStacks[10].stackSize+=itemstack.stackSize;
				}
				
				for(int i=0;i<9;i++){
					if(this.stillItemStacks[i]!=null)
					{
						--this.stillItemStacks[i].stackSize;
						
						if(this.stillItemStacks[i].stackSize <= 0){
							this.stillItemStacks[i] = null;
						}
					}
				}
				
			}
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack==null){
			return 0;
		}else{
			Item item=itemstack.getItem();//se non va l'altro import
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) !=Blocks.air){
				Block block=Block.getBlockFromItem(item);
				/*
				if(block== BlockHandler.copperOre){ //da cambiare, solo per test
					return 200;
				}*/
				
				if(block.getMaterial() == Material.wood){
					return 300;
				}
			}
				
			/*if(item == ItemsHandler.copperIngot) return 1600;
			if(item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().endsWith("EMERALD")) return 300;*/
			if(item==Items.stick) return 100;
			if(item==Items.coal) return 1600;
			return GameRegistry.getFuelValue(itemstack);
			
		}
	}
	
	public boolean isItemFuel(Item item){
		return true;//TODO sistemare
	}
	
	public int getItemBurnTime(Item item){
		return 0;
	}
    
}
