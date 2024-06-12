package dev.mayuna.coloredendcrystals.neoforge.integrations.dynamiclights;

import atomicstryker.dynamiclights.server.IDynamicLightSource;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import net.minecraft.world.entity.Entity;

public class ColoredEndCrystalDynamicLightSource implements IDynamicLightSource {

    private final ColoredEndCrystalEntity entity;

    public ColoredEndCrystalDynamicLightSource(ColoredEndCrystalEntity entity) {
        this.entity = entity;
    }

    @Override
    public Entity getAttachmentEntity() {
        return entity;
    }

    @Override
    public int getLightLevel() {
        return 10;
    }
}
