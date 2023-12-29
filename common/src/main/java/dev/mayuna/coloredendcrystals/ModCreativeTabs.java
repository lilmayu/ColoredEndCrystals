package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.CreativeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeTabRegistry.TabSupplier MAIN_TAB = CreativeTabRegistry.create(
            new ResourceLocation(ColoredEndCrystals.MOD_ID, "main"), // Tab ID
            builder -> {
                builder.icon(() -> new ItemStack(ModItems.ORANGE_END_CRYSTAL.get())); // Icon
                builder.title(Component.translatable("category.coloredendcrystals")); // Tab name
            }
    );

    /**
     * Registers the creative tabs.
     */
    public static void register() {
    }
}
