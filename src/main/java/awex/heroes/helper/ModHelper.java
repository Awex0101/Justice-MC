package awex.heroes.helper;

import awex.heroes.common.data.Data;
import fiskfille.heroes.common.data.SHData;
import fiskfille.heroes.helper.SHHelper;
import net.minecraft.entity.Entity;

public class ModHelper extends SHHelper{
    public ModHelper() {
    }

    public static void incr(SHData<Float> data, Entity entity, int ticks, boolean incr, boolean decr) {
        if (incr && data.get(entity) < 1.0F) {
            data.incrWithoutNotify(entity, 1.0F / (float)ticks);
        } else if (decr && data.get(entity) > 0.0F) {
            data.incrWithoutNotify(entity, -1.0F / (float)ticks);
        }

        data.clampWithoutNotify(entity, 0.0F, 1.0F);
    }

    public static void incr(Data<Float> data, Entity entity, int ticks, boolean condition) {
        incr(data, entity, ticks, condition, !condition);
    }
}

