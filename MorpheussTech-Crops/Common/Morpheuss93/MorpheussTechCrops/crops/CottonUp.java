package Morpheuss93.MorpheussTechCrops.crops;

import java.util.Random;

import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class CottonUp extends Block{

	public CottonUp() {
		super(Material.grass);
		this.setBlockName("Cotton");
		this.setBlockTextureName(Reference.MODID+":CottonUp");
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x,int y, int z, Block block) {
		super.onNeighborBlockChange(world, x, y, z,block);
		
		
		if(block.getUnlocalizedName().equals(CropsHandler.cottonCrop.getUnlocalizedName())){
			
			world.func_147480_a(x, y, z, true);
		}
		
		
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x,int y, int z, int meta) {
		
		super.onBlockDestroyedByPlayer(world, x, y,z, meta);
		
		if(world.getBlock(x, y-1, z)==CropsHandler.cottonCrop){
			world.func_147480_a(x, y-1, z, true);
		}
		
	}
	
	
	
	
	
	@Override
	public int getRenderType() {
		return 1;
	};
	
	public int quantityDropped(int meta, int fortune, Random random) {
		return 0;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
