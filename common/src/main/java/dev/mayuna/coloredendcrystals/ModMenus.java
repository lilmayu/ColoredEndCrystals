package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.menus.CrystalWorkbenchMenu;
import dev.mayuna.coloredendcrystals.menus.CrystalWorkbenchScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;

import java.util.function.Supplier;

public class ModMenus {

    public static final Registrar<MenuType<?>> MENU_TYPES = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.MENU);

    public static final RegistrySupplier<MenuType<CrystalWorkbenchMenu>> CRYSTAL_WORKBENCH_MENU_TYPE = register("crystal_workbench", () -> MenuRegistry.ofExtended(CrystalWorkbenchMenu::new));

    public static void registerTypes() {
    }

    public static void registerScreenFactories() {
        MenuRegistry.registerScreenFactory(CRYSTAL_WORKBENCH_MENU_TYPE.get(), CrystalWorkbenchScreen::new);
    }

    private static <T extends MenuType<?>> RegistrySupplier<T> register(String id, Supplier<T> menuTypeSupplier) {
        return MENU_TYPES.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), menuTypeSupplier);
    }
}
