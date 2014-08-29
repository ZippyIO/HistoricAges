package HistroicAges.common;

import net.minecraftforge.common.config.Configuration;
import HistroicAges.common.handler.GuiHandler;
import HistroicAges.common.manager.EventManager;
import HistroicAges.common.proxy.HACommonProxy;
import HistroicAges.common.registry.HistoricAgesBlocks;
import HistroicAges.common.registry.HistoricAgesItems;
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

@Mod(modid = HistroicAges.modid, name = "HistroicAges", version = "v1.0.0-beta.1", dependencies = "")
public class HistroicAges
{
	/// Icons/Textures are temporary \\\
	
	public static final String modid = "HistroicAges";

	@SidedProxy(clientSide = "HistroicAges.common.proxy.HAClientProxy", serverSide = "HistroicAges.common.proxy.HACommonProxy")
	public static HACommonProxy proxy;
	
	public static SimpleNetworkWrapper snw; 
	
	

	EventManager eventmanager = new EventManager();
	@Instance("HistroicAges")
	public static HistroicAges instance;
	
	@Mod.EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		
		HistoricAgesBlocks.init();
		HistoricAgesItems.init();

		
		snw = NetworkRegistry.INSTANCE.newSimpleChannel("HistroicAges"); 
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

