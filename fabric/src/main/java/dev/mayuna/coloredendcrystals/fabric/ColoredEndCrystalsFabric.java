package dev.mayuna.coloredendcrystals.fabric;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import net.fabricmc.api.ModInitializer;

public class ColoredEndCrystalsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ColoredEndCrystals.init();
    }
}