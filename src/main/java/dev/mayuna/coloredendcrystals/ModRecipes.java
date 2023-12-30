package dev.mayuna.coloredendcrystals;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {

    public static void register() {
        registerShaped();
        registerShapeless();
    }

    private static void registerShaped() {
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.CRYSTAL_SCREWDRIVER, 1),
                                     "  I",
                                     " G ",
                                     "S  ",
                                     'I', Items.iron_ingot,
                                     'G', Items.ghast_tear,
                                     'S', Items.stick
        );

        GameRegistry.addShapedRecipe(new ItemStack(ModItems.END_CRYSTAL, 1),
                                     "GGG",
                                     "GEG",
                                     "GTG",
                                     'G', Blocks.glass,
                                     'E', Items.ender_eye,
                                     'T', Items.ghast_tear
        );
    }

    private static void registerShapeless() {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BLACK_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.RED_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.GREEN_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BROWN_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.BLUE_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PURPLE_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.CYAN_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 6));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LIGHT_GRAY_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 7));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.GRAY_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 8));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.PINK_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 9));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LIME_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 10));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.YELLOW_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 11));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LIGHT_BLUE_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 12));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.MAGENTA_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 13));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ORANGE_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 14));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.WHITE_END_CRYSTAL, 1), ModItems.END_CRYSTAL, new ItemStack(Items.dye, 1, 15));
    }
}
