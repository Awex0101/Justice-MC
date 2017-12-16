package awex.heroes.common.ability;

import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;

public class AbilityWillImmunity extends Ability {
    public AbilityWillImmunity(int tier) {
        super(tier);
    }

    public boolean canTakeDamage(EntityLivingBase entity, EntityLivingBase attacker, Hero hero, IAbility instance, DamageSource source, float amount) {
        return super.canTakeDamage(entity, attacker, hero, instance, source, amount);
    }
}