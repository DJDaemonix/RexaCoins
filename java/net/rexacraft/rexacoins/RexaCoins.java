package net.rexacraft.rexacoins;

import net.minecraft.item.Item;
import net.rexacraft.rexacoins.proxy.CommonProxy;
import net.rexacraft.rexacoins.resources.assets.common.block.CashMachine;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "RexaCoins", name = "RexaCoins", version = "0.0.0.1")
public class RexaCoins {

	public static final String MODID = "RexaCoins";
	@Instance("RexaCoins")
	public static RexaCoins instance;

	@SidedProxy(clientSide = "net.rexacraft.rexacoins.proxy.ClientProxy", serverSide = "net.rexacraft.rexacoins.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Item CashMachine;
		CashMachine = new CashMachine().setUnlocalizedName("Cash Machine");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRender();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
