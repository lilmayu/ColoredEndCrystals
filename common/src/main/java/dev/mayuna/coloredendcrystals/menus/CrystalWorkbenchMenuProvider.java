package dev.mayuna.coloredendcrystals.menus;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import io.netty.buffer.ByteBufAllocator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class CrystalWorkbenchMenuProvider implements ExtendedMenuProvider {

    private final CrystalWorkbenchBlockEntity blockEntity;

    public CrystalWorkbenchMenuProvider(CrystalWorkbenchBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
    }

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeBlockPos(blockEntity.getBlockPos());
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("item.coloredendcrystals.crystal_workbench");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        var buf = new FriendlyByteBuf(ByteBufAllocator.DEFAULT.buffer());
        saveExtraData(buf);
        return new CrystalWorkbenchMenu(syncId, inventory, buf);
    }
}
