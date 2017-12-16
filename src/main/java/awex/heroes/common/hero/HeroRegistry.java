package awex.heroes.common.hero;

import fiskfille.heroes.common.hero.Hero;

import java.lang.reflect.Field;
import java.util.Locale;

public class HeroRegistry {
    public static final Hero HAL_JORDAN = new HeroHalJordan();

    public static void register() {
        Field[] var0 = HeroRegistry.class.getFields();
        int var1 = var0.length;

        for (int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (field.getType() == Hero.class) {
                try {
                    Hero.register(field.getName().toLowerCase(Locale.ROOT), (Hero) field.get((Object) null));
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }
    }
}
