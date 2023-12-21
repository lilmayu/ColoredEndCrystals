package dev.mayuna.coloredendcrystals.blocks;

import dev.mayuna.coloredendcrystals.ModBlockEntities;
import dev.mayuna.coloredendcrystals.ModBlocks;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CrystalWorkbenchBlock extends Block implements EntityBlock {

    private static BlockItem blockItem = null;

    public CrystalWorkbenchBlock() {
        super(Block.Properties.of().strength(2.5f).sound(SoundType.GILDED_BLACKSTONE));
    }

    /**
     * Returns the block item for this block
     *
     * @return BlockItem
     */
    public Item getBlockItem() {
        if (blockItem != null) {
            return blockItem;
        }

        blockItem = new BlockItem(ModBlocks.CRYSTAL_WORKBENCH.get(), new Item.Properties());
        return blockItem;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CrystalWorkbenchBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return blockEntityType == ModBlockEntities.CRYSTAL_WORKBENCH.get() ? CrystalWorkbenchBlockEntity::tick : null;
    }
}
