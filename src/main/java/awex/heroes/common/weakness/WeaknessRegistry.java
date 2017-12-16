package awex.heroes.common.weakness;

import fiskfille.core.registry.FiskRegistryEntry;
import fiskfille.heroes.common.weakness.Weakness;

import java.lang.reflect.Field;
import java.util.Locale;

public class WeaknessRegistry extends FiskRegistryEntry<Weakness> {
    public static final Weakness RAGE;
    public static final Weakness GREED;
    public static final Weakness FEAR;
    public static final Weakness WILL;
    public static final Weakness HOPE;
    public static final Weakness COMPASSION;
    public static final Weakness LOVE;
    public static final Weakness DEATH;
    public static final Weakness LIFE;

    static {
        RAGE = new WeaknessRage();
        GREED = new WeaknessGreed();
        FEAR = new WeaknessFear();
        WILL = new WeaknessWill();
        HOPE = new WeaknessHope();
        COMPASSION = new WeaknessCompassion();
        LOVE = new WeaknessLove();
        DEATH = new WeaknessDeath();
        LIFE = new WeaknessLife();


        Field[] var0 = WeaknessRegistry.class.getFields();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Weakness.class) {
                try {
                    Weakness.register(field.getName().toLowerCase(Locale.ROOT), (Weakness) field.get((Object)null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }
    }
}
