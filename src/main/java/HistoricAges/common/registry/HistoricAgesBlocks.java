package HistoricAges.common.registry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import HistoricAges.common.blocks.crops.cropRice;
import HistoricAges.common.blocks.machines.blockMachine;
import HistoricAges.common.blocks.ores.oreBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class HistoricAgesBlocks {
	
	public static Block cropRice;
	
	public static Block ore;
	
	public static Block blockMachine;
	
	public static Block blockGrinder;
	
	public static Block machineOven;
	
	public static Block oreCobalt, blockCobalt, brickCobalt, chiseledCobalt;
	public static Block oreTin, blockTin, brickTin, chiseledTin;
	public static Block oreSilver, blockSilver, brickSilver, chiseledSilver;
	public static Block oreCopper, blockCopper, brickCopper, chiseledCopper;
	public static Block oreLead, blockLead, brickLead, chiseledLead;
	public static void init() {
		
		cropRice = new cropRice();
		
		/*--------*/
		/* METALS */
		/*--------*/
		oreCobalt = new oreBlock(Material.rock).setBlockName("oreCobalt");
		oreTin = new oreBlock(Material.rock).setBlockName("oreTin");
		oreSilver = new oreBlock(Material.rock).setBlockName("oreSilver");
		oreCopper = new oreBlock(Material.rock).setBlockName("oreCopper");
		oreLead = new oreBlock(Material.rock).setBlockName("oreLead").setBlockTextureName("oreLead");
		
		
	    /*
	     * ------------------
	     * ---- Machines ----
	     * ------------------
	     */
		//machineOven = new blockMachine();
		
		registerBlock(cropRice);
		registerBlock(oreCobalt);
		registerBlock(oreTin);
		registerBlock(oreSilver);
		registerBlock(oreCopper);
		registerBlock(oreLead);
		
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
