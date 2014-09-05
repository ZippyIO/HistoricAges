package HistoricAges.common.items.age1;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import HistoricAges.common.items.special.RecipeItemSeedFood;
import HistoricAges.common.registry.HistoricAgesBlocks;

public class itemRice extends RecipeItemSeedFood {
	
	public itemRice() {
		super(HistoricAgesBlocks.cropRice, Blocks.farmland);
		setUnlocalizedName("itemRice");
		setTextureName("historicages:itemRice");
		setCreativeTab(CreativeTabs.tabFood);
		setMaxStackSize(8);
	}

}
