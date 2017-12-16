package awex.heroes.common.damagesource;

import fiskfille.heroes.common.damagesource.EntityDamageSourceSH;
import fiskfille.heroes.common.damagesource.IExtendedDamage;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSource;

public class ModEntityDamageSource extends EntityDamageSource implements IExtendedDamage {
    private int flags;

    public ModEntityDamageSource(String s, Entity entity) {
        super("justicemc." + s, entity);
    }

    public ModEntityDamageSource with(DamageType... types) {
        this.flags = DamageType.with(this.flags, types);
        return this;
    }

    public int getFlags() {
        return this.flags;
    }
}