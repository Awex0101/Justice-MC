package awex.heroes.common.data;


import awex.heroes.common.ability.Abilities;
import com.google.common.base.Predicate;
import fiskfille.heroes.common.data.SHData;
import net.minecraft.entity.Entity;

import java.lang.reflect.Field;

public class Data<T> extends SHData{
    public static final SHData<String> CONSTRUCT;
    public static final SHData<Float> CONSTRUCT_TIMER;
    public static final SHData<Boolean> CONSTRUCTING;

    protected Data(SHData.DataFactory<T> defaultVal, Predicate<Entity> p) {
        super(defaultVal, p);
    }

    protected Data(final T defaultVal, Predicate<Entity> p) {
        this(new SHData.DataFactory<T>() {
            public T construct() {
                return defaultVal;
            }
        }, p);
    }

    protected Data(SHData.DataFactory<T> defaultVal) {
        this(defaultVal, (Predicate)null);
    }

    protected Data(T defaultVal) {
        this((DataFactory<T>) defaultVal, (Predicate)null);
    }

    protected Data(Predicate<Entity> p) {
        this((DataFactory<T>) null, p);
    }

    protected Data() {
        this((Predicate<Entity>) null);
    }
    static {
        CONSTRUCT = new Data(Abilities.CONSTRUCT);
        CONSTRUCT_TIMER = (new Data(0.0F, Abilities.CONSTRUCT)).setExempt(1);
        CONSTRUCTING = (new Data(false, Abilities.CONSTRUCT)).setExempt(1);
    }
    public static void init() {
        Field[] var0 = Data.class.getFields();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Field field = var0[var2];
            if (Data.class.isAssignableFrom(field.getType())) {
                try {
                    ((Data)field.get((Object)null)).init(field, field.getName());
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }
    }
}
