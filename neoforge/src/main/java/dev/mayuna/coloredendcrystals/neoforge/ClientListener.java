package dev.mayuna.coloredendcrystals.neoforge;

import dev.mayuna.coloredendcrystals.ColoredEndCrystals;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = ColoredEndCrystals.MOD_ID)
public class ClientListener {

    @SubscribeEvent
    public static void onClientStart(FMLClientSetupEvent event) {
        // DynamicLightsInitializerEvent does not work
        // Late check, because we can't register the dynamic light sources before the entity is registered
        ColoredEndCrystalsNeoForge.lateCheckForRyoamicLights();
    }
}
