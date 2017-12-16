package awex.heroes.common.network;

import awex.heroes.common.data.PlayerData;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class MessageSyncPower implements IMessage {

    private int entityID;
    private int mana;

    private NBTTagCompound data;

    public MessageSyncPower () {}

    public MessageSyncPower(PlayerData playerData) {
        this.data = new NBTTagCompound();
        playerData.saveNBTData(this.data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.entityID = buf.readInt();
        this.mana = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.entityID);
        buf.writeInt(this.mana);
    }

    // ========================================================================

    /**public static class Handler extends MessageHandler.Client<PacketSyncMana> {

        @Override
        public IMessage handleClientMessage(final EntityPlayer player, final PacketSyncMana msg, MessageContext ctx) {
            ClientUtils.addScheduledTask(new Runnable() {
                @Override
                public void run() {
                    Entity thePlayer = player.worldObj.getEntityByID();
                    if (thePlayer != null && thePlayer instanceof EntityPlayer)
                        PlayerData.get((EntityPlayer) thePlayer).setMana(msg.mana);
                }
            });
            return null;
        }
    }*/
}