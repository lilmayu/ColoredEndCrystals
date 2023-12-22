package dev.mayuna.coloredendcrystals;

import com.google.common.base.Suppliers;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class ColoredEndCrystals {

    public static final String MOD_ID = "coloredendcrystals";

    public static final Supplier<RegistrarManager> REGISTRAR_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static void init() {
        ModBlocks.registerAll();
        ModItems.registerAll();
        ModEntityTypes.registerAll();
        ModCreativeTabs.registerAll();
        ModBlockEntities.registerAll();
        ModMenus.registerTypes();

        ClientLifecycleEvent.CLIENT_SETUP.register(ColoredEndCrystals::onClientSetup);
    }

    private static void onClientSetup(Minecraft minecraft) {
        ModMenus.registerScreenFactories();
    }
}
