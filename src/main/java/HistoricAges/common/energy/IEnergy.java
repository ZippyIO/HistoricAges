package HistoricAges.common.energy;

import HistoricAges.common.reference.BlockType;
import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergy {
    public boolean canAddQFOnSide(ForgeDirection direction);
    
    public boolean canConnect(ForgeDirection direction);
    
    public QFBar getQFBar();
    
    public void setLastReceivedDirection(ForgeDirection direction);
    
    public int getQFTransferRate();
    
    public BlockType getTypeOfBlock();
}