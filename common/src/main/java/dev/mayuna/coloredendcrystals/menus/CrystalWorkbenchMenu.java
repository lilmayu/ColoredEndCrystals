package dev.mayuna.coloredendcrystals.menus;

import dev.mayuna.coloredendcrystals.ModMenus;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;

public class CrystalWorkbenchMenu extends BaseMayuMenu {

    private final CrystalWorkbenchBlockEntity blockEntity;

    public CrystalWorkbenchMenu(int i, Inventory inventory, FriendlyByteBuf buf) {
        super(ModMenus.CRYSTAL_WORKBENCH_MENU_TYPE.get(), inventory, i);
        this.blockEntity = (CrystalWorkbenchBlockEntity) inventory.player.level().getBlockEntity(buf.readBlockPos());

        addSlot(new Slot(blockEntity, 0, 80, 35));
        addPlayerInventorySlots(inventory, 0, 12);
        addPlayerHotbarSlots(inventory, 0, 12);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
