package Morpheuss93.MorpheussTechCrops.blocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import Morpheuss93.MorpheussTechCrops.Reference;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.FishTrap;
import Morpheuss93.MorpheussTechCrops.blocks.fishtrap.TileEntityFishTrap;
import Morpheuss93.MorpheussTechCrops.items.ItemsHandler;

public class BlockHandler {
	
	public static FishTrap fishTrap;
	
	public static void configureBlocks(){
		fishTrap=(FishTrap) new FishTrap(false).setBlockName("Fish Trap");
		GameRegistry.registerBlock(fishTrap, fishTrap.getUnlocalizedName().substring(5));
	}
	
	public static void configureRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(fishTrap), new Object[]{"www","wfw","www",'w',Blocks.planks,'f',ItemsHandler.fishingNet});
	}
	
	public static void configureTile(){
		GameRegistry.registerTileEntity(TileEntityFishTrap.class, Reference.MODID+"TileEntityFishTrap");
	}

}
