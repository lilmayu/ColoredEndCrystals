package dev.mayuna.coloredendcrystals.neoforge;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.neoforge.integrations.dynamiclights.DynamicLightsIntegration;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ColoredEndCrystals.MOD_ID)
public class ColoredEndCrystalsNeoForge {

    public static final String DYNAMIC_LIGHTS_MOD_ID = "dynamiclights";

    // Logger
    public static final Logger LOGGER = LogManager.getLogger(ColoredEndCrystals.MOD_ID);

    public ColoredEndCrystalsNeoForge() {
        LOGGER.info("Hello >_<");
        LOGGER.info("Initializing Colored End Crystals...");
        ColoredEndCrystals.init();

        NeoForge.EVENT_BUS.register(this);

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
    }

    /**
     * Checks for other mod integrations
     */
    private void checkForIntegrations() {
        if (isModLoaded(DYNAMIC_LIGHTS_MOD_ID)) {
            DynamicLightsIntegration.INSTANCE.init();
        } else {
            LOGGER.warn("Dynamic Lights are not loaded! Colored End Crystals will not emit light.");
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