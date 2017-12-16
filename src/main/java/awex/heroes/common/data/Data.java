package awex.heroes.common.data;

import awex.heroes.common.ability.Abilities;
import com.google.common.base.Predicate;
import fiskfille.core.registry.FiskRegistryNamespaced;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.data.SHData;
import net.minecraft.entity.Entity;

import java.lang.reflect.Field;

public class Data<T> extends SHData{
    public static final FiskRegistryNamespaced<SHData<?>> REGISTRY = new FiskRegistryNamespaced("justicemc", (String)null);

    //
    public static final SHData<String> CONSTRUCT;
    public static final SHData<Float> CONSTRUCT_TIMER;
    public static final SHData<Boolean> CONSTRUCTING;
    //
    final DataFactory<T> defaultValue;


    protected Data(DataFactory<T> defaultVal, Predicate<Entity> p)
    {
        defaultValue = defaultVal;
    }

    protected Data(final T defaultVal, Predicate<Entity> p)
    {
        this(new DataFactory<T>()
        {
            @Override
            public T construct()
            {
                return defaultVal;
            }
        }, p);
    }

    protected Data(DataFactory<T> defaultVal)
    {
        this(defaultVal, null);
    }

    protected Data(T defaultVal)
    {
        this(defaultVal, null);
    }

    protected Data(Predicate<Entity> p)
    {
        this((T) null, p);
    }

    protected Data()
    {
        this((T) null);
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
