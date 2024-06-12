package dev.mayuna.coloredendcrystals.forge.integrations.lambdynamiclights;

import dev.lambdaurora.lambdynlights.DynamicLightSource;
import dev.lambdaurora.lambdynlights.LambDynLights;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandlers;
import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import dev.lambdaurora.lambdynlights.config.DynamicLightsConfig;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.forge.ColoredEndCrystalsForge;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/**
 * Integration for <a href="https://www.curseforge.com/minecraft/mc-mods/lambdynamiclights">LambDynamicLights</a>
 */
public final class LambDynamicLightsIntegration {

    public static final LambDynamicLightsIntegration INSTANCE = new LambDynamicLightsIntegration();

    private LambDynamicLightsIntegration() {
    }

    public void init() {
        ColoredEndCrystalsForge.LOGGER.info("Embeddium/Rubidium Dynamic Lights are loaded!");

        ColoredEndCrystalsForge.LOGGER.info("Registering dynamic light handler for Colored End Crystal entity... ");
        // Gotta simulate LambDynamicLights' dynamic tick lighting, because EndCrystal overrides #tick() method
        ColoredEndCrystalEntity.onTickAddition = entity -> {
            DynamicLightSource dynamicLightSource = (DynamicLightSource) entity;

            // Don't tick on the server
            if (!entity.level().isClientSide) {
                return;
            }

            // Crystal destroyed
            if (entity.isRemoved()) {
                dynamicLightSource.tdv$setDynamicLightEnabled(false);
                return;
            }

            // Tick
            dynamicLightSource.tdv$dynamicLightTick();
            if ((!DynamicLightsConfig.EntityLighting.get() && entity.getType() != EntityType.PLAYER) || !DynamicLightHandlers.canLightUp((Entity) entity)) {
                LambDynLights.updateTracking((DynamicLightSource) entity);
            }
        };

        // Enable dynamic lighting on the entity when it's constructed
        ColoredEndCrystalEntity.onConstructAddition = entity -> {
            // We do not want to update the entity on the server.
            if (!entity.level().isClientSide) {
                return;
            }

            DynamicLightSource dynamicLightSource = (DynamicLightSource) entity;
            dynamicLightSource.tdv$setDynamicLightEnabled(true);
        };

        // Register
        DynamicLightHandlers.registerDynamicLightHandler(ModEntityTypes.COLORED_END_CRYSTAL.get(), entity -> 15);
    }
}
