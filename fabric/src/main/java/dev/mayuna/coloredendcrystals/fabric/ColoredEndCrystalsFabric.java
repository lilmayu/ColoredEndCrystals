package dev.mayuna.coloredendcrystals.fabric;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.InteractionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColoredEndCrystalsFabric implements ModInitializer {

    public static final String LAMB_DYNAMIC_LIGHTS_MOD_ID = "lambdynlights";

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

        LOGGER.info("Checking for available integrations...");
        checkForIntegrations();

        LOGGER.info("Initialized Colored End Crystals! Have fun :3");
    }

    /**
     * Checks for other mod integrations
     */
    private void checkForIntegrations() {
        if (!isModLoaded(LAMB_DYNAMIC_LIGHTS_MOD_ID)) {
            LOGGER.warn("LambDynamicLights is not loaded! Colored End Crystals will not emit light.");
        }
    }

    /**
     * Determines if a mod is loaded
     *
     * @param modId The mod ID
     *
     * @return True if the mod is loaded, false otherwise
     */
    private boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}