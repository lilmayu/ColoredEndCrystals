package dev.mayuna.coloredendcrystals;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.mayuna.coloredendcrystals.blocks.CrystalWorkbenchBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModBlocks {

    public static final Registrar<Item> ITEMS = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.ITEM);
    public static final Registrar<Block> BLOCKS = ColoredEndCrystals.REGISTRAR_MANAGER.get().get(Registries.BLOCK);

    public static RegistrySupplier<Block> CRYSTAL_WORKBENCH = registerBlock(ModIDs.CRYSTAL_WORKBENCH, CrystalWorkbenchBlock::new);

    /**
     * Registers all blocks.
     */
    public static void registerAll() {
        registerBlockItem(ModIDs.CRYSTAL_WORKBENCH, (CrystalWorkbenchBlock) CRYSTAL_WORKBENCH.get());
    }

    /**
     * Registers an block.
     *
     * @param id       The id of the item.
     * @param supplier The block supplier.
     * @param <T>      The block type.
     *
     * @return The block registry supplier.
     */
    private static <T extends Block> RegistrySupplier<T> registerBlock(String id, Supplier<T> supplier) {
        return BLOCKS.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), supplier);
    }

    private static void registerBlockItem(String id, CrystalWorkbenchBlock block) {
        ITEMS.register(new ResourceLocation(ColoredEndCrystals.MOD_ID, id), block::getBlockItem);
    }
}
