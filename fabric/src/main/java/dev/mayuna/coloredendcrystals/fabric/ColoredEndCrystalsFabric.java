package dev.mayuna.coloredendcrystals.fabric;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;

public class ColoredEndCrystalsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ColoredEndCrystals.init();

        UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (entity.getType() != ColoredEndCrystals.EntityTypes.COLORED_END_CRYSTAL.get()) {
                return InteractionResult.PASS;
            }

            if (player.getItemInHand(hand).getItem() != ColoredEndCrystals.Items.CRYSTAL_SCREWDRIVER.get()) {
                return InteractionResult.PASS;
            }

            var coloredEndCrystal = (ColoredEndCrystalEntity) entity;

            coloredEndCrystal.onRightClick(player.isShiftKeyDown());
            return InteractionResult.SUCCESS;
        });
    }
}