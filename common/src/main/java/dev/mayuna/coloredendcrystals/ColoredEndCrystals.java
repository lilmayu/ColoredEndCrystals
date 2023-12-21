package dev.mayuna.coloredendcrystals;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.RegistrarManager;

import java.util.function.Supplier;

public class ColoredEndCrystals {

    public static final String MOD_ID = "coloredendcrystals";

    public static final Supplier<RegistrarManager> REGISTRAR_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static void init() {
        ModBlocks.registerAll();
        ModItems.registerAll();
        ModBlockEntities.registerAll();
        ModEntityTypes.registerAll();
        ModCreativeTabs.register();
    }
}
