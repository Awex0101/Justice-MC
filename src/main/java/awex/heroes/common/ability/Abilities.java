package awex.heroes.common.ability;

import awex.heroes.common.hero.IConstruct;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.core.registry.FiskRegistryEntry;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.hero.IAiming;
import net.minecraft.entity.EntityLivingBase;

import java.lang.reflect.Field;
import java.util.Locale;

public class Abilities extends FiskRegistryEntry<Ability> {

    public static final Ability<IConstruct> CONSTRUCT;
    public static final Ability<IAbility> WILL_IMMUNITY;
    public static final Ability<IAiming> WILL_BLAST;

    public void onUpdate(EntityLivingBase entity, Hero hero, TickEvent.Phase phase) {
    }

    static {
        CONSTRUCT = new AbilityConstruct(5);
        WILL_IMMUNITY = new AbilityWillImmunity(1);
        WILL_BLAST = new AbilityWillpowerBeam(2);

        Field[] var0 = Abilities.class.getFields();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Ability.class) {
                try {
                    Ability.register(field.getName().toLowerCase(Locale.ROOT), (Ability)field.get((Object)null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }
    }
}
