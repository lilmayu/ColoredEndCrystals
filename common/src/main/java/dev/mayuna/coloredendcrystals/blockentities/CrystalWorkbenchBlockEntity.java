package dev.mayuna.coloredendcrystals.blockentities;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import dev.mayuna.coloredendcrystals.ModBlockEntities;
import dev.mayuna.coloredendcrystals.ModIDs;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CrystalWorkbenchBlockEntity extends BlockEntity implements Container {

    private @Getter NonNullList<ItemStack> machineInventory = NonNullList.withSize(7, ItemStack.EMPTY);

    public CrystalWorkbenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRYSTAL_WORKBENCH.get(), blockPos, blockState);

        init();
    }

    private void init() {
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        ContainerHelper.saveAllItems(compoundTag, machineInventory);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        ContainerHelper.loadAllItems(compoundTag, machineInventory);
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
        if (!(blockEntity instanceof CrystalWorkbenchBlockEntity crystalWorkbenchBlockEntity)) {
            return;
        }

        if (level.isClientSide) {
            return;
        }
    }

    // TODO: Contant inventory idencies

    @Override
    public int getContainerSize() {
        return machineInventory.size();
    }

    @Override
    public boolean isEmpty() {
        return machineInventory.isEmpty();
    }

    @Override
    public ItemStack getItem(int i) {
        return machineInventory.get(i);
    }

    @Override
    public ItemStack removeItem(int i, int j) {
        return ContainerHelper.removeItem(machineInventory, i, j);
    }

    @Override
    public ItemStack removeItemNoUpdate(int i) {
        var itemStack = machineInventory.get(i);
        machineInventory.set(i, ItemStack.EMPTY);
        return itemStack;
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        machineInventory.set(i, itemStack);
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        machineInventory.clear();
    }
}
