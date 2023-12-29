package dev.mayuna.coloredendcrystals.menus;

import dev.mayuna.coloredendcrystals.ModMenus;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.Slot;

public class CrystalWorkbenchMenu extends BaseMayuMenu {

    public static final int SLOT_RED_DYE_INDEX = 0;
    public static final int SLOT_GREEN_DYE_INDEX = 1;
    public static final int SLOT_BLUE_DYE_INDEX = 2;
    public static final int SLOT_BLACK_DYE_INDEX = 3;
    public static final int SLOT_WHITE_DYE_INDEX = 4;
    public static final int SLOT_GUNPOWDER_INDEX = 5;
    public static final int SLOT_OUTPUT_INDEX = 6;

    private final CrystalWorkbenchBlockEntity blockEntity;

    public CrystalWorkbenchMenu(int i, Inventory inventory, FriendlyByteBuf buf) {
        super(ModMenus.CRYSTAL_WORKBENCH_MENU_TYPE.get(), inventory, i);
        this.blockEntity = (CrystalWorkbenchBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos());

        addSlot(new Slot(blockEntity, SLOT_RED_DYE_INDEX, 8, 20));
        addSlot(new Slot(blockEntity, SLOT_GREEN_DYE_INDEX, 28, 20));
        addSlot(new Slot(blockEntity, SLOT_BLUE_DYE_INDEX, 48, 20));
        addSlot(new Slot(blockEntity, SLOT_BLACK_DYE_INDEX, 71, 20));
        addSlot(new Slot(blockEntity, SLOT_WHITE_DYE_INDEX, 91, 20));
        addSlot(new Slot(blockEntity, SLOT_GUNPOWDER_INDEX, 152, 20));
        addSlot(new Slot(blockEntity, SLOT_OUTPUT_INDEX, 142, 60));

        addPlayerInventorySlots(inventory, 0, 12);
        addPlayerHotbarSlots(inventory, 0, 12);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
