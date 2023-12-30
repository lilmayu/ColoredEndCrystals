package dev.mayuna.coloredendcrystals;

import cpw.mods.fml.common.registry.GameRegistry;
import dev.mayuna.coloredendcrystals.items.ColoredEndCrystalItem;
import dev.mayuna.coloredendcrystals.items.CrystalScrewdriverItem;
import dev.mayuna.coloredendcrystals.items.EndCrystalItem;
import net.minecraft.item.Item;

import java.util.LinkedList;
import java.util.List;

public class ModItems {

    public static Item END_CRYSTAL;

    public static Item RED_END_CRYSTAL;
    public static Item ORANGE_END_CRYSTAL;
    public static Item YELLOW_END_CRYSTAL;
    public static Item LIME_END_CRYSTAL;
    public static Item GREEN_END_CRYSTAL;
    public static Item CYAN_END_CRYSTAL;
    public static Item LIGHT_BLUE_END_CRYSTAL;
    public static Item BLUE_END_CRYSTAL;
    public static Item PURPLE_END_CRYSTAL;
    public static Item MAGENTA_END_CRYSTAL;
    public static Item PINK_END_CRYSTAL;
    public static Item BROWN_END_CRYSTAL;
    public static Item BLACK_END_CRYSTAL;
    public static Item GRAY_END_CRYSTAL;
    public static Item LIGHT_GRAY_END_CRYSTAL;
    public static Item WHITE_END_CRYSTAL;

    public static Item CRYSTAL_SCREWDRIVER;

    public static List<Item> ITEMS = new LinkedList<>();

    public static void register() {
        ITEMS.add(END_CRYSTAL = new EndCrystalItem());
        ITEMS.add(RED_END_CRYSTAL = new ColoredEndCrystalItem("red"));
        ITEMS.add(ORANGE_END_CRYSTAL = new ColoredEndCrystalItem("orange"));
        ITEMS.add(YELLOW_END_CRYSTAL = new ColoredEndCrystalItem("yellow"));
        ITEMS.add(LIME_END_CRYSTAL = new ColoredEndCrystalItem("lime"));
        ITEMS.add(GREEN_END_CRYSTAL = new ColoredEndCrystalItem("green"));
        ITEMS.add(CYAN_END_CRYSTAL = new ColoredEndCrystalItem("cyan"));
        ITEMS.add(LIGHT_BLUE_END_CRYSTAL = new ColoredEndCrystalItem("light_blue"));
        ITEMS.add(BLUE_END_CRYSTAL = new ColoredEndCrystalItem("blue"));
        ITEMS.add(PURPLE_END_CRYSTAL = new ColoredEndCrystalItem("purple"));
        ITEMS.add(MAGENTA_END_CRYSTAL = new ColoredEndCrystalItem("magenta"));
        ITEMS.add(PINK_END_CRYSTAL = new ColoredEndCrystalItem("pink"));
        ITEMS.add(BROWN_END_CRYSTAL = new ColoredEndCrystalItem("brown"));
        ITEMS.add(BLACK_END_CRYSTAL = new ColoredEndCrystalItem("black"));
        ITEMS.add(GRAY_END_CRYSTAL = new ColoredEndCrystalItem("gray"));
        ITEMS.add(LIGHT_GRAY_END_CRYSTAL = new ColoredEndCrystalItem("light_gray"));
        ITEMS.add(WHITE_END_CRYSTAL = new ColoredEndCrystalItem("white"));
        ITEMS.add(CRYSTAL_SCREWDRIVER = new CrystalScrewdriverItem());

        for (Item item : ITEMS) {
            GameRegistry.registerItem(item, item.getUnlocalizedName(), Coloredendcrystals.MODID);
        }
    }

    /**
     * Returns the end crystal item by color
     *
     * @param color The color of the end crystal
     *
     * @return The end crystal item
     */
    public static Item getEndCrystalItemByColor(String color) {
        for (Item item : ITEMS) {
            if (item instanceof ColoredEndCrystalItem) {
                ColoredEndCrystalItem coloredEndCrystalItem = (ColoredEndCrystalItem) item;

                if (coloredEndCrystalItem.getColor().equals(color)) {
                    return coloredEndCrystalItem;
                }
            }
        }

        return null;
    }
}
