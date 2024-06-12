package dev.mayuna.coloredendcrystals.forge.dynamiclights;

import atomicstryker.dynamiclights.server.DynamicLights;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.forge.ColoredEndCrystalsForge;
import net.minecraftforge.fml.ModList;

/**
 * Integration of <a href="https://www.curseforge.com/minecraft/mc-mods/dynamic-lights">Dynamic Lights</a>
 */
public final class DynamicLightsIntegration {

    public static final DynamicLightsIntegration INSTANCE = new DynamicLightsIntegration();

    private boolean forcedConfigLoad = false;

    private DynamicLightsIntegration() {
    }

    /**
     * Initializes the integration
     */
    public void init() {
        ColoredEndCrystalsForge.LOGGER.info("Dynamic Lights are loaded!");

        ColoredEndCrystalEntity.onConstructAddition = entity ->{
            // Dynamic Lights are server side
            if (entity.level().isClientSide) {
                return;
            }

            if (!forcedConfigLoad) {
                ColoredEndCrystalsForge.LOGGER.info("Forcing Dynamic Lights' config to be loaded...");
                forceConfigLoad();
                forcedConfigLoad = true;
            }

            try {
                DynamicLights.addLightSource(new ColoredEndCrystalDynamicLightSource(entity));
            } catch (Exception exception) {
                ColoredEndCrystalsForge.LOGGER.error("Failed to add dynamic light source for Colored End Crystal entity!", exception);
            }
        };
    }

    /**
     * Forces Dynamic Lights' config to be loaded to prevent exceptions and crystals without light
     */
    private void forceConfigLoad() {
        try {
            var optionalModContainer = ModList.get().getModContainerById(ColoredEndCrystalsForge.DYNAMIC_LIGHTS_MOD_ID);

            if (optionalModContainer.isEmpty()) {
                ColoredEndCrystalsForge.LOGGER.error("Failed to find Dynamic Lights' mod container!");
                return;
            }

            var modContainer = optionalModContainer.get();
            var modInstance = modContainer.getMod();

            if (modInstance == null) {
                ColoredEndCrystalsForge.LOGGER.error("Failed to get Dynamic Lights' mod instance!");
                return;
            }

            var dynamicLights = (DynamicLights) modInstance;

            var initConfigMethod = dynamicLights.getClass().getDeclaredMethod("initConfig");
            initConfigMethod.setAccessible(true);

            ColoredEndCrystalsForge.LOGGER.info("Invoking Dynamic Lights' #initConfig() method...");
            initConfigMethod.invoke(dynamicLights);
        } catch (Exception exception) {
            ColoredEndCrystalsForge.LOGGER.error("Failed to force Dynamic Lights' config to be loaded!", exception);
        }
    }
}
