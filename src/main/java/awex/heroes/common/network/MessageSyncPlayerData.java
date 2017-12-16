package awex.heroes.common.network;

import awex.heroes.common.data.PlayerData;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public class MessageSyncPlayerData implements IMessage {

    private NBTTagCompound data;

    public MessageSyncPlayerData() {}

    public MessageSyncPlayerData(PlayerData playerData) {
        this.data = new NBTTagCompound();
        playerData.saveNBTData(this.data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, this.data);
    }

    // ========================================================================

    /*public static class Handler extends MessageHandler.Bidirectional<PacketSyncPlayerData> {

        @Override
        public IMessage handleClientMessage(final EntityPlayer player, final PacketSyncPlayerData msg, MessageContext ctx) {
            ClientUtils.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    PlayerData.get(player).loadNBTData(msg.data);
                }
            });
            return null;
        }

        @Override
        public IMessage handleServerMessage(final EntityPlayer player, PacketSyncPlayerData msg, MessageContext ctx) {
            ServerUtils.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    PlayerData.get(player).syncAll();
                }
            });
            return null;
        }
    }*/
}
