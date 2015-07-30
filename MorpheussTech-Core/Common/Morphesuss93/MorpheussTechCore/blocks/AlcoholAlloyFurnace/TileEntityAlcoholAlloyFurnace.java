package Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import Morphesuss93.MorpheussTechCore.blocks.AlloyFurnace.TileEntityAlloyFurnace;

public class TileEntityAlcoholAlloyFurnace extends TileEntityAlloyFurnace implements IFluidHandler{
	
	 protected FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME*2);
	 public int fluidAmount;

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		int ft=tank.fill(resource, doFill);;
		fluidAmount=5;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		this.markDirty();
		return ft;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(tank.getFluid()))
        {
            return null;
        }
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		this.markDirty();
        return tank.drain(resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		//this.markDirty();
		//this.validate();
		return tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		//this.markDirty();
		//this.validate();
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		//this.markDirty();
		//this.validate();
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		// TODO Auto-generated method stub
		//this.markDirty();
		//this.validate();
		 return new FluidTankInfo[] { tank.getInfo() };
	}
	
	@Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        this.fluidAmount=tag.getInteger("fluidAmount");
        tank.readFromNBT(tag);
    }

    @Override
    public void writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tank.writeToNBT(tag);
        tag.setInteger("fluidAmount", this.fluidAmount);
    }
    
    public int getTankAmount()
    {
    	
    	//return this.fluidAmount;
    	return tank.getFluidAmount();
    }
    
    public FluidTank getTank(){
    	return tank;
    }
    
    public void setTankAmount(int value){
    	System.out.println("SetTankAmount "+value);
    	if(tank.getFluid()!=null)
    	{	
    		//tank.getFluid().amount=value;
    		
    	}
    	fluidAmount=value;
    
    }
    
    /**
     * i cambiamenti nella gui vanno sincronizzati
     */
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

}
