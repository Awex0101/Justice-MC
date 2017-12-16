package awex.heroes;

import awex.heroes.client.render.gui.RenderGuiHandler;
import awex.heroes.common.proxy.ClientProxy;
import awex.heroes.common.proxy.CommonProxy;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = awex.heroes.JusticeMC.MODID, name = JusticeMC.NAME, version = JusticeMC.VERSION, guiFactory = "awex.heroes.client.gui.ModGuiFactory")
public class JusticeMC
{
    public static final String MODID = "justicemc";
    public static final String VERSION = "1.0.1";
    public static final String NAME = "Justice MC - Heroes";

    public static boolean xray = false;
    @Mod.Instance(JusticeMC.MODID)
    public static JusticeMC instance;

    @SidedProxy(clientSide = "awex.heroes.common.proxy.ClientProxy", serverSide = "awex.heroes.common.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("justicemc");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
        xray = Loader.isModLoaded("xray") || Loader.isModLoaded("fgtXray") || Loader.isModLoaded("Kardxns Xray") || Loader.isModLoaded("Scenter") || Loader.isModLoaded("cheating essentials") || Loader.isModLoaded("cheatclient");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.Init(e);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        MinecraftForge.EVENT_BUS.register(new RenderGuiHandler());
    }

    @Mod.EventHandler
    public void contruction(FMLLoadCompleteEvent event) {
        if (proxy instanceof ClientProxy) {
            ClientProxy cp = (ClientProxy) proxy;
            cp.setWindowDisplayTitle();
        }
    }
}
