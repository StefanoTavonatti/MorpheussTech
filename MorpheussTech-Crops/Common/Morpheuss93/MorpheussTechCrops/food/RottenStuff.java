package Morpheuss93.MorpheussTechCrops.food;

import Morpheuss93.MorpheussTechCrops.MCrops;
import Morpheuss93.MorpheussTechCrops.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class RottenStuff extends ItemFood{

	public RottenStuff() {
		super(1,0.0F, false);
		this.setUnlocalizedName("RottenStuff");
		this.setTextureName(Reference.MODID+":RottenStuff");
		setCreativeTab(MCrops.tabCrop);
	}
	
	 public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player){
		 //player.setHealth(1.0F);
		// player.performHurtAnimation();
		 //player.hurtTime=15;
		 player.addPotionEffect(new PotionEffect(Potion.hunger.getId(),500));
		 player.addPotionEffect(new PotionEffect(Potion.confusion.getId(),200));
		 return super.onEaten(itemstack, world, player);
	 }

}
