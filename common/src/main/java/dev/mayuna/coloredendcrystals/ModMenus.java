package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.menu.RainbowCrystalMenu;
import dev.mayuna.coloredendcrystals.menu.RainbowCrystalScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenus {

    public static final Registrar<MenuType<?>> MENU_TYPES = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.MENU);

    /**
     * Registers the menu types.
     */
    public static void registerTypes() {
    }    public static final RegistrySupplier<MenuType<RainbowCrystalMenu>> RAINBOW_CRYSTAL_MENU = register("rainbow_crystal_menu", () -> MenuRegistry.ofExtended(RainbowCrystalMenu::new));

    /**
     * Registers the screen factories.
     */
    public static void registerScreenFactories() {
        MenuRegistry.registerScreenFactory(RAINBOW_CRYSTAL_MENU.get(), RainbowCrystalScreen::new);
    }

    /**
     * Registers a menu type.
     *
     * @param id               The id of the menu type.
     * @param menuTypeSupplier The menu type supplier.
     * @param <T>              The menu type.
     *
     * @return The registry supplier.
     */
    private static <T extends MenuType<?>> RegistrySupplier<T> register(String id, Supplier<T> menuTypeSupplier) {
        return MENU_TYPES.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), menuTypeSupplier);
    }


}
