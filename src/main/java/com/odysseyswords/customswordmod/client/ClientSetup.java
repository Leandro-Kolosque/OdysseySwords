package com.odysseyswords.customswordmod.client;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.gui.screens.MythicForgeScreen;
import com.odysseyswords.customswordmod.registry.ModMenuTypes;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(
        modid = OdysseySwords.MODID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public final class ClientSetup {

    private ClientSetup() {
        // Evita instanciação
    }

    /**
     * Client setup geral (GUI, telas, etc.)
     */
    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(
                    ModMenuTypes.MYTHIC_FORGE.get(),
                    MythicForgeScreen::new
            );
        });
    }
}
