package dev.mayuna.coloredendcrystals.neoforge;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModEntityTypes;
import dev.mayuna.coloredendcrystals.ModItems;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ColoredEndCrystals.MOD_ID)
public class ColoredEndCrystalsNeoForge {

    // Logger
    public static final Logger LOGGER = LogManager.getLogger(ColoredEndCrystals.MOD_ID);

    public ColoredEndCrystalsNeoForge() {
        LOGGER.info("Hello >_<");
        LOGGER.info("Initializing Colored End Crystals...");
        ColoredEndCrystals.init();

        NeoForge.EVENT_BUS.register(this);
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
}