package awex.heroes.common.damagesource;

import net.minecraft.util.DamageSource;

public class ModDamageSource extends DamageSource implements IExtendedDamage {
    private int flags;

    public ModDamageSource(String s) {
        super("justicemc." + s);
    }

    public ModDamageSource with(DamageType... types) {
        this.flags = DamageType.with(this.flags, types);
        return this;
    }

    public int getFlags() {
        return this.flags;
    }
}