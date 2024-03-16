package dev.mayuna.coloredendcrystals;

import com.google.common.base.Suppliers;
import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ColoredEndCrystals {

    public static final String MOD_ID = "coloredendcrystals";

    public static final Supplier<RegistrarManager> REGISTRAR_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static void init() {
        ModItems.registerAll();
        ModEntityTypes.registerAll();
        ModCreativeTabs.register();
        ModMenus.registerTypes();

        ClientLifecycleEvent.CLIENT_SETUP.register(ColoredEndCrystals::onClientSetup);
    }

    private static void onClientSetup(Minecraft minecraft) {
        ModMenus.registerScreenFactories();
    }

    /**
     * Processes colored items.
     *
     * @param itemStack The item stack to process.
     * @param tintIndex The tint index to process.
     */
    public static int processRainbowEndCrystalItemTint(ItemStack itemStack, int tintIndex) {
        if (tintIndex == 0) {
            return 0xffffff; // basically transparent
        }

        return getRainbowHueBasedOnTime();
    }

    /**
     * Returns a rainbow hue based on the current time.
     *
     * @return The rainbow hue.
     */
    public static int getRainbowHueBasedOnTime() {
        var hue = (int) ((System.currentTimeMillis() / 30) % 360);
        return java.awt.Color.HSBtoRGB(hue / 360f, 0.5f, 1f);
    }
}
