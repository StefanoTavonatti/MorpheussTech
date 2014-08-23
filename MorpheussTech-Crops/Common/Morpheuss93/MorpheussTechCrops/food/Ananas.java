package Morpheuss93.MorpheussTechCrops.food;

import net.minecraft.init.Blocks;
import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.seed.BaseItemSeedFood;
import Morpheuss93.MorpheussTechCrops.crops.CropsHandler;

public class Ananas extends BaseItemSeedFood{

	public Ananas(){
		super(6,0.6F,CropsHandler.ananasPlant,Blocks.farmland);
		setUnlocalizedName("Ananas");
		setTextureName(Reference.MODID+":Ananas");
		setCreativeTab(MCrops.tabCrop);
	}
}
