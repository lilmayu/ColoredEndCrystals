package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final Registrar<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.BLOCK_ENTITY_TYPE);

    public static final RegistrySupplier<BlockEntityType<CrystalWorkbenchBlockEntity>> CRYSTAL_WORKBENCH = register("crystal_workbench", BlockEntityType.Builder.of(CrystalWorkbenchBlockEntity::new, ModBlocks.CRYSTAL_WORKBENCH.get()).build(null));

    /**
     * Registers all block entities.
     */
    public static void registerAll() {
    }

    private static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String id, BlockEntityType<T> blockEntityType) {
        return BLOCK_ENTITY_TYPES.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), () -> blockEntityType);
    }
}
