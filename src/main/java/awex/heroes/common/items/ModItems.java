package awex.heroes.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
public class ModItems {

    public static ItemArmor.ArmorMaterial LANTERN = EnumHelper.addArmorMaterial("Lantern", 20248, new int[]{12, 28, 24, 12}, 0);

    public static final CreativeTabs tabJusticeMC = new CreativeTabs("tabJusticeMC") {
        @Override
        public Item getTabIconItem() {
            return Items.emerald;
        }
    };

    public ModItems() {
    }

    public static void register() {

    }
}