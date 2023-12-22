package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(ColoredEndCrystals.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register(
            "main",
            () -> CreativeTabRegistry.create(
                    Component.translatable("category.coloredendcrystals"),
                    () -> new ItemStack(ModItems.ORANGE_END_CRYSTAL.get())
            )
    );

    /**
     * Registers the creative tabs.
     */
    public static void registerAll() {
        TABS.register();
    }
}
