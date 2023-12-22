package dev.mayuna.coloredendcrystals.blocks;

import dev.mayuna.coloredendcrystals.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public abstract class MayuBlock extends Block {

    private final Item.Properties blockItemProperties;
    private BlockItem blockItem = null;

    public MayuBlock(Properties properties, Item.Properties blockItemProperties) {
        super(properties);
        this.blockItemProperties = blockItemProperties;
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

        blockItem = new BlockItem(this, blockItemProperties);
        return blockItem;
    }
}
