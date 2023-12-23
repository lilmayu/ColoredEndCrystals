package dev.mayuna.coloredendcrystals.utils;

import dev.mayuna.coloredendcrystals.menus.BaseMayuScreen;

public class ScreenUtil {

    /**
     * Calculates the normal X position for a screen.
     *
     * @param mayuScreen The screen to calculate the position for.
     *
     * @return The normal X position for the screen.
     */
    public static int calculateNormalX(BaseMayuScreen<?> mayuScreen) {
        int width = mayuScreen.width;
        int backgroundWidth = mayuScreen.getImageWidth();

        return (width - backgroundWidth) / 2;
    }

    /**
     * Calculates the normal Y position for a screen.
     *
     * @param mayuScreen The screen to calculate the position for.
     *
     * @return The normal Y position for the screen.
     */
    public static int calculateNormalY(BaseMayuScreen<?> mayuScreen) {
        int height = mayuScreen.height;
        int backgroundHeight = mayuScreen.getImageHeight();

        return (height - backgroundHeight) / 2;
    }

    public static int colorAtOpacity(int opaque, float opacity) {
        if (opacity < 0.0f) {
            opacity = 0.0f;
        }
        if (opacity > 1.0f) {
            opacity = 1.0f;
        }

        int a = (int) (opacity * 255.0f);

        return (opaque & 0xFFFFFF) | (a << 24);
    }
}
