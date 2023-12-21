package dev.mayuna.coloredendcrystals.blockentities;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModBlockEntities;
import dev.mayuna.coloredendcrystals.ModIDs;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

public class CrystalWorkbenchBlockEntity extends BlockEntity {

    public CrystalWorkbenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRYSTAL_WORKBENCH.get(), blockPos, blockState);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
        if (!(blockEntity instanceof CrystalWorkbenchBlockEntity crystalWorkbenchBlockEntity)) {
            return;
        }

        if (level.isClientSide) {
            return;
        }

        System.out.println("tick");
    }
}
