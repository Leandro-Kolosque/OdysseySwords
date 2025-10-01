package com.odysseyswords.customswordmod.client;

import com.odysseyswords.customswordmod.screen.MythicForgeScreen;
import com.odysseyswords.customswordmod.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = com.odysseyswords.customswordmod.OdysseySwords.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(ModMenuTypes.MYTHIC_FORGE_MENU.get(), MythicForgeScreen::new);
        });
    }
}