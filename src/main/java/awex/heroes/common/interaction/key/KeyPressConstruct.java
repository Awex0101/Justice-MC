package awex.heroes.common.interaction.key;

import awex.heroes.JusticeMC;
import awex.heroes.common.ability.Abilities;
import awex.heroes.common.hero.IConstruct;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fiskfille.heroes.common.interaction.EnumInteraction;
import fiskfille.heroes.common.interaction.key.KeyPressBase;
import fiskfille.heroes.common.keybinds.SHKeyBinding;
import net.minecraft.entity.player.EntityPlayer;

public class KeyPressConstruct extends KeyPressBase<IConstruct> {
    public KeyPressConstruct() {
        super(Abilities.CONSTRUCT, IConstruct.class);
    }

    @SideOnly(Side.CLIENT)
    public SHKeyBinding getKey(EntityPlayer player, IConstruct hero) {
        return hero.getConstructKey();
    }

    public void receive(EntityPlayer sender, EntityPlayer clientPlayer, EnumInteraction.InteractionType type, Side side, int x, int y, int z, Integer[] args) {
        if (side.isClient()) {
            sender.openGui(JusticeMC.instance, 0, sender.getEntityWorld(), x, y, z);
        }

    }
}