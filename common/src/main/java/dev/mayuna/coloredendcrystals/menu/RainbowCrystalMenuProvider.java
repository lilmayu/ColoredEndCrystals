package dev.mayuna.coloredendcrystals.menu;

import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import io.netty.buffer.ByteBufAllocator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import org.jetbrains.annotations.Nullable;

public class RainbowCrystalMenuProvider implements ExtendedMenuProvider {

    private ColoredEndCrystalEntity entity;

    public RainbowCrystalMenuProvider(ColoredEndCrystalEntity entity) {
        this.entity = entity;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Rainbow Crystal");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        var buf = new FriendlyByteBuf(ByteBufAllocator.DEFAULT.buffer());
        saveExtraData(buf);
        return new RainbowCrystalMenu(syncId, inventory, new FriendlyByteBuf(buf));
    }

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeInt(entity.getId());
    }
}
