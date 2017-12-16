package awex.heroes.common.network;

import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fiskfille.core.network.FiskNetworkHelper;

public class NetworkHandler extends FiskNetworkHelper{
    public static SimpleNetworkWrapper wrapper;

    public NetworkHandler(){

    }
    public static void registerPackets() {
        wrapper = FiskNetworkHelper.getWrapper("justicemc");
        registerMessage(MessageGiveTool.class, Side.SERVER);
    }
}
