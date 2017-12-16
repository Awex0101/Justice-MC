package awex.heroes.client.particle;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import fiskfille.heroes.client.particle.SHParticleType;
import fiskfille.heroes.client.particle.SHParticlesClient;

public class ModParticles {
    public ModParticles() {
    }

    public static void spawnParticle(ModParticleType particleType, double x, double y, double z, double motionX, double motionY, double motionZ) {
        Side side = FMLCommonHandler.instance().getSide();
        if (side.isClient()) {
            ModParticlesClient.spawnParticleClient(particleType, x, y, z, motionX, motionY, motionZ);
        }
    }
}
