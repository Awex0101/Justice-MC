package awex.heroes.client.particle;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.World;

public class EntityWill extends EntityFX {
    public EntityWill(World world, double x, double y, double z, double motionX, double motionY, double motionZ) {
        super(world, x, y, z, motionX, motionY, motionZ);
        this.motionX = this.motionX * 0.009999999776482582D + motionX;
        this.motionY = this.motionY * 0.009999999776482582D + motionY;
        this.motionZ = this.motionZ * 0.009999999776482582D + motionZ;
        this.particleRed = 0.1F;
        this.particleBlue = 0.2F;
        this.particleGreen = 0.8F;
        this.particleMaxAge = 140;
        this.noClip = false;
        this.setParticleTextureIndex(1);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    public void renderParticle(Tessellator tesselator, float partialTicks, float f, float f1, float f2, float f3, float f4) {
        float f5 = (float)(this.particleAge >= this.particleMaxAge - 10 ? this.particleMaxAge - this.particleAge : 10) / 10.0F;
        this.particleScale = 3.0F * f5;
        super.renderParticle(tesselator, partialTicks, f, f1, f2, f3, f4);
    }

    public int getBrightnessForRender(float partialTicks) {
        return 15728880;
    }

    public float getBrightness(float partialTicks) {
        return 1.0F;
    }
}
