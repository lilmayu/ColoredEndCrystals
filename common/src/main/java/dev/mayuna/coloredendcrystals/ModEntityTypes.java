package dev.mayuna.coloredendcrystals;

import dev.architectury.platform.Platform;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.utils.Env;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.entities.renderers.ColoredEndCrystalRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class ModEntityTypes {

    public static final Registrar<EntityType<?>> ENTITY_TYPES = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.ENTITY_TYPE);

    public static final RegistrySupplier<EntityType<ColoredEndCrystalEntity>> COLORED_END_CRYSTAL = createEndCrystal(ModIDs.COLORED_END_CRYSTAL, () ->
            EntityType.Builder.<ColoredEndCrystalEntity>of((entityType, level) -> new ColoredEndCrystalEntity(entityType, level, "red"), MobCategory.MISC)
                              .sized(2.0F, 2.0F)
                              .build(ModIDs.COLORED_END_CRYSTAL));

    /**
     * Creates an end crystal entity type.
     *
     * @param id The id of the entity type.
     *
     * @return The entity type.
     */
    private static <T extends Entity> RegistrySupplier<EntityType<T>> createEndCrystal(String id, Supplier<EntityType<T>> supplier) {
        return ENTITY_TYPES.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), supplier);
    }

    /**
     * Registers everything in this static class and entity renderers on the client.
     */
    public static void registerAll() {
        if (Platform.getEnvironment() == Env.CLIENT) {
            registerEntityRenderers();
        }
    }

    /**
     * Registers entity renderers
     */
    private static void registerEntityRenderers() {
        EntityRendererRegistry.register(COLORED_END_CRYSTAL, ColoredEndCrystalRenderer::new);
    }
}
