package HistroicAges.common.registry;

import cpw.mods.fml.common.registry.GameRegistry;
import HistroicAges.common.items.age1.itemRice;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class HistoricAgesItems {
	
	public static Item itemRice;
	
	public static void init() {
		
		itemRice = new itemRice();
		
		registerItem(itemRice);
		
	}
	
	private static void registerItem(Item item)
	{
		GameRegistry.registerItem(item, item.getUnlocalizedName());
	}

}
