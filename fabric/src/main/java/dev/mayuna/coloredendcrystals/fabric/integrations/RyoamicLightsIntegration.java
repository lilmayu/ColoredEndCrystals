package dev.mayuna.coloredendcrystals.fabric.integrations;

import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.fabric.ColoredEndCrystalsFabric;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
/*
import org.thinkingstudio.ryoamiclights.DynamicLightSource;
import org.thinkingstudio.ryoamiclights.RyoamicLights;
import org.thinkingstudio.ryoamiclights.api.DynamicLightHandlers;
import org.thinkingstudio.ryoamiclights.fabric.api.DynamicLightsInitializer;
*/

/**
 * Integration for <a href="https://www.curseforge.com/minecraft/mc-mods/ryoamiclights">RyoamicLights</a>
 */
public final class RyoamicLightsIntegration /*implements DynamicLightsInitializer, dev.lambdaurora.lambdynlights.api.DynamicLightsInitializer*/ {

    /*
    @Override
    public void onInitializeDynamicLights() {
        ColoredEndCrystalsFabric.LOGGER.info("Ryoamic Lights are loaded!");

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
                dynamicLightSource.ryoamicLights$setDynamicLightEnabled(false);
                return;
            }

            // Tick
            dynamicLightSource.ryoamicLights$dynamicLightTick();
            if ((!RyoamicLights.get().config.getEntitiesLightSource().get() && entity.getType() != EntityType.PLAYER) || !DynamicLightHandlers.canLightUp((Entity) entity)) {
                RyoamicLights.updateTracking((DynamicLightSource) entity);
            }
        };

        // Enable dynamic lighting on the entity when it's constructed
        ColoredEndCrystalEntity.onConstructAddition = entity -> {
            // We do not want to update the entity on the server.
            if (!entity.level().isClientSide) {
                return;
            }

            DynamicLightSource dynamicLightSource = (DynamicLightSource) entity;
            dynamicLightSource.ryoamicLights$setDynamicLightEnabled(true);
        };

        // Register
        DynamicLightHandlers.registerDynamicLightHandler(ModEntityTypes.COLORED_END_CRYSTAL.get(), entity -> 15);
    }
    */
}
