package dev.mayuna.coloredendcrystals.neoforge;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@Mod(ColoredEndCrystals.MOD_ID)
public class ColoredEndCrystalsNeoForge {

    public ColoredEndCrystalsNeoForge() {
        ColoredEndCrystals.init();

        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityInteractSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
        if (event.getTarget().getType() != ModEntityTypes.COLORED_END_CRYSTAL.get()) {
            return;
        }

        if (event.getItemStack().getItem() != ModItems.CRYSTAL_SCREWDRIVER.get()) {
            return;
        }

        var player = event.getEntity();
        var coloredEndCrystal = (ColoredEndCrystalEntity) event.getTarget();

        coloredEndCrystal.onRightClick(player.isShiftKeyDown());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onRegisterItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(new ItemColor() {
            @Override
            public int getColor(ItemStack arg, int i) {
                return 0x1b2240;
            }
        }, ModItems.TINTED_END_CRYSTAL.get());
    }
}