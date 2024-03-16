package dev.mayuna.coloredendcrystals.items;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RainbowColoredEndCrystalItem extends ColoredEndCrystalItem {

    public RainbowColoredEndCrystalItem(String color) {
        super(color);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(Component.translatable("item.coloredendcrystals.colored_end_crystal.tooltip.right_click"));
        list.add(Component.translatable("item.coloredendcrystals.colored_end_crystal.tooltip.rainbow"));
        list.add(Component.translatable("item.coloredendcrystals.colored_end_crystal.tooltip.break"));
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return super.getName(itemStack).copy().withColor(ColoredEndCrystals.getRainbowHueBasedOnTime());
    }
}
