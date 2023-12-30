package dev.mayuna.coloredendcrystals;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dev.mayuna.coloredendcrystals.entities.ColoredEndCrystalEntity;
import dev.mayuna.coloredendcrystals.proxy.IProxy;
import lombok.Getter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityInteractEvent;

@Mod(modid = Coloredendcrystals.MODID, version = Coloredendcrystals.VERSION)
public class Coloredendcrystals {

    public static final String MODID = "coloredendcrystals";
    public static final String VERSION = "@VERSION@";
    public static final String CLIENT_PROXY_CLASS = "dev.mayuna.coloredendcrystals.proxy.ClientProxy";

    private static @Getter Coloredendcrystals instance;

    @SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = "dev.mayuna.coloredendcrystals.proxy.CommonProxy")
    private static IProxy clientProxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;

        System.out.println("Hello >_<");
        System.out.println("Initializing Colored End Crystals...");

        ModItems.register();
        ModEntityTypes.register();
        ModRecipes.register();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onEntityInteractEvent(EntityInteractEvent event) {
        if (!(event.target instanceof ColoredEndCrystalEntity)) {
            return;
        }

        EntityPlayer player = event.entityPlayer;

        ItemStack heldItem = player.getHeldItem();

        if (heldItem == null) {
            return;
        }

        if (heldItem.getItem() != ModItems.CRYSTAL_SCREWDRIVER) {
            return;
        }

        ColoredEndCrystalEntity coloredEndCrystal = (ColoredEndCrystalEntity) event.target;
        coloredEndCrystal.onRightClick(player.isSneaking());
    }
}