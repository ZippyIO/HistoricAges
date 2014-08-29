package HistroicAges.common.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import HistroicAges.common.blocks.crops.cropRice;

public class HistoricAgesBlocks {
	
	public static Block cropRice;
	
	public static void init() {
		
		cropRice = new cropRice();
		
		
		registerBlock(cropRice);
		
	}
	
	private static void registerBlock(Block block)
	{
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
	}
	
	private static void registerBlock(Block block, Class itemClass)
	{
		GameRegistry.registerBlock(block, itemClass, block.getUnlocalizedName());
	}

}
