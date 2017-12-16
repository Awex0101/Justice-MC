package awex.heroes.common.weakness;

import awex.heroes.common.damagesource.IExtendedDamage;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class WeaknessGreed extends Weakness {
    public WeaknessGreed() {
        super();
    }

    public float damageTaken(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, DamageSource source, float amount, float originalAmount) {
        amount = super.damageTaken(entity, attacker, hero, source, amount, originalAmount);
        if (IExtendedDamage.DamageType.GREED.isPresent(source)) {
            amount *= 2.3F;
        }
        return amount;
    }
}
