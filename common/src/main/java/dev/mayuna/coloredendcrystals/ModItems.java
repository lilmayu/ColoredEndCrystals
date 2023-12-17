package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.items.ColoredEndCrystalItem;
import dev.mayuna.coloredendcrystals.items.CrystalScrewdriverItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModItems {

    public static final Registrar<Item> ITEMS = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.ITEM);

    // Maps of items
    public static final Map<String, RegistrySupplier<Item>> END_CRYSTAL_ITEMS = new LinkedHashMap<>();

    public static RegistrySupplier<Item> RED_END_CRYSTAL = register(ModIDs.RED_END_CRYSTAL, () -> new ColoredEndCrystalItem("red"));
    public static RegistrySupplier<Item> ORANGE_END_CRYSTAL = register(ModIDs.ORANGE_END_CRYSTAL, () -> new ColoredEndCrystalItem("orange"));
    public static RegistrySupplier<Item> YELLOW_END_CRYSTAL = register(ModIDs.YELLOW_END_CRYSTAL, () -> new ColoredEndCrystalItem("yellow"));
    public static RegistrySupplier<Item> LIME_END_CRYSTAL = register(ModIDs.LIME_END_CRYSTAL, () -> new ColoredEndCrystalItem("lime"));
    public static RegistrySupplier<Item> GREEN_END_CRYSTAL = register(ModIDs.GREEN_END_CRYSTAL, () -> new ColoredEndCrystalItem("green"));
    public static RegistrySupplier<Item> CYAN_END_CRYSTAL = register(ModIDs.CYAN_END_CRYSTAL, () -> new ColoredEndCrystalItem("cyan"));
    public static RegistrySupplier<Item> LIGHT_BLUE_END_CRYSTAL = register(ModIDs.LIGHT_BLUE_END_CRYSTAL, () -> new ColoredEndCrystalItem("light_blue"));
    public static RegistrySupplier<Item> BLUE_END_CRYSTAL = register(ModIDs.BLUE_END_CRYSTAL, () -> new ColoredEndCrystalItem("blue"));
    public static RegistrySupplier<Item> PURPLE_END_CRYSTAL = register(ModIDs.PURPLE_END_CRYSTAL, () -> new ColoredEndCrystalItem("purple"));
    public static RegistrySupplier<Item> MAGENTA_END_CRYSTAL = register(ModIDs.MAGENTA_END_CRYSTAL, () -> new ColoredEndCrystalItem("magenta"));
    public static RegistrySupplier<Item> PINK_END_CRYSTAL = register(ModIDs.PINK_END_CRYSTAL, () -> new ColoredEndCrystalItem("pink"));
    public static RegistrySupplier<Item> BROWN_END_CRYSTAL = register(ModIDs.BROWN_END_CRYSTAL, () -> new ColoredEndCrystalItem("brown"));
    public static RegistrySupplier<Item> BLACK_END_CRYSTAL = register(ModIDs.BLACK_END_CRYSTAL, () -> new ColoredEndCrystalItem("black"));
    public static RegistrySupplier<Item> GRAY_END_CRYSTAL = register(ModIDs.GRAY_END_CRYSTAL, () -> new ColoredEndCrystalItem("gray"));
    public static RegistrySupplier<Item> LIGHT_GRAY_END_CRYSTAL = register(ModIDs.LIGHT_GRAY_END_CRYSTAL, () -> new ColoredEndCrystalItem("light_gray"));
    public static RegistrySupplier<Item> WHITE_END_CRYSTAL = register(ModIDs.WHITE_END_CRYSTAL, () -> new ColoredEndCrystalItem("white"));

    public static RegistrySupplier<Item> CRYSTAL_SCREWDRIVER = register(ModIDs.CRYSTAL_SCREWDRIVER, CrystalScrewdriverItem::new);

    static {
        END_CRYSTAL_ITEMS.put(ModIDs.RED_END_CRYSTAL, RED_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.ORANGE_END_CRYSTAL, ORANGE_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.YELLOW_END_CRYSTAL, YELLOW_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.LIME_END_CRYSTAL, LIME_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.GREEN_END_CRYSTAL, GREEN_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.CYAN_END_CRYSTAL, CYAN_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.LIGHT_BLUE_END_CRYSTAL, LIGHT_BLUE_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.BLUE_END_CRYSTAL, BLUE_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.PURPLE_END_CRYSTAL, PURPLE_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.MAGENTA_END_CRYSTAL, MAGENTA_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.PINK_END_CRYSTAL, PINK_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.BROWN_END_CRYSTAL, BROWN_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.BLACK_END_CRYSTAL, BLACK_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.GRAY_END_CRYSTAL, GRAY_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.LIGHT_GRAY_END_CRYSTAL, LIGHT_GRAY_END_CRYSTAL);
        END_CRYSTAL_ITEMS.put(ModIDs.WHITE_END_CRYSTAL, WHITE_END_CRYSTAL);
    }

    /**
     * Registers items
     */
    public static void registerAll() {
    }

    /**
     * Registers an item.
     *
     * @param id       The id of the item.
     * @param supplier The item supplier.
     * @param <T>      The item type.
     *
     * @return The item registry supplier.
     */
    private static <T extends Item> RegistrySupplier<T> register(String id, Supplier<T> supplier) {
        return ITEMS.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), supplier);
    }

    /**
     * Gets the end crystal item for the given entity.
     *
     * @param color The color of the end crystal.
     *
     * @return The end crystal item.
     */
    public static Item getEndCrystalItemByColor(String color) {
        return END_CRYSTAL_ITEMS.get(color + "_end_crystal").get();
    }
}
