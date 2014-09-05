package HistoricAges.common;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.config.Configuration;
import HistoricAges.common.handler.GuiHandler;
import HistoricAges.common.helper.HistoricAgesReference;
import HistoricAges.common.manager.EventManager;
import HistoricAges.common.proxy.HACommonProxy;
import HistoricAges.common.registry.HistoricAgesBlocks;
import HistoricAges.common.registry.HistoricAgesItems;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = HistoricAges.modid, name = "HistoricAges", version = "1.7.10-Alpha-0.1.0.0", dependencies = "")
public class HistoricAges
{
	/// Icons/Textures are temporary \\\
	
	public static final String modid = "HistoricAges";

	@SidedProxy(clientSide = "HistoricAges.common.proxy.HAClientProxy", serverSide = "HistoricAges.common.proxy.HACommonProxy")
	public static HACommonProxy proxy;
	
	public static SimpleNetworkWrapper snw; 
	
	

	EventManager eventmanager = new EventManager();
	@Instance("HistoricAges")
	public static HistoricAges instance;
	
	@Mod.EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		
		HistoricAgesBlocks.init();
		HistoricAgesItems.init();
		
		//CraftingManager.getInstance().getRecipeList().clear();

		
		snw = NetworkRegistry.INSTANCE.newSimpleChannel("HistoricAges"); 
		GameRegistry.registerWorldGenerator(eventmanager, 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		
	}

	@Mod.EventHandler
	public void load(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
	}
	
	@Mod.EventHandler
	public void postload(FMLPostInitializationEvent event) {
	
		
	}
	
	@EventHandler
	public void onServerStarting(FMLServerStartingEvent event)
	{

	}
}

