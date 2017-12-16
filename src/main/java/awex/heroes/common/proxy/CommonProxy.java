package awex.heroes.common.proxy;


import awex.heroes.JusticeMC;
import awex.heroes.client.gui.GuiHandler;
import awex.heroes.common.data.Data;
import awex.heroes.common.event.CommonEventHandler;
import awex.heroes.common.hero.HeroRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import awex.heroes.common.items.ModItems;
import fiskfille.heroes.common.data.SHData;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        HeroRegistry.register();
        ModItems.register();
        Data.init();
    }

    public void Init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new CommonEventHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}