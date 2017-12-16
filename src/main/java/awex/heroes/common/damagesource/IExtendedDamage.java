package awex.heroes.common.damagesource;

import net.minecraft.util.DamageSource;

public interface IExtendedDamage {

    int getFlags();

     enum DamageType {
        RAGE,
        GREED,
        FEAR,
        WILL,
        HOPE,
        COMPASSION,
        LOVE,
        DEATH,
        LIFE;

        DamageType() {
        }

        public int getFlag() {
            return 1 << this.ordinal();
        }

        public boolean isPresent(DamageSource source) {
            return source instanceof IExtendedDamage && (((IExtendedDamage)source).getFlags() & this.getFlag()) == this.getFlag();
        }

        public static int with(int flags, DamageType... types) {
            DamageType[] var2 = types;
            int var3 = types.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                DamageType type = var2[var4];
                flags |= type.getFlag();
            }

            return flags;
        }
    }
}
