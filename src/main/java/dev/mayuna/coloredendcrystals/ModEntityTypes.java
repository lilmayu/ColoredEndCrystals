package dev.mayuna.coloredendcrystals;

import cpw.mods.fml.common.registry.EntityRegistry;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.minecraft.entity.Entity;

public class ModEntityTypes {

    public static void register() {
        registerEntity(ColoredEndCrystalEntity.class, "colored_end_crystal");
    }

    private static <T extends Entity> void registerEntity(Class<T> entityClass, String entityName) {
        int uniqueId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, entityName, uniqueId);
        EntityRegistry.registerModEntity(entityClass, entityName, uniqueId, Coloredendcrystals.getInstance(), 64, 1, true);
    }
}
