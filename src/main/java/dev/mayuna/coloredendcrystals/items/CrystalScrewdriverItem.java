package dev.mayuna.coloredendcrystals.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dev.mayuna.coloredendcrystals.Coloredendcrystals;
import dev.mayuna.coloredendcrystals.ModCreativeTabs;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class CrystalScrewdriverItem extends Item {

    public CrystalScrewdriverItem() {
        this.setUnlocalizedName("crystal_screwdriver");
        this.setTextureName(Coloredendcrystals.MODID + ":crystal_screwdriver");
        this.setCreativeTab(ModCreativeTabs.MAIN_TAB);
        this.setFull3D();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List lines, boolean par4) {
        lines.add("§6Right click§7 to toggle crystal pedestal");
    }
}
