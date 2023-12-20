package dev.mayuna.coloredendcrystals.fabric;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;

import java.sql.SQLOutput;

public class ColoredEndCrystalsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ColoredEndCrystals.init();

        // Register the UseEntityCallback event
        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity.getType() != ModEntityTypes.COLORED_END_CRYSTAL.get()) {
                return InteractionResult.PASS;
            }

            if (player.getItemInHand(hand).getItem() != ModItems.CRYSTAL_SCREWDRIVER.get()) {
                return InteractionResult.PASS;
            }

            var coloredEndCrystal = (ColoredEndCrystalEntity) entity;

            coloredEndCrystal.onRightClick(player.isShiftKeyDown());
            return InteractionResult.SUCCESS;
        });

        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
            return 0x1b2240;
        }, ModItems.TINTED_END_CRYSTAL.get());
    }
}