package dev.mayuna.coloredendcrystals.menus;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public abstract class BaseMayuMenu extends AbstractContainerMenu {

    protected Inventory inventory;

    protected BaseMayuMenu(@Nullable MenuType<?> menuType, Inventory inventory, int i) {
        super(menuType, i);
        this.inventory = inventory;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = getSlot(invSlot);
        if (slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < inventory.getContainerSize()) {
                if (!moveItemStackTo(originalStack, inventory.getContainerSize(), slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(originalStack, 0, inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }

    /**
     * Adds player inventory slots into current ScreenHandler
     *
     * @param inventory Player inventory
     * @param xOffset         x offset
     * @param yOffset         y offset
     */
    public void addPlayerInventorySlots(Inventory inventory, int xOffset, int yOffset) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                int x = xOffset + 8 + l * 18;
                int y = yOffset + 86 + i * 18;
                addSlot(new Slot(inventory, l + i * 9 + 9, x, y));
            }
        }
    }

    /**
     * Adds player hotbar slots into current ScreenHandler
     *
     * @param inventory Player inventory
     * @param xOffset         x offset
     * @param yOffset         y offset
     */
    public void addPlayerHotbarSlots(Inventory inventory, int xOffset, int yOffset) {
        for (int i = 0; i < 9; ++i) {
            addSlot(new Slot(inventory, i, xOffset + 8 + i * 18, 144 + yOffset));
        }
    }
}
