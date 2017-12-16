package awex.heroes.common.hero;

import awex.heroes.common.ability.Abilities;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.ability.IAbilityContainer;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.entity.attribute.SHAttributes;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.hero.IAiming;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.keybinds.KeyBindTranslator;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import fiskfille.heroes.common.keybinds.SHKeyBinds;
import fiskfille.heroes.common.weakness.Weakness;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class HeroHalJordan extends Hero implements IConstruct, IAiming {
    public HeroHalJordan() {
    }

    public void init() {
        this.helmet = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.HEAD);
        this.chestplate = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.TORSO);
        this.leggings = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.LEGS);
        this.boots = new ItemLanternArmor(this, ItemHeroArmor.ArmorType.BOOTS);
    }

    public int getTier() {
        return 5;
    }

    public ItemHeroArmor.ArmorVersion getVersion() {
        return ItemHeroArmor.ArmorVersion.DCTV;
    }

    public float getDefaultScale(EntityPlayer player) {
        return 1.1F;
    }

    @KeyBindTranslator.TranslatedKeyBind(
            key = "key.shoot"
    )

    public boolean canAim(EntityPlayer player, ItemStack heldItem) {
        return heldItem == null;
    }

    public SHKeyBinding getConstructKey() {
        return SHKeyBinds.ABILITY_1;
    }

    public SHKeyBinding getAimKey() {
        return SHKeyBinds.ABILITY_2;
    }

    public boolean hasProperty(EntityLivingBase entity, Property property) {
        switch(property) {
            case BREATHE_UNDERWATER:
                return true;
            case BREATHE_SPACE:
                return true;
            default:
                return super.hasProperty(entity, property);
        }
    }
    public void getAbilities(IAbilityContainer abilities) {
        abilities.add(this, Abilities.CONSTRUCT);
        abilities.add(this, Abilities.WILL_BLAST);
        abilities.add(this, Ability.FLIGHT);
        abilities.add(this, Ability.FIRE_IMMUNITY);
        abilities.add(this, Ability.COLD_RESISTANCE);
        abilities.add(this, Abilities.WILL_IMMUNITY);
    }

    public void getAttributeModifiers(IAttributeContainer attributes, ItemStack itemstack) {
        super.getAttributeModifiers(attributes, itemstack);
        attributes.add(SHAttributes.PUNCH_DAMAGE, 1.0D, 0);
        attributes.add(SHAttributes.SWORD_DAMAGE, 4.0D, 0);
        attributes.add(SHAttributes.ATTACK_DAMAGE, 2.0D, 1);
    }
}
