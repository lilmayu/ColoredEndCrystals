package dev.mayuna.coloredendcrystals.items;

import dev.mayuna.coloredendcrystals.Coloredendcrystals;
import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import lombok.Getter;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class ColoredEndCrystalItem extends EndCrystalItem {

    private final @Getter String color;

    public ColoredEndCrystalItem(String color) {
        this.color = color;

        this.setUnlocalizedName(color + "_end_crystal");
        this.setTextureName(Coloredendcrystals.MODID + ":" + color + "_end_crystal");
        this.setCreativeTab(ModCreativeTabs.MAIN_TAB);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.rare;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean par4) {
        lines.add("§6Right click§7 to place the crystal");
        lines.add("§7By breaking the crystal, you can get it back");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat) {
        // Client-world check
        if (world.isRemote) {
            return true;
        }

        // -> Server-world
        ColoredEndCrystalEntity endCrystalEntity = new ColoredEndCrystalEntity(world);
        // gotta set the position since the constructor with position is client-only
        endCrystalEntity.setPosition(x + 0.5, y + 1, z + 0.5);
        endCrystalEntity.setColor(this.color);
        boolean entitySpawned = world.spawnEntityInWorld(endCrystalEntity);

        if (entitySpawned) {
            itemStack.stackSize--;
        }

        return true;
    }
}
