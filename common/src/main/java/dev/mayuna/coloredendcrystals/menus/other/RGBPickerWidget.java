package dev.mayuna.coloredendcrystals.menus.other;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class RGBPickerWidget extends AbstractWidget {

    private static final ResourceLocation RGB_GRADIENT_TEXTURE = new ResourceLocation(ColoredEndCrystals.MOD_ID, "textures/gui/rgb_gradient.png");

    public RGBPickerWidget(int i, int j) {
        super(i, j, 55, 55, Component.empty());
    }

    @Override
    public void onClick(double mouseX, double mouseY) {
        int red = 0;
        int green = 0;
        int blue = 0;

        // calc red, green, blue based on hue

        onPress(red, green, blue);
    }

    public void onPress(int red, int green, int blue) {

    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int i, int j, float f) {
        // stretch the texture to fill the rectangle
        guiGraphics.blit(RGB_GRADIENT_TEXTURE, getX(), getY(), 0, 0, width, height);
    }

    private int getHueColor(int x, int y) {
        // Ensure x and y are within the bounds of the rectangle
        x = Math.max(0, Math.min(x, width - 1));
        y = Math.max(0, Math.min(y, height - 1));

        // Calculate the RGB values based on the position within the rectangle
        int red = (int) (255.0 * x / width);
        int green = (int) (255.0 * y / height);
        int blue = 255 - Math.min(red, green); // Example logic, you can modify as needed

        // Combine the RGB values into a single integer representing the color

        return (red << 16) | (green << 8) | blue;
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }
}
