package Morpheuss93.MorpheussTechCrops.food;

import Morpheuss93.MorpheussTechCrops.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class FoodHandler {

	public final static Item ananas=new Ananas();
	public final static Item rottenStuff=new RottenStuff();
	public final static Item pineappleSlice=new PineappleSlice();
	public final static Item corncob=new Corncob();
	
	public static void configure(){
		GameRegistry.registerItem(ananas, Reference.MODID+"-"+ananas.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(rottenStuff, Reference.MODID+"-"+rottenStuff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pineappleSlice, Reference.MODID+"-"+pineappleSlice.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(corncob, Reference.MODID+"-"+corncob.getUnlocalizedName().substring(5));
		
	}
}
