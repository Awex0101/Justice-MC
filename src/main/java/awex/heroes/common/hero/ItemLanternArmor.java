package awex.heroes.common.hero;

import awex.heroes.common.items.ModItems;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.core.book.widget.IItemListEntry;
import fiskfille.heroes.FiskHeroes;
import fiskfille.heroes.client.model.ModelBipedMultiLayer;
import fiskfille.heroes.client.render.hero.HeroRenderer;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.entity.attribute.ArmorAttribute;
import fiskfille.heroes.common.entity.attribute.IAttributeContainer;
import fiskfille.heroes.common.hero.Hero;
import fiskfille.heroes.common.item.IDualItem;
import fiskfille.heroes.common.item.ITachyonCharged;
import fiskfille.heroes.common.item.ItemTachyonDevice;
import fiskfille.heroes.common.item.armor.ItemHeroArmor;
import fiskfille.heroes.common.registry.ItemRegistry;
import fiskfille.heroes.common.weakness.Weakness;
import fiskfille.heroes.helper.SHHelper;
import mods.battlegear2.api.core.IBattlePlayer;
import mods.battlegear2.api.core.InventoryPlayerBattle;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.ISpecialArmor;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class ItemLanternArmor extends ItemHeroArmor {
    public ItemLanternArmor(Hero hero, ArmorType type) {
        super(hero, type);
        this.setCreativeTab(ModItems.tabJusticeMC);
    }
}