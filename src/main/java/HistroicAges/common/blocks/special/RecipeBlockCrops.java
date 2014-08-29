package HistroicAges.common.blocks.special;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RecipeBlockCrops extends BlockBush implements IGrowable{
	
	@SideOnly(Side.CLIENT)
	protected IIcon[] iIcon;
	
	public RecipeBlockCrops() {
		setTickRandomly(true);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		setCreativeTab(CreativeTabs.tabFood);
		setHardness(0.0F);
		setStepSound(soundTypeGrass);
		disableStats();
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block parBlock) {
		return parBlock == Blocks.farmland;
	}
	
	public void incrementGrowStage(World parWorld, int parX, int parY, int parZ) {
		int growStage = parWorld.getBlockMetadata(parX, parY, parZ) +
				MathHelper.getRandomIntegerInRange(parWorld.rand, 2, 5);
		
		if(growStage > 7) {
			growStage = 7;
		}
		
		parWorld.setBlockMetadataWithNotify(parX, parY, parZ, growStage, 2);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random parRand, int parFortune) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public int getRenderType() {
		return 1;
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int parSide, int parGrowthStage) {
		return iIcon[parGrowthStage];
	}
	
	@Override
	// func_149851_a returns true if bonemeal is allowed, false otherwise.
	public boolean func_149851_a(World parWorld, int parX, int parY, int parZ, boolean p_149851_5_) {
		return parWorld.getBlockMetadata(parX, parY, parZ) != 7;
	}
	
	@Override
	// func_149852_a returns true at the same time bonemeal is used if conditions for a growth-tick are acceptable.
	public boolean func_149852_a(World p_149852_1_, Random parRand, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return true;
	}
	
	@Override
	// func_149853_b processes the actual growth-tick logic, which is usually increasing metadata or replacing the block.
	public void func_149853_b(World parWorld, Random parRand, int parX, int parY, int parZ) {
		incrementGrowStage(parWorld, parX, parY, parZ);
	}
	
}
