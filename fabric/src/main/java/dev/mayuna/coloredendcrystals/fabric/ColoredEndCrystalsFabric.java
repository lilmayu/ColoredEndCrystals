package dev.mayuna.coloredendcrystals.fabric;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.world.InteractionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColoredEndCrystalsFabric implements ModInitializer {

    // Logger
    public static final Logger LOGGER = LoggerFactory.getLogger(ColoredEndCrystals.MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello >_<");
        LOGGER.info("Initializing Colored End Crystals...");
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

        LOGGER.info("Initialized Colored End Crystals! Have fun :3");
    }
}