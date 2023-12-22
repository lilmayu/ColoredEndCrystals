package dev.mayuna.coloredendcrystals.blocks;

import dev.architectury.registry.menu.MenuRegistry;
import dev.mayuna.coloredendcrystals.ModBlockEntities;
import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import dev.mayuna.coloredendcrystals.blockentities.CrystalWorkbenchBlockEntity;
import dev.mayuna.coloredendcrystals.menus.CrystalWorkbenchMenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CrystalWorkbenchBlock extends MayuBlock implements EntityBlock {

    public CrystalWorkbenchBlock() {
        super(Block.Properties.of().strength(2.5f).sound(SoundType.GILDED_BLACKSTONE),
              new Item.Properties().arch$tab(ModCreativeTabs.MAIN_TAB)
        );
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

    @Override
    public @NotNull InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (player instanceof ServerPlayer serverPlayer) {
            BlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (blockEntity instanceof CrystalWorkbenchBlockEntity crystalWorkbenchBlockEntity) {
                MenuRegistry.openExtendedMenu(serverPlayer, new CrystalWorkbenchMenuProvider(crystalWorkbenchBlockEntity));
                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.PASS;
    }
}
