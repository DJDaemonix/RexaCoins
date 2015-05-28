package net.rexacraft.rexacoins;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.rexacraft.rexacoins.blocks.CashMachine;
import net.rexacraft.rexacoins.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "RexaCoins", name = "RexaCoins", version = "@VERSION@")
public class RexaCoins
{

    @Instance("RexaCoins")
    public static RexaCoins instance;
    public static final String MODID = "RexaCoins";

    @SidedProxy(clientSide = "net.rexacraft.rexacoins.proxy.ClientProxy", serverSide = "net.rexacraft.rexacoins.proxy.CommonProxy")
    public static CommonProxy proxy;

    // Blocks
    public static Block CashMachine;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        CashMachine = new CashMachine().setBlockName("CashMachine").setCreativeTab(CreativeTabs.tabMaterials);

        GameRegistry.registerBlock(CashMachine, "CashMachine");
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRender();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        System.out.println("Ka-Ching !");
    }
}
