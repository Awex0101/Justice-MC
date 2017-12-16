package awex.heroes.common.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class MessageGiveTool implements IMessageHandler<MessageGiveTool, IMessage>, IMessage {
    private int playerID;
    private int dimension;
    private int time = 0;

    public MessageGiveTool(){}

    public MessageGiveTool(byte id)
    {

    }

    public MessageGiveTool(EntityPlayer player)
    {
        this.dimension = player.worldObj.provider.dimensionId;
        this.playerID = player.getEntityId();
    }

    public void toBytes(ByteBuf buffer)
    {
        buffer.writeInt(this.dimension);
        buffer.writeInt(this.playerID);
    }

    public void fromBytes(ByteBuf buffer)
    {
        this.dimension = buffer.readInt();
        this.playerID = buffer.readInt();
    }

    public IMessage onMessage(MessageGiveTool message, MessageContext ctx)
    {
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;

        World world = DimensionManager.getWorld(this.dimension);
        if (world == null) {
            return null;
        }
        if(player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
            player.inventory.addItemStackToInventory(new ItemStack(Items.diamond_axe, 1));
        }
        return null;
    }
}
