package awex.heroes.common.damagesource;

import net.minecraft.entity.Entity;

public class DamageSource {

    public DamageSource() {
    }

    public static net.minecraft.util.DamageSource causeRageDamage(Entity entity) {
        return (new ModEntityDamageSource("rage", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeGreedDamage(Entity entity) {
        return (new ModEntityDamageSource("greed", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeFearDamage(Entity entity) {
        return (new ModEntityDamageSource("fear", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeWillDamage(Entity entity) {
        return (new ModEntityDamageSource("will", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeHopeDamage(Entity entity) {
        return (new ModEntityDamageSource("hope", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeCompassionDamage(Entity entity) {
        return (new ModEntityDamageSource("compassion", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeLoveDamage(Entity entity) {
        return (new ModEntityDamageSource("love", entity)).setProjectile();
    }
    public static net.minecraft.util.DamageSource causeDeathDamage(Entity entity) {
        return (new ModEntityDamageSource("death", entity)).setMagicDamage().setProjectile();
    }
    public static net.minecraft.util.DamageSource causeLifeDamage(Entity entity) {
        return (new ModEntityDamageSource("life", entity)).setMagicDamage().setProjectile();
    }

    static {
    }
}
