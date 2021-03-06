package HistoricAges.common.blocks.crops;

import java.util.Random;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import HistoricAges.common.blocks.special.RecipeBlockCrops;
import HistoricAges.common.registry.HistoricAgesItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class cropRice extends RecipeBlockCrops{
	
	public cropRice() {
		setBlockName("cropRice");
		setBlockTextureName("historicages:cropRice_stage_0");
	}

	@Override
	// Returns the quantity of items to drop on block destruction.
	public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
		return (parMetadata/2);
	}
	
	@Override
	public Item getItemDropped(int parMetadata, Random parRand, int parFortune) {
		return(HistoricAgesItems.itemRice);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister parIIconRegister) {
		iIcon = new IIcon[8];
		
		iIcon[0] = parIIconRegister.registerIcon("historicages:cropRice_stage_0");
		iIcon[1] = parIIconRegister.registerIcon("historicages:cropRice_stage_0");
		iIcon[2] = parIIconRegister.registerIcon("historicages:cropRice_stage_1");
		iIcon[3] = parIIconRegister.registerIcon("historicages:cropRice_stage_1");
		iIcon[4] = parIIconRegister.registerIcon("historicages:cropRice_stage_2");
		iIcon[5] = parIIconRegister.registerIcon("historicages:cropRice_stage_2");
		iIcon[6] = parIIconRegister.registerIcon("historicages:cropRice_stage_3");
		iIcon[7] = parIIconRegister.registerIcon("historicages:cropRice_stage_4");
	}
}
