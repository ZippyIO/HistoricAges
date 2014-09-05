package HistoricAges.common.energy;

import net.minecraft.nbt.NBTTagCompound;

public class QFBar {
    private int maxQFLevel = 0;
    private int defaultMaxQFLevel;
    private int QFLevel = 0;
    
    public QFBar(int maxQFLevel, boolean shouldStartOfWithMaxQF)
    {
        this.maxQFLevel = defaultMaxQFLevel = maxQFLevel;
        if (shouldStartOfWithMaxQF) this.QFLevel = maxQFLevel;
    }
    
    public QFBar(int maxQFLevel)
    {
        this(maxQFLevel, false);
    }
    
    public void addQF(int amount)
    {
        QFLevel += amount;
    }
    
    public void ExtractQF(int amount)
    {
        QFLevel -= amount;
    }
    
    public boolean canAddQF(int amount)
    {
        return (QFLevel + amount) <= maxQFLevel;
    }
    
    public boolean canExtractQF(int amount)
    {
        return (QFLevel - amount) >= 0;
    }
    
    public void setMaxQFLevel(int newMax)
    {
        this.maxQFLevel = newMax;
    }
    
    public int getMaxQFLevel()
    {
        return maxQFLevel;
    }
    
    public void setQFLevel(int amount)
    {
        QFLevel = amount;
    }
    
    public int getQFLevel()
    {
        return QFLevel;
    }
    
    public void writeToNBT(NBTTagCompound tag)
    {
        tag.setInteger("qfLevel", QFLevel);
    }
    
    public void readFromNBT(NBTTagCompound tag)
    {
        this.QFLevel = tag.getInteger("qfLevel");
    }
    
    public int getQFLevelScaled(int scale)
    {
        return QFLevel * scale / maxQFLevel;
    }
    
    public int addQFWithRemaining(int amount)
    {
        QFLevel += amount;
        if (QFLevel > maxQFLevel)
        {
            int powerRemaining = QFLevel - maxQFLevel;
            QFLevel -= powerRemaining;
            return powerRemaining;
        }
        return 0;
    }
    
    public void resetMaxQFLevel()
    {
        maxQFLevel = defaultMaxQFLevel;
    }
}
