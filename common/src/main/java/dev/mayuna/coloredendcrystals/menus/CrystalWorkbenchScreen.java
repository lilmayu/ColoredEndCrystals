package dev.mayuna.coloredendcrystals.menus;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.menus.other.RGBPickerWidget;
import dev.mayuna.coloredendcrystals.utils.ScreenUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CrystalWorkbenchScreen extends BaseMayuScreen<CrystalWorkbenchMenu> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ColoredEndCrystals.MOD_ID, "textures/gui/crystal_workbench.png");

    private final RGBPickerWidget rgbPickerWidget = new RGBPickerWidget(50, 50);

    public CrystalWorkbenchScreen(CrystalWorkbenchMenu abstractContainerMenu, Inventory inventory, Component title) {
        super(abstractContainerMenu, inventory, title);

        imageWidth = 176;
        imageHeight = 180;

        titleLabelX = 8;
        titleLabelY = 8;

        inventoryLabelX = 8;
        inventoryLabelY = 86;

        addRenderableWidget(rgbPickerWidget);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        super.render(guiGraphics, i, j, f);
        super.renderTooltip(guiGraphics, i, j);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        guiGraphics.blit(GUI_TEXTURE, ScreenUtil.calculateNormalX(this), ScreenUtil.calculateNormalY(this), 0, 0, imageWidth, imageHeight);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
        guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
    }
}
