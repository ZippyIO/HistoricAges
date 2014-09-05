package HistoricAges.common.energy;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class QFNet {
    /**
     * A utility method for distributing QF to the surrounding
     * machines/cables.
     * 
     * @param world
     *            Self-explainatory
     * @param x
     *            Self-explainatory
     * @param y
     *            Self-explainatory
     * @param z
     *            Self-explainatory
     * @param lastDirection
     *            The direction the QF was set from last time, so it
     *            prevents back and forth looping of cables. Please use one of
     *            the six valid directions ({@link ForgeDirection}), or UNKNOWN
     *            of you don't have a last direction.
     * @param QFBar
     *            The QFBar object to take the QF from.
     */
    public static void distributeQFToSurrounding(World world, int x, int y, int z, ForgeDirection lastDirection, QFBar QFBar)
    {
        distributeQFToSurroundingWithLoss(world, x, y, z, lastDirection, QFBar, 0);
    }
    
    /**
     * A utility method for distributing QF to the surrounding
     * machines/cables.
     * 
     * @param world
     *            Self-explainatory
     * @param x
     *            Self-explainatory
     * @param y
     *            Self-explainatory
     * @param z
     *            Self-explainatory
     * @param QFBar
     *            The QFBar object to take the QF from.
     */
    public static void distributeQFToSurrounding(World world, int x, int y, int z, QFBar QFBar)
    {
        distributeQFToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, QFBar);
    }
    
    public static void distributeQFToSide(World world, int x, int y, int z, ForgeDirection direction, QFBar QFBar)
    {
        if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy)
        {
            IEnergy QFTileOnSide = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
            IEnergy thisQFTile = (IEnergy) world.getTileEntity(x, y, z);
            ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
            if (thisQFTile.canConnect(invertedSide) && QFTileOnSide.canAddQFOnSide(invertedSide))
            {
                if (QFBar.getQFLevel() - thisQFTile.getQFTransferRate() >= 0)
                {
                    if (QFTileOnSide.getQFBar().canAddQF(thisQFTile.getQFTransferRate()))
                    {
                        QFTileOnSide.getQFBar().addQF(thisQFTile.getQFTransferRate());
                        QFBar.ExtractQF(thisQFTile.getQFTransferRate());
                    }
                    else
                    {
                        int remaining = QFTileOnSide.getQFBar().addQFWithRemaining(thisQFTile.getQFTransferRate());
                        QFBar.ExtractQF(thisQFTile.getQFTransferRate() - remaining);
                    }
                    QFTileOnSide.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }
    
    public static void distributeQFToSurroundingWithLoss(World world, int x, int y, int z, ForgeDirection lastDirection, QFBar QFBar, int loss)
    {
        int sides = 0;
        boolean sidesCanOutput[] = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy)
            {
                IEnergy QFTileNextToIt = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                IEnergy thisQFTile = (IEnergy) world.getTileEntity(x, y, z);
                ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
                if (thisQFTile.canConnect(invertedSide) && QFTileNextToIt.canAddQFOnSide(invertedSide) && direction != lastDirection)
                {
                    sidesCanOutput[direction.ordinal()] = true;
                    sides++;
                }
            }
        }
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            if (sidesCanOutput[direction.ordinal()] && direction != lastDirection)
            {
                IEnergy QFTile = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                if (QFBar.getQFLevel() - QFTile.getQFTransferRate() / sides >= 0)
                {
                    if (QFTile.getQFBar().canAddQF(QFTile.getQFTransferRate() / sides - loss))
                    {
                        QFTile.getQFBar().addQF(QFTile.getQFTransferRate() / sides - loss);
                        QFBar.ExtractQF(QFTile.getQFTransferRate() / sides);
                    }
                    else
                    {
                        int remaining = QFTile.getQFBar().addQFWithRemaining(QFTile.getQFTransferRate() / sides - loss);
                        QFBar.ExtractQF(QFTile.getQFTransferRate() / sides - remaining);
                    }
                    QFTile.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }
}

