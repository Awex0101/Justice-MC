package awex.heroes.common.interaction.key;

import fiskfille.heroes.common.interaction.Interaction;

public enum EnumInteraction {
    KEY_CONSTRUCT(KeyPressConstruct.class);

    public final Interaction listener;

    EnumInteraction(Class<? extends Interaction> type) {
        try {
            this.listener = type.newInstance();
        } catch (Exception var5) {
            throw new RuntimeException(String.format("An exception was caught attempting to instantiate listener for EnumInteraction %s:", this.toString()), var5);
        }
    }
}