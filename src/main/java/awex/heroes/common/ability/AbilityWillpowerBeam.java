package awex.heroes.common.ability;

import awex.heroes.client.particle.ModParticleType;
import awex.heroes.client.particle.ModParticles;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.helper.FiskServerUtils;
import fiskfille.core.helper.VectorHelper;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.damagesource.ModDamageSources;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

public class AbilityWillpowerBeam extends Ability<IAiming> {
    AbilityWillpowerBeam(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IAiming instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END && SHData.AIMING.get(entity)) {
            double range = 10.0D;
            MovingObjectPosition rayTrace = SHHelper.rayTrace(entity, range, 6, 1.0F);
            double d0;
            if (rayTrace != null) {
                if (rayTrace.entityHit != null) {
                    d0 = entity.posX - rayTrace.entityHit.posX;

                    double d1;
                    for(d1 = entity.posZ - rayTrace.entityHit.posZ; d0 * d0 + d1 * d1 < 1.0E-4D; d1 = (Math.random() - Math.random()) * 0.01D) {
                        d0 = (Math.random() - Math.random()) * 0.01D;
                    }

                    if (rayTrace.entityHit.attackEntityFrom(ModDamageSources.causeBurnDamage(entity), 5.0F)) {
                        if (rayTrace.entityHit instanceof EntityLivingBase) {
                            ((EntityLivingBase)rayTrace.entityHit).knockBack(rayTrace.entityHit, 0.0F, d0 * 50.0D, d1 * 50.0D);
                        }
                    }
                }
            }

            if (entity.worldObj.isRemote) {
                d0 = rayTrace != null && rayTrace.hitInfo instanceof Double ? (Double) rayTrace.hitInfo : range;
                float aiming = SHData.AIMING_TIMER.get(entity);
                float spread = 0.4F * aiming;
                float motion = 0.05F * aiming;
                Vec3 src = VectorHelper.getOffsetCoords(entity, -0.375D, -0.2D, 0.6D);
                Vec3 dest = VectorHelper.getOffsetCoords(entity, 0.0D, 0.0D, d0);
                d0 = src.distanceTo(dest);

                for(double point = 0.0D; point <= d0; point += 0.15D) {
                    Vec3 vec3 = VectorHelper.interpolate(dest, src, point);
                    ModParticles.spawnParticle(ModParticleType.WILL, vec3.xCoord + (Math.random() - 0.4D) * (double)spread, vec3.yCoord + (Math.random() - 0.4D) * (double)spread, vec3.zCoord + (Math.random() - 0.4D) * (double)spread, (Math.random() - 0.4D) * (double)motion, (Math.random() - 0.5D) * (double)motion, (Math.random() - 0.5D) * (double)motion);
                }

            }
        }

    }

    public float damageDealt(EntityLivingBase entity, EntityLivingBase target, Hero hero, IAiming instance, DamageSource source, float amount, float originalAmount) {
        if (FiskServerUtils.isMeleeDamage(source)) {
            target.addPotionEffect((new PotionEffect(Potion.weakness.getId(), 30, 2)));
        }

        return super.damageDealt(entity, target, hero, instance, source, amount, originalAmount);
    }
}
