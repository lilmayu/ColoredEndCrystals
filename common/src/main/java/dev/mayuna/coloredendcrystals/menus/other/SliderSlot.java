package dev.mayuna.coloredendcrystals.menus.other;

import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.network.chat.Component;

public class SliderSlot extends AbstractSliderButton {

    public SliderSlot(int x, int y, int width, int height, Component component, double value) {
        super(x, y, width, height, component, value);
    }

    @Override
    protected void updateMessage() {
    }

    @Override
    protected void applyValue() {

    }

    @Override
    public boolean mouseClicked(double d, double e, int i) {
        if (!isMouseOver(d, e)) {
            return false;
        }

        return super.mouseClicked(d, e, i);
    }

    @Override
    public boolean mouseReleased(double d, double e, int i) {
        if (!isMouseOver(d, e)) {
            return false;
        }

        return super.mouseReleased(d, e, i);
    }
}
