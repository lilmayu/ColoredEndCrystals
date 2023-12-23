package dev.mayuna.coloredendcrystals.menus;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

public abstract class BaseMayuScreen<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {

    public BaseMayuScreen(T abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    /**
     * Returns the image width of the screen.
     *
     * @return the image width of the screen
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Returns the image height of the screen.
     *
     * @return the image height of the screen
     */
    public int getImageHeight() {
        return imageHeight;
    }
}
