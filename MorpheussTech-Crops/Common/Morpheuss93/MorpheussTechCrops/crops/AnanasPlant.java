package Morpheuss93.MorpheussTechCrops.crops;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.food.FoodHandler;

public class AnanasPlant extends Base{
	
	public AnanasPlant() {
		super();
		setBlockName("AnanasPlant");
		//setBlockTextureName(Reference.MODID+":Ananas_stage_0");
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		//System.out.println("meta= "+meta);
		return (meta/2);
	}

	@Override
	public Item getItemDropped(int parMetadata, Random parRand, int parFortune)  {
		//System.out.println("Ananas Dropped ");
		return Items.potato;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister parIIconRegister) {

		iIcon=new IIcon[8];
		
		
		iIcon[0]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_0");
		iIcon[1]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_1");
		iIcon[2]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_2");
		iIcon[3]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_3");
		iIcon[4]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_4");
		iIcon[5]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_5");
		iIcon[6]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_6");
		iIcon[7]=parIIconRegister.registerIcon(Reference.MODID+":Ananas_stage_7");
	}
	
	@Override
	public boolean onBlockActivated(World p_149727_1_, int x,
			int y, int z, EntityPlayer p_149727_5_,
			int p_149727_6_, float p_149727_7_, float p_149727_8_,
			float p_149727_9_) {
		
		//System.out.println("spwn "+x+" "+y+" "+z);
		if(!p_149727_1_.isRemote && p_149727_1_.getBlockMetadata(x, y, z)==7)
		{
			EntityItem item=new EntityItem(p_149727_1_,(double)x,(double)y,(double)z,new ItemStack(FoodHandler.ananas,1));
			p_149727_1_.spawnEntityInWorld(item);
			p_149727_1_.setBlockMetadataWithNotify(x, y, z, 4, 2);
			
		}
		return super.onBlockActivated(p_149727_1_, x, y,
				z, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_,
				p_149727_9_);
	}
	
	@Override
	public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ)
    {
		System.out.println("Grow");
		
		if(parWorld.getBlockMetadata(parX, parY, parZ)<4)
			incrementGrowStage(parWorld, parX, parY, parZ);
    }
}
