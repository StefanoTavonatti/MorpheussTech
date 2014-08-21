package Morpheuss93.MorpheussTechCrops.food;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class FoodHandler {

	public final static Item ananas=new Ananas();
	
	public static void configure(){
		GameRegistry.registerItem(ananas, "Ananas");
	}
}
