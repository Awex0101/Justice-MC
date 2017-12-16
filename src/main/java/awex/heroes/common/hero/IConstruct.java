package awex.heroes.common.hero;

import fiskfille.heroes.common.hero.IAbility;
import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;

public interface IConstruct extends IAbility
{
    @KeyBindTranslator.TranslatedKeyBind(key = "key.construct")
    SHKeyBinding getConstructKey();
}
