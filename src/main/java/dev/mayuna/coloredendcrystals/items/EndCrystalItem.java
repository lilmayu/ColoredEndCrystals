package dev.mayuna.coloredendcrystals.items;

import dev.mayuna.coloredendcrystals.Coloredendcrystals;
import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EndCrystalItem extends Item {

    public EndCrystalItem() {
        this.setUnlocalizedName("end_crystal");
        this.setTextureName(Coloredendcrystals.MODID + ":end_crystal");
        this.setCreativeTab(ModCreativeTabs.MAIN_TAB);
    }

    @Override
    public EnumRarity getRarity(ItemStack p_77613_1_) {
        return EnumRarity.rare;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float xFloat, float yFloat, float zFloat) {
        Block clickedBlock = world.getBlock(x, y, z);

        if (clickedBlock == null) {
            return false;
        }

        if (clickedBlock != Blocks.bedrock && clickedBlock != Blocks.obsidian) {
            // Cannot place vanilla end-crystal on anything other than bedrock or obsidian
            return false;
        }

        // Client-world check
        if (world.isRemote) {
            return true;
        }

        // -> Server-world
        Entity endCrystalEntity = new EntityEnderCrystal(world);
        // gotta set the position since the constructor with position is client-only
        endCrystalEntity.setPosition(x + 0.5, y + 1, z + 0.5);
        boolean entitySpawned = world.spawnEntityInWorld(endCrystalEntity);

        if (entitySpawned) {
            itemStack.stackSize--;
        }

        return true;
    }
}
