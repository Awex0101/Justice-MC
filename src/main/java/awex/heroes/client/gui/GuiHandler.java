package awex.heroes.client.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, final EntityPlayer player, World world, int x, int y, int z) {
        switch (id) {
            case 0:
                return new GuiConstruct();
        }
        return null;
    }
}
