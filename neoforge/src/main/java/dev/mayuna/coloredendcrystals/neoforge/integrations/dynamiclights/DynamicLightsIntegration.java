package dev.mayuna.coloredendcrystals.neoforge.integrations.dynamiclights;

import atomicstryker.dynamiclights.server.DynamicLights;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.neoforge.ColoredEndCrystalsNeoForge;

/**
 * Integration of <a href="https://www.curseforge.com/minecraft/mc-mods/dynamic-lights">Dynamic Lights</a>
 */
public final class DynamicLightsIntegration {

    public static final DynamicLightsIntegration INSTANCE = new DynamicLightsIntegration();

    private DynamicLightsIntegration() {
    }

    /**
     * Initializes the integration
     */
    public void init() {
        ColoredEndCrystalsNeoForge.LOGGER.info("Dynamic Lights are loaded!");

        ColoredEndCrystalEntity.onConstructAddition = entity ->{
            // Dynamic Lights are server side
            if (entity.level().isClientSide) {
                return;
            }

            try {
                DynamicLights.addLightSource(new ColoredEndCrystalDynamicLightSource(entity));
            } catch (Exception exception) {
                ColoredEndCrystalsNeoForge.LOGGER.error("Failed to add dynamic light source for Colored End Crystal entity!", exception);
            }
        };
    }
}
