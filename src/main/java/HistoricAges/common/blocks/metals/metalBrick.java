package HistoricAges.common.blocks.metals;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class metalBrick extends Block {

	public metalBrick(Material mat) {
		super(mat);

	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	blockIcon = p_149651_1_.registerIcon(HistoricAges.common.HistoricAges.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
	return blockIcon;
	}

}
