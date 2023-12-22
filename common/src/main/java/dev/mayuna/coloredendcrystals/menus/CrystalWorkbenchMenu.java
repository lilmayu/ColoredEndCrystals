package dev.mayuna.coloredendcrystals.menus;

import dev.mayuna.coloredendcrystals.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CrystalWorkbenchMenu extends AbstractContainerMenu {

    private final Inventory inventory;
    private final FriendlyByteBuf buf;

    public CrystalWorkbenchMenu(int i, Inventory inventory, FriendlyByteBuf buf) {
        super(ModMenus.CRYSTAL_WORKBENCH_MENU_TYPE.get(), i);
        this.inventory = inventory;
        this.buf = buf;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int syncId) {
        return ItemStack.EMPTY; // TODO idk?
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
