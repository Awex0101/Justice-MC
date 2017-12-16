package awex.heroes.client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import fiskfille.heroes.client.gui.GuiSHModConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

public class ModGuiFactory implements IModGuiFactory
{
    public void initialize(Minecraft minecraftInstance)
    {

    }

    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return null;
    }

    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return null;
    }
}