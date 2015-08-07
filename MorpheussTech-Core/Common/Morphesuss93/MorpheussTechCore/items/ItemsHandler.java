package Morphesuss93.MorpheussTechCore.items;

import cpw.mods.fml.common.registry.GameRegistry;
import Morphesuss93.MorpheussTechCore.Core;
import Morphesuss93.MorpheussTechCore.Reference;
import Morphesuss93.MorpheussTechCore.blocks.BlockHandler;
import Morphesuss93.MorpheussTechCore.blocks.AlcoholAlloyFurnace.AlcoholAlloyFurnace;
import Morphesuss93.MorpheussTechCore.fluids.BucketHandler;
import Morphesuss93.MorpheussTechCore.items.components.SmallAlcoholBurner;
import Morphesuss93.MorpheussTechCore.items.components.SmallAlcoholBurnerComponent;
import Morphesuss93.MorpheussTechCore.items.components.SmallAlcoholBurnerSupport;
import Morphesuss93.MorpheussTechCore.items.components.Smalligniter;
import Morphesuss93.MorpheussTechCore.items.ingot.*;
import Morphesuss93.MorpheussTechCore.items.ingot.alloy.BrassIngot;
import Morphesuss93.MorpheussTechCore.items.ingot.alloy.BronzeIngot;
import Morphesuss93.MorpheussTechCore.items.misc.Biomass;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemsHandler {
	
	public static CopperIngot copperIngot;
	public static AluminiumIngot aluminiumIngot;
	public static SilverIngot silverIngot;
	public static TinIngot tinIngot;
	public static BronzeIngot bronzeIngot;
	public static BrassIngot brassIngot;
	public static SteelIngot steelIngot;
	public static Item alcoholBucket;
	public static SmallAlcoholBurnerComponent smallAlcoholBurnerComponent;
	public static SmallAlcoholBurnerSupport smallAlcoholBurnerSupport;
	public static Smalligniter smalligniter;
	public static SmallAlcoholBurner smallAlcoholBurner;
	public static Biomass biomass;
	
	
	public static void configureItems(Configuration config){
		copperIngot=new CopperIngot();
		GameRegistry.registerItem(copperIngot, Reference.MODID+"-"+copperIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotCopper", copperIngot);
		
		aluminiumIngot=new AluminiumIngot();
		GameRegistry.registerItem(aluminiumIngot, Reference.MODID+"-"+aluminiumIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotAluminium", aluminiumIngot);
		
		silverIngot=new SilverIngot();
		GameRegistry.registerItem(silverIngot, Reference.MODID+"-"+silverIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotSilver", silverIngot);
		
		tinIngot=new TinIngot();
		GameRegistry.registerItem(tinIngot, Reference.MODID+"-"+tinIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotTin", tinIngot);
		
		bronzeIngot=new BronzeIngot();
		GameRegistry.registerItem(bronzeIngot, Reference.MODID+"-"+bronzeIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotBronze", bronzeIngot);
		
		brassIngot=new BrassIngot();
		GameRegistry.registerItem(brassIngot, Reference.MODID+"-"+brassIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotBrass", brassIngot);
				
		steelIngot=new SteelIngot();
		GameRegistry.registerItem(steelIngot, Reference.MODID+"-"+steelIngot.getUnlocalizedName().substring(5));
		OreDictionary.registerOre("ingotSteel", steelIngot);
		
		alcoholBucket = new ItemBucket(BlockHandler.alcoholBlock).setUnlocalizedName("AlcoholBucket").setContainerItem(Items.bucket).setTextureName(Reference.MODID+":"+"AlcoholBucket");
		alcoholBucket.setCreativeTab(Core.tabCore);
		GameRegistry.registerItem(alcoholBucket, Reference.MODID+"_"+"AlcoholBucket");
		FluidContainerRegistry.registerFluidContainer(BlockHandler.alcohol,new ItemStack(alcoholBucket),new ItemStack(Items.bucket));
		//gestisco l'evento del fluido che viene raccolto
		BucketHandler.INSTANCE.buckets.put(BlockHandler.alcoholBlock, alcoholBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		
		smallAlcoholBurnerComponent=new SmallAlcoholBurnerComponent();
		GameRegistry.registerItem(smallAlcoholBurnerComponent, smallAlcoholBurnerComponent.getUnlocalizedName().substring(5));

		smallAlcoholBurnerSupport=new SmallAlcoholBurnerSupport();
		GameRegistry.registerItem(smallAlcoholBurnerSupport, smallAlcoholBurnerSupport.getUnlocalizedName().substring(5));
		
		smalligniter=new Smalligniter();
		GameRegistry.registerItem(smalligniter, smalligniter.getUnlocalizedName().substring(5));
		
		smallAlcoholBurner=new SmallAlcoholBurner();
		GameRegistry.registerItem(smallAlcoholBurner, smallAlcoholBurner.getUnlocalizedName().substring(5));
		
		biomass=new Biomass();
		GameRegistry.registerItem(biomass, biomass.getUnlocalizedName().substring(5));
		
		
	}
	
	public static void configureRecipe(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(smallAlcoholBurnerSupport), true, new Object[]{"sss","s s","sss",'s',"ingotSteel"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(smalligniter), true, new Object[]{" fi","  i","  i",'i',Items.iron_ingot,'f',Items.flint_and_steel}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(smallAlcoholBurner), true, new Object[]{" i "," c "," s ",'i',smalligniter,'c',smallAlcoholBurnerComponent,'s',smallAlcoholBurnerSupport}));
		GameRegistry.addShapedRecipe(new ItemStack(BlockHandler.alcoholAlloyFurnace,1), new Object[]{" a ","csc","ccc",'a',BlockHandler.AlloyFurnace,'s',smallAlcoholBurner,'c',Blocks.cobblestone});
	}

}
