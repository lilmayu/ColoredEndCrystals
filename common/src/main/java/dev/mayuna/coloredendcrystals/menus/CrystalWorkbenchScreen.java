package dev.mayuna.coloredendcrystals.menus;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CrystalWorkbenchScreen extends AbstractContainerScreen<CrystalWorkbenchMenu> {

    public CrystalWorkbenchScreen(CrystalWorkbenchMenu abstractContainerMenu, Inventory inventory, Component title) {
        super(abstractContainerMenu, inventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        guiGraphics.drawString(font, "woohoooo", 0, 0, 0xFFFFFF);
    }
}
