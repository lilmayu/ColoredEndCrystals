package dev.mayuna.coloredendcrystals.fabric.integrations;

import dev.lambdaurora.lambdynlights.DynamicLightSource;
import dev.lambdaurora.lambdynlights.LambDynLights;
import dev.lambdaurora.lambdynlights.api.DynamicLightHandlers;
import dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.fabric.ColoredEndCrystalsFabric;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/**
 * Integration for <a href="https://www.curseforge.com/minecraft/mc-mods/lambdynamiclights">LambDynamicLights</a>
 */
public final class LambDynamicLightsIntegration implements DynamicLightsInitializer {

    @Override
    public void onInitializeDynamicLights() {
        ColoredEndCrystalsFabric.LOGGER.info("LambDynamicLights is loaded!");

        ColoredEndCrystalsFabric.LOGGER.info("Registering dynamic light handler for Colored End Crystal entity... ");
        // Gotta simulate LambDynamicLights' dynamic tick lighting, because EndCrystal overrides #tick() method
        ColoredEndCrystalEntity.onTickAddition = entity -> {
            DynamicLightSource dynamicLightSource = (DynamicLightSource) entity;

            // Don't tick on the server
            if (!entity.level().isClientSide) {
                return;
            }

            // Crystal destroyed
            if (entity.isRemoved()) {
                dynamicLightSource.setDynamicLightEnabled(false);
                return;
            }

            // Tick
            dynamicLightSource.dynamicLightTick();
            if ((!LambDynLights.get().config.getEntitiesLightSource().get() && entity.getType() != EntityType.PLAYER) || !DynamicLightHandlers.canLightUp((Entity) entity)) {
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
            dynamicLightSource.setDynamicLightEnabled(true);
        };

        // Register
        DynamicLightHandlers.registerDynamicLightHandler(ModEntityTypes.COLORED_END_CRYSTAL.get(), entity -> 15);
    }
}
