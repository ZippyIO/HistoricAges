package HistroicAges.common.items.age1;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import HistroicAges.common.items.special.RecipeItemSeedFood;
import HistroicAges.common.registry.HistoricAgesBlocks;

public class itemRice extends RecipeItemSeedFood {
	
	public itemRice() {
		super(HistoricAgesBlocks.cropRice, Blocks.farmland);
		setUnlocalizedName("itemRice");
		setTextureName("historicages:itemRice");
		setCreativeTab(CreativeTabs.tabFood);
		setMaxStackSize(8);
	}

}
