package awex.heroes.client.gui;

import awex.heroes.common.data.Data;
import awex.heroes.common.network.MessageGiveTool;
import awex.heroes.common.network.NetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;

@SideOnly(Side.CLIENT)
public class GuiConstruct extends GuiPickTool
{
    public GuiConstruct()
    {
        super(I18n.format("gui.construct"));
    }

    @Override
    public void onDone(String finalName)
    {
        EntityPlayer player = mc.thePlayer;
        if (finalName != null && !finalName.isEmpty())
        {
            Data.CONSTRUCT_TIMER.set(mc.thePlayer, 1.0F);

            if (GuiPickTool.recentlyUsed.contains(finalName))
            {
                GuiPickTool.recentlyUsed.remove(finalName);
            }

            GuiPickTool.recentlyUsed.add(finalName);

            if (GuiPickTool.recentlyUsed.size() > 10)
            {
                GuiPickTool.recentlyUsed.remove(0);
            }
        }
        if (finalName != null && !finalName.isEmpty()){
            if (finalName.equalsIgnoreCase("Axe")){
                NetworkHandler.wrapper.sendToServer(new MessageGiveTool(player));
            }
        }
    }
}
