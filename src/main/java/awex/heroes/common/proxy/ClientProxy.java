package awex.heroes.common.proxy;

import awex.heroes.client.render.hero.RendererManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fiskfille.heroes.client.model.ModelBipedMultiLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import org.lwjgl.opengl.Display;

public class ClientProxy extends CommonProxy{

    private static final ModelBipedMultiLayer model = new ModelBipedMultiLayer();
    private Minecraft mc = Minecraft.getMinecraft();

    public static ModelBiped getArmorModel(int id) {
        switch (id) {
            case 0:
                return model;
            default:
                break;
        }
        return model;
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void Init(FMLInitializationEvent e) {
        super.Init(e);
        RendererManager.register();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    public void setWindowDisplayTitle() {
        Display.setTitle("Justice MC");
    }
}
