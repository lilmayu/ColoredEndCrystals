package dev.mayuna.coloredendcrystals.menu;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.utils.ScreenUtil;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class RainbowCrystalScreen extends BaseMayuScreen<RainbowCrystalMenu> {

    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ColoredEndCrystals.MOD_ID, "textures/gui/rainbow_crystal_menu.png");

    //private final RGBPickerWidget rgbPickerWidget = new RGBPickerWidget(50, 50);
    private final Button doneButton = Button.builder(Component.literal("Done"), this::btnDoneClicked).build();
    private Checkbox checkbox;

    public void btnDoneClicked(Button button) {
        // TODO: Apply color to crystal
        System.out.println("Done button clicked!");
    }

    private void checkboxRainbowValueChanged(Checkbox checkbox, boolean flag) {
        System.out.println("Rainbow checkbox value changed to " + flag);
    }

    public RainbowCrystalScreen(RainbowCrystalMenu abstractContainerMenu, Inventory inventory, Component title) {
        super(abstractContainerMenu, inventory, title);

        imageWidth = 106;
        imageHeight = 81;

        titleLabelX = 14;
        titleLabelY = 6;

        inventoryLabelX = 8;
        inventoryLabelY = 86;

        addRenderableWidget(doneButton);
    }

    @Override
    protected void init() {
        super.init();

        checkbox = Checkbox.builder(Component.literal("Rainbow"), this.font).onValueChange(this::checkboxRainbowValueChanged).build();
        addRenderableWidget(checkbox);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        doneButton.setPosition(ScreenUtil.calculateNormalX(this) + 69, ScreenUtil.calculateNormalY(this) + 58);
        doneButton.setSize(32, 18);

        checkbox.setPosition(ScreenUtil.calculateNormalX(this) + 5, ScreenUtil.calculateNormalY(this) + 58);
        checkbox.setSize(16, 16);
        checkbox.setMessage(Component.literal("Rainbow").withColor(checkbox.selected() ? ColoredEndCrystals.getRainbowHueBasedOnTime() : 4210752));

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
    }
}
