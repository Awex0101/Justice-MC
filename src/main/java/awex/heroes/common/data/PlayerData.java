package awex.heroes.common.data;

import awex.heroes.JusticeMC;
import awex.heroes.common.network.MessageSyncPlayerData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerData implements IExtendedEntityProperties{
    private static final String identifier = "justicemcPlayerData";

    private final EntityPlayer player;

    private double will;

    public PlayerData(EntityPlayer player) {
        this.player = player;
        this.will = 40;
    }

    public static PlayerData get(EntityPlayer player) {
        return (PlayerData) player.getExtendedProperties(identifier);
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(identifier, new PlayerData(player));
    }

    public boolean isServerSide() {
        return this.player instanceof EntityPlayerMP;
    }

    @Override
    public void saveNBTData(NBTTagCompound nbt) {
        nbt.setDouble("will", this.getWill());
    }

    @Override
    public void loadNBTData(NBTTagCompound nbt) {
        if (nbt.hasKey("will", 3))
            this.setWill(nbt.getInteger("will"));
    }

    @Override
    public void init(net.minecraft.entity.Entity entity, World world) {

    }

    public void setWill(double will) {
        this.will = will;
        this.syncWill();
    }

    public double getWill() {
        return this.will;
    }

    public void syncWill() {
        //if (this.isServerSide())
            //JusticeMC.NETWORK.sendTo(new MessageSyncPower(this.getWill()), (EntityPlayerMP) this.player);
    }

    public void saveReviveRelevantNBTData(NBTTagCompound nbt, boolean wasDeath) {
        if (!wasDeath)
            this.saveNBTData(nbt);
    }

    public void syncAll() {
        if (this.isServerSide())
            JusticeMC.NETWORK.sendTo(new MessageSyncPlayerData(this), (EntityPlayerMP) this.player);
    }

    public void requestSyncAll() {
        if (!this.isServerSide())
            JusticeMC.NETWORK.sendToServer(new MessageSyncPlayerData());
    }
}
