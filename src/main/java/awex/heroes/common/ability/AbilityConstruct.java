package awex.heroes.common.ability;

import awex.heroes.common.data.Data;
import awex.heroes.common.hero.IConstruct;
import awex.heroes.helper.ModHelper;
import cpw.mods.fml.common.gameevent.TickEvent;
import fiskfille.heroes.common.ability.Ability;
import fiskfille.heroes.common.hero.Hero;
import net.minecraft.entity.EntityLivingBase;

public class AbilityConstruct extends Ability<IConstruct> {
    public AbilityConstruct(int tier) {
        super(tier);
    }

    public void onUpdate(EntityLivingBase entity, Hero hero, IConstruct instance, TickEvent.Phase phase) {
        if (phase == TickEvent.Phase.END) {
            ModHelper.incr(Data.CONSTRUCT_TIMER, entity, 50, Data.CONSTRUCTING.get(entity));
            if (Data.CONSTRUCT.get(entity) != null && !Data.CONSTRUCT.get(entity).isEmpty()) {
                Data.CONSTRUCT.setWithoutNotify(entity, (String) null);
            }
        }
    }
}