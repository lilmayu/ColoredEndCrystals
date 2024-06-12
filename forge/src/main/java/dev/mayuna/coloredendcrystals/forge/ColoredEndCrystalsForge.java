package dev.mayuna.coloredendcrystals.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.forge.integrations.dynamiclights.DynamicLightsIntegration;
import dev.mayuna.coloredendcrystals.forge.integrations.lambdynamiclights.LambDynamicLightsIntegration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ColoredEndCrystals.MOD_ID)
public class ColoredEndCrystalsForge {

    public static final String DYNAMIC_LIGHTS_MOD_ID = "dynamiclights";
    public static final String LAMB_DYNAMIC_LIGHTS_MOD_ID = "dynamiclightsreforged";

    // Logger
    public static final Logger LOGGER = LogManager.getLogger(ColoredEndCrystals.MOD_ID);

    public ColoredEndCrystalsForge() {
        LOGGER.info("Hello >_<");
        LOGGER.info("Initializing Colored End Crystals...");
        EventBuses.registerModEventBus(ColoredEndCrystals.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ColoredEndCrystals.init();

        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientStart);

        LOGGER.info("Checking for available integrations...");
        checkForIntegrations();

        LOGGER.info("Initialized Colored End Crystals! Have fun :3");
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
        event.setResult(Event.Result.DEFAULT);
    }

    @SubscribeEvent
    public void onClientStart(FMLClientSetupEvent event) {
        // Late check, because we can't register the dynamic light sources before the entity is registered
        lateCheckForLambdaDynamicLights();
    }

    /**
     * Checks for other mod integrations
     */
    private void checkForIntegrations() {
        boolean someModLoaded = false;

        if (isModLoaded(DYNAMIC_LIGHTS_MOD_ID)) {
            DynamicLightsIntegration.INSTANCE.init();
            someModLoaded = true;
        }

        if (isModLoaded(LAMB_DYNAMIC_LIGHTS_MOD_ID)) {
            //LambDynamicLightsIntegration.INSTANCE.init();
            someModLoaded = true;
        }

        if (!someModLoaded) {
            LOGGER.warn("Dynamic Lights or Embeddium/Rubidium Dynamic Lights are not loaded! Colored End Crystals will not emit light.");
        }
    }

    /**
     * Late check for LambdaDynamicLights
     */
    private void lateCheckForLambdaDynamicLights() {
        if (isModLoaded(LAMB_DYNAMIC_LIGHTS_MOD_ID)) {
            LambDynamicLightsIntegration.INSTANCE.init();
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
        return ModList.get().isLoaded(modId);
    }
}