package HistoricAges.common.registry;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import HistoricAges.common.blocks.crops.cropRice;
import HistoricAges.common.blocks.machines.blockMachine;
import HistoricAges.common.blocks.metals.metalBlock;
import HistoricAges.common.blocks.metals.metalBrick;
import HistoricAges.common.blocks.metals.metalChiseled;
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
	public static Block oreIron, blockIron, brickIron, chiseledIron;
	public static Block oreGold, blockGold, brickGold, chiseledGold;
	public static void init() {
		
	    /*
	     * ------------------
	     * ----- Metals -----
	     * ------------------
	     */
		oreCobalt = new oreBlock(Material.rock).setBlockName("oreCobalt");
		oreTin = new oreBlock(Material.rock).setBlockName("oreTin");
		oreSilver = new oreBlock(Material.rock).setBlockName("oreSilver");
		oreCopper = new oreBlock(Material.rock).setBlockName("oreCopper");
		oreLead = new oreBlock(Material.rock).setBlockName("oreLead");
		oreIron = new oreBlock(Material.rock).setBlockName("oreIron");
		oreGold = new oreBlock(Material.rock).setBlockName("oreGold");
		
		/*--------*/
		/* BLOCKS */
		/*--------*/
		
		blockCobalt = new metalBlock(Material.iron).setBlockName("blockCobalt");
		blockTin = new metalBlock(Material.iron).setBlockName("blockTin");
		blockSilver = new metalBlock(Material.iron).setBlockName("blockSilver"); 
		blockCopper = new metalBlock(Material.iron).setBlockName("blockCopper");
		blockLead = new metalBlock(Material.iron).setBlockName("blockLead");
		blockIron = new metalBlock(Material.iron).setBlockName("blockIron");
		blockGold = new metalBlock(Material.iron).setBlockName("blockGold");
		
		/*--------*/
		/* BRICKS */
		/*--------*/
		
		brickCobalt = new metalBrick(Material.iron).setBlockName("brickCobalt");
		brickTin = new metalBrick(Material.iron).setBlockName("brickTin");
		brickSilver = new metalBrick(Material.iron).setBlockName("brickSilver");
		brickCopper = new metalBrick(Material.iron).setBlockName("brickCopper");
		brickLead = new metalBrick(Material.iron).setBlockName("brickLead");
		brickIron = new metalBrick(Material.iron).setBlockName("brickIron"); 
		brickGold = new metalBrick(Material.iron).setBlockName("brickGold");
		
		/*----------*/
		/* Chiseled */
		/*----------*/

		chiseledCobalt = new metalChiseled(Material.iron).setBlockName("chiseledCobalt");
		chiseledTin = new metalChiseled(Material.iron).setBlockName("chiseledTin"); 
		chiseledSilver = new metalChiseled(Material.iron).setBlockName("chiseledSilver");
		chiseledCopper = new metalChiseled(Material.iron).setBlockName("chiseledCopper");
		chiseledLead = new metalChiseled(Material.iron).setBlockName("chiseledLead");
		chiseledIron = new metalChiseled(Material.iron).setBlockName("chiseledIron");
		chiseledGold = new metalChiseled(Material.iron).setBlockName("chiseledGold");
		
	    /*
	     * -------------------
	     * ----- Farming -----
	     * -------------------
	     */	
		
		
		/*-------*/
		/* Crops */
		/*-------*/
		
		cropRice = new cropRice();
		
		/*
	     * ------------------
	     * ---- Machines ----
	     * ------------------
	     */
		//machineOven = new blockMachine();
		

		
	}
	
	public static void register() {
	
	    /*
	     * ------------------
	     * ----- Metals -----
	     * ------------------
	     */	
		registerBlock(oreCobalt);
		registerBlock(oreTin);
		registerBlock(oreSilver);
		registerBlock(oreCopper);
		registerBlock(oreLead);
		registerBlock(oreIron);
		registerBlock(oreGold);
		
		/*--------*/
		/* BLOCKS */
		/*--------*/

		registerBlock(blockCobalt);
		registerBlock(blockTin);
		registerBlock(blockSilver);
		registerBlock(blockCopper);
		registerBlock(blockLead);
		registerBlock(blockIron);
		registerBlock(blockGold);
		
		/*--------*/
		/* BRICKS */
		/*--------*/
		
		registerBlock(brickCobalt);
		registerBlock(brickTin);
		registerBlock(brickSilver);
		registerBlock(brickCopper);
		registerBlock(brickLead);
		registerBlock(brickIron);
		registerBlock(brickGold);
		
		/*----------*/
		/* Chiseled */
		/*----------*/
		
		registerBlock(chiseledCobalt);
		registerBlock(chiseledTin);
		registerBlock(chiseledSilver);
		registerBlock(chiseledCopper);
		registerBlock(chiseledLead);
		registerBlock(chiseledIron);
		registerBlock(chiseledGold);
		
		
		
	    /*
	     * -------------------
	     * ----- Farming -----
	     * -------------------
	     */	
		
		
		/*-------*/
		/* Crops */
		/*-------*/
		
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
