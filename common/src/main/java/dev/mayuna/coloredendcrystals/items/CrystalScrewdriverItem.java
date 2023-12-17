package dev.mayuna.coloredendcrystals.items;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrystalScrewdriverItem extends Item {

    public CrystalScrewdriverItem() {
        super(new Properties().arch$tab(ModCreativeTabs.MAIN_TAB));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.coloredendcrystals.crystal_screwdriver.tooltip.right_click"));
        list.add(Component.translatable("item.coloredendcrystals.crystal_screwdriver.tooltip.shift_right_click"));
    }
}
