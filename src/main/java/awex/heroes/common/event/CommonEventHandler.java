package awex.heroes.common.event;

import awex.heroes.JusticeMC;
import cpw.mods.fml.client.FMLFolderResourcePack;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.ResourcePackListEntry;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Resource;

public class CommonEventHandler {
    @SubscribeEvent
    public void onJoin(PlayerEvent.PlayerLoggedInEvent e) {
        EntityPlayerMP player = (EntityPlayerMP) e.player;
        if (JusticeMC.xray){
            e.setCanceled(true);
            MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
            server.getCommandManager().executeCommand(server, "/tempban " + player.getDisplayName() + " 3 day Using a X-Ray Mod/Client/Texture Pack. (Caught by Anti-Cheat)");
        }
    }
}
