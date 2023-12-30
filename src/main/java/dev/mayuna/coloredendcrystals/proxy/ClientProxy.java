package dev.mayuna.coloredendcrystals.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.entities.RenderColoredEndCrystalEntity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        System.out.println("Initializing Colored End Crystal Client Proxy...");

        registerEntityRender(ColoredEndCrystalEntity.class, new RenderColoredEndCrystalEntity());
    }

    /**
     * Register the render for the entity
     *
     * @param entityClass The entity class
     * @param render      The render
     * @param <T>         The entity type
     */
    public <T extends Entity> void registerEntityRender(Class<T> entityClass, Render render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, render);
    }
}
