package awex.heroes.client.particle;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.heroes.client.particle.SHParticleType;
import fiskfille.heroes.helper.SHFormatHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.lang.reflect.Constructor;
import java.util.List;

public class ModParticlesClient {
    private static final ResourceLocation PARTICLE_TEXTURES = new ResourceLocation("justicemc", "textures/particle/particles.png");
    public static final int FX_LAYERS = 5;
    public static final int LAYER_SH = 4;
    @SideOnly(Side.CLIENT)
    private static Minecraft mc = Minecraft.getMinecraft();

    public ModParticlesClient() {
    }

    @SideOnly(Side.CLIENT)
    public static EntityFX spawnParticleClient(ModParticleType particleType, double x, double y, double z, double motionX, double motionY, double motionZ) {
        if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null && mc.theWorld != null && mc.theWorld.isRemote) {
            int particleSetting = mc.gameSettings.particleSetting;

            if (particleSetting == 1 && mc.theWorld.rand.nextInt(3) == 0) {
                particleSetting = 2;
            }

            double diffX = mc.renderViewEntity.posX - x;
            double diffY = mc.renderViewEntity.posY - y;
            double diffZ = mc.renderViewEntity.posZ - z;
            EntityFX particle = null;
            double maxRenderDistance = (double)Math.min(mc.gameSettings.renderDistanceChunks * 16, 64);
            if (diffX * diffX + diffY * diffY + diffZ * diffZ > maxRenderDistance * maxRenderDistance) {
                return null;
            } else if (particleSetting > 1) {
                return null;
            } else {
                try {
                    Class cl = Class.forName("awex.heroes.client.particle.Entity" + SHFormatHelper.getUnconventionalName(particleType.name()));
                    Constructor c = cl.getConstructor(World.class, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE, Double.TYPE);
                    particle = (EntityFX)c.newInstance(mc.theWorld, x, y, z, motionX, motionY, motionZ);
                    mc.effectRenderer.addEffect(particle);
                    return particle;
                } catch (Exception var26) {
                    var26.printStackTrace();
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    @SideOnly(Side.CLIENT)
    public static int getParticlesInWorld(List[] list) {
        int i = 0;

        for(int j = 0; j < list.length - 1; ++j) {
            i += list[j].size();
        }

        return i;
    }

    @SideOnly(Side.CLIENT)
    public static void bindParticleTextures(int layer) {
        if (layer == 4) {
            mc.getTextureManager().bindTexture(PARTICLE_TEXTURES);
        }

    }
}

