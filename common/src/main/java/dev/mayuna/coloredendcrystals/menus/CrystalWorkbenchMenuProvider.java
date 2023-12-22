package dev.mayuna.coloredendcrystals.menus;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.architectury.registry.menu.MenuRegistry;
import dev.mayuna.coloredendcrystals.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class CrystalWorkbenchMenuProvider implements ExtendedMenuProvider {

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeByte(0xF);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Testing display name");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return ModMenus.CRYSTAL_WORKBENCH_MENU_TYPE.get().create(syncId, inventory);
    }
}
