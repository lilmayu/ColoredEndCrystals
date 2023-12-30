package dev.mayuna.coloredendcrystals;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs {

    public static final CreativeTabs MAIN_TAB = new CreativeTabs(Coloredendcrystals.MODID + ":main") {
        @Override
        public Item getTabIconItem() {
            return ModItems.ORANGE_END_CRYSTAL;
        }
    };
}
