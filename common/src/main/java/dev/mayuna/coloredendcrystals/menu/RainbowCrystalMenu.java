package dev.mayuna.coloredendcrystals.menu;

import dev.mayuna.coloredendcrystals.ModMenus;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;

public class RainbowCrystalMenu extends BaseMayuMenu {

    private final int entityId;

    public RainbowCrystalMenu(int syncId, Inventory inventory, FriendlyByteBuf buf) {
        super(ModMenus.RAINBOW_CRYSTAL_MENU.get(), inventory, syncId);
        entityId = buf.readInt();
    }
}
