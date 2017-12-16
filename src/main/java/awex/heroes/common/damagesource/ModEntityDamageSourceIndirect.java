package awex.heroes.common.damagesource;

import fiskfille.heroes.common.damagesource.EntityDamageSourceIndirectSH;
import fiskfille.heroes.common.damagesource.IExtendedDamage;
import net.minecraft.entity.Entity;
import net.minecraft.util.EntityDamageSourceIndirect;

public class ModEntityDamageSourceIndirect extends EntityDamageSourceIndirect implements IExtendedDamage {
    private int flags;

    public ModEntityDamageSourceIndirect(String s, Entity entity, Entity indirectEntity) {
        super("justicemc." + s, entity, indirectEntity);
    }

    public ModEntityDamageSourceIndirect with(DamageType... types) {
        this.flags = DamageType.with(this.flags, types);
        return this;
    }

    public int getFlags() {
        return this.flags;
    }
}
