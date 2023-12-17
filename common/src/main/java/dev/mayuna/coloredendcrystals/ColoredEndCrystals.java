package dev.mayuna.coloredendcrystals;

import com.google.common.base.Suppliers;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.entities.renderers.ColoredEndCrystalRenderer;
import dev.mayuna.coloredendcrystals.items.ColoredEndCrystalItem;
import dev.mayuna.coloredendcrystals.items.CrystalScrewdriverItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ColoredEndCrystals {

    public static final String MOD_ID = "coloredendcrystals";

    public static final Supplier<RegistrarManager> REGISTRAR_MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
    public static final Registrar<Item> ITEMS = REGISTRAR_MANAGER.get().get(Registries.ITEM);
    public static final Registrar<EntityType<?>> ENTITY_TYPES = REGISTRAR_MANAGER.get().get(Registries.ENTITY_TYPE);

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> MAIN_TAB = TABS.register(
            "main",
            () -> CreativeTabRegistry.create(
                    Component.translatable("category.coloredendcrystals"), // Tab Name
                    () -> new ItemStack(Items.ORANGE_END_CRYSTAL.get()) // Icon
            )
    );

    public static void init() {
        Items.doRegister();
        EntityTypes.doRegister();
        TABS.register();
    }

    public static class Items {

        public static final Map<String, RegistrySupplier<Item>> END_CRYSTAL_ITEMS = new LinkedHashMap<>();

        public static RegistrySupplier<Item> RED_END_CRYSTAL = register(IDs.RED_END_CRYSTAL, () -> new ColoredEndCrystalItem("red"));
        public static RegistrySupplier<Item> ORANGE_END_CRYSTAL = register(IDs.ORANGE_END_CRYSTAL, () -> new ColoredEndCrystalItem("orange"));
        public static RegistrySupplier<Item> YELLOW_END_CRYSTAL = register(IDs.YELLOW_END_CRYSTAL, () -> new ColoredEndCrystalItem("yellow"));
        public static RegistrySupplier<Item> LIME_END_CRYSTAL = register(IDs.LIME_END_CRYSTAL, () -> new ColoredEndCrystalItem("lime"));
        public static RegistrySupplier<Item> GREEN_END_CRYSTAL = register(IDs.GREEN_END_CRYSTAL, () -> new ColoredEndCrystalItem("green"));
        public static RegistrySupplier<Item> CYAN_END_CRYSTAL = register(IDs.CYAN_END_CRYSTAL, () -> new ColoredEndCrystalItem("cyan"));
        public static RegistrySupplier<Item> LIGHT_BLUE_END_CRYSTAL = register(IDs.LIGHT_BLUE_END_CRYSTAL, () -> new ColoredEndCrystalItem("light_blue"));
        public static RegistrySupplier<Item> BLUE_END_CRYSTAL = register(IDs.BLUE_END_CRYSTAL, () -> new ColoredEndCrystalItem("blue"));
        public static RegistrySupplier<Item> PURPLE_END_CRYSTAL = register(IDs.PURPLE_END_CRYSTAL, () -> new ColoredEndCrystalItem("purple"));
        public static RegistrySupplier<Item> MAGENTA_END_CRYSTAL = register(IDs.MAGENTA_END_CRYSTAL, () -> new ColoredEndCrystalItem("magenta"));
        public static RegistrySupplier<Item> PINK_END_CRYSTAL = register(IDs.PINK_END_CRYSTAL, () -> new ColoredEndCrystalItem("pink"));
        public static RegistrySupplier<Item> BROWN_END_CRYSTAL = register(IDs.BROWN_END_CRYSTAL, () -> new ColoredEndCrystalItem("brown"));
        public static RegistrySupplier<Item> BLACK_END_CRYSTAL = register(IDs.BLACK_END_CRYSTAL, () -> new ColoredEndCrystalItem("black"));
        public static RegistrySupplier<Item> GRAY_END_CRYSTAL = register(IDs.GRAY_END_CRYSTAL, () -> new ColoredEndCrystalItem("gray"));
        public static RegistrySupplier<Item> LIGHT_GRAY_END_CRYSTAL = register(IDs.LIGHT_GRAY_END_CRYSTAL, () -> new ColoredEndCrystalItem("light_gray"));
        public static RegistrySupplier<Item> WHITE_END_CRYSTAL = register(IDs.WHITE_END_CRYSTAL, () -> new ColoredEndCrystalItem("white"));

        public static RegistrySupplier<Item> CRYSTAL_SCREWDRIVER = register(IDs.CRYSTAL_SCREWDRIVER, CrystalScrewdriverItem::new);

        static {
            END_CRYSTAL_ITEMS.put(IDs.RED_END_CRYSTAL, RED_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.ORANGE_END_CRYSTAL, ORANGE_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.YELLOW_END_CRYSTAL, YELLOW_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.LIME_END_CRYSTAL, LIME_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.GREEN_END_CRYSTAL, GREEN_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.CYAN_END_CRYSTAL, CYAN_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.LIGHT_BLUE_END_CRYSTAL, LIGHT_BLUE_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.BLUE_END_CRYSTAL, BLUE_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.PURPLE_END_CRYSTAL, PURPLE_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.MAGENTA_END_CRYSTAL, MAGENTA_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.PINK_END_CRYSTAL, PINK_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.BROWN_END_CRYSTAL, BROWN_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.BLACK_END_CRYSTAL, BLACK_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.GRAY_END_CRYSTAL, GRAY_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.LIGHT_GRAY_END_CRYSTAL, LIGHT_GRAY_END_CRYSTAL);
            END_CRYSTAL_ITEMS.put(IDs.WHITE_END_CRYSTAL, WHITE_END_CRYSTAL);
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
            return ITEMS.register(new ResourceLocation(MOD_ID, id), supplier);
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

        public static void doRegister() {
        }
    }

    public static class EntityTypes {

        public static final RegistrySupplier<EntityType<ColoredEndCrystalEntity>> COLORED_END_CRYSTAL = createEndCrystal(IDs.COLORED_END_CRYSTAL, () ->
                EntityType.Builder.<ColoredEndCrystalEntity>of((entityType, level) -> new ColoredEndCrystalEntity(entityType, level, "red"), MobCategory.MISC)
                                  .sized(2.0F, 2.0F)
                                  .build(IDs.COLORED_END_CRYSTAL));

        public static final Map<String, RegistrySupplier<EntityType<ColoredEndCrystalEntity>>> END_CRYSTALS = new LinkedHashMap<>();

        static {
            END_CRYSTALS.put(IDs.COLORED_END_CRYSTAL, COLORED_END_CRYSTAL);
        }

        /**
         * Creates an end crystal entity type.
         *
         * @param id The id of the entity type.
         *
         * @return The entity type.
         */
        public static <T extends Entity> RegistrySupplier<EntityType<T>> createEndCrystal(String id, Supplier<EntityType<T>> supplier) {
            return ENTITY_TYPES.register(new ResourceLocation(MOD_ID, id), supplier);
        }

        public static void doRegister() {
            EntityRendererRegistry.register(COLORED_END_CRYSTAL, ColoredEndCrystalRenderer::new);
        }
    }

    public static class IDs {

        public static final String RED_END_CRYSTAL = "red_end_crystal";
        public static final String ORANGE_END_CRYSTAL = "orange_end_crystal";
        public static final String YELLOW_END_CRYSTAL = "yellow_end_crystal";
        public static final String LIME_END_CRYSTAL = "lime_end_crystal";
        public static final String GREEN_END_CRYSTAL = "green_end_crystal";
        public static final String CYAN_END_CRYSTAL = "cyan_end_crystal";
        public static final String LIGHT_BLUE_END_CRYSTAL = "light_blue_end_crystal";
        public static final String BLUE_END_CRYSTAL = "blue_end_crystal";
        public static final String PURPLE_END_CRYSTAL = "purple_end_crystal";
        public static final String MAGENTA_END_CRYSTAL = "magenta_end_crystal";
        public static final String PINK_END_CRYSTAL = "pink_end_crystal";
        public static final String BROWN_END_CRYSTAL = "brown_end_crystal";
        public static final String BLACK_END_CRYSTAL = "black_end_crystal";
        public static final String GRAY_END_CRYSTAL = "gray_end_crystal";
        public static final String LIGHT_GRAY_END_CRYSTAL = "light_gray_end_crystal";
        public static final String WHITE_END_CRYSTAL = "white_end_crystal";

        public static final String COLORED_END_CRYSTAL = "colored_end_crystal";

        public static final String CRYSTAL_SCREWDRIVER = "crystal_screwdriver";
    }
}
