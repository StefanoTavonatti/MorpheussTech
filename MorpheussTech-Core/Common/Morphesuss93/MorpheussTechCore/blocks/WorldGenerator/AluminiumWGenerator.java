package Morphesuss93.MorpheussTechCore.blocks.WorldGenerator;

import java.util.Random;

import Morphesuss93.MorpheussTechCore.blocks.BlockHandler;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class AluminiumWGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunnkGenerator, IChunkProvider chunkProvider) {
		
		switch(world.provider.dimensionId)
		{
			case -1:
				//generateNether(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				break;
			case 1:
				//generateEnd(world, random, chunkX * 16, chunkZ * 16);
				break;
		}
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		
		for(int i=0;i<30;i++)//i=vene
		{
			int cordX= random.nextInt(16)+chunkX;
			//int cordY= random.nextInt(20)+44;
			int cordY= random.nextInt(28)+32;
			int cordZ= random.nextInt(16)+chunkZ;
			
			(new WorldGenMinable(BlockHandler.aluminiumOre,5)).generate(world, random,cordX, cordY, cordZ);
		}
			
	}

}
