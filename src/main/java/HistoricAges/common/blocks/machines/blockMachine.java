package HistoricAges.common.blocks.machines;

import java.util.List;

import HistoricAges.common.blocks.machines.tile.TileEntityOven;
import HistoricAges.common.reference.Names;
import HistoricAges.common.util.BlockRotation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class blockMachine extends Block
{
    private IIcon[] icons = new IIcon[5];
    
    public blockMachine()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setBlockName(Names.MACHINES);
    }
    
    public TileEntity createTileEntity(World world, int meta)
    {
        switch (meta)
        {
            case 0:
                return new TileEntityOven();
        }
        return null;
    }
    
    public boolean hasTileEntity(int meta)
    {
        return meta == 0 || meta == 1 || meta == 2;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 0)
            {
                player.openGui(HistoricAges.common.HistoricAges.instance, 1, world, x, y, z);
                return true;
            }
        }
        return true;
    }
    
    public void getSubBlocks(Item item, CreativeTabs creativeTab, List list)
    {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }
    
    public int damageDropped(int meta)
    {
        return meta;
    }
    
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        int meta = world.getBlockMetadata(x, y, z);
        return new ItemStack(this, 1, meta);
    }
    
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "tile.machineBase");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "tile.energizedFurnaceFrontOff");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "tile.energizedFurnaceFrontOn");
        icons[3] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "tile.energizedGrinderFrontOff");
        icons[4] = iconRegister.registerIcon(Reference.MOD_ID + ":" + "tile.energizedGrinderFrontOn");
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0)
        {
            TileEntityOven tileentity = (TileEntityOven) world.getTileEntity(x, y, z);
            tileentity.rotation = BlockRotation.determineMetadataBasedOnPlayerOrientation(player);
        }
    }
    
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0)
        {
            TileEntityOven tileentity = (TileEntityOven) world.getTileEntity(x, y, z);
            if (side == tileentity.rotation)
            {
                if (tileentity.isSmelting)
                {
                    return icons[2];
                }
                else
                {
                    return icons[1];
                }
            }
        }

    }
    
    public IIcon getIcon(int side, int meta)
    {
        if (meta == 0 && side == 3)
        {
            return icons[1];
        }
        if (meta == 1 && side == 3)
        {
            return icons[3];
        }
        return icons[0];
    }
}

