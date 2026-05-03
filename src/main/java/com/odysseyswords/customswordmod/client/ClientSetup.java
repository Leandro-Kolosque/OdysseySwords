package com.odysseyswords.customswordmod.client;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.gui.screens.mythic_forge.MythicForgeScreen;
import com.odysseyswords.customswordmod.registry.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = OdysseySwords.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientSetup {

    private ClientSetup() {}

    @SubscribeEvent
    public static void onClientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(
                    ModMenuTypes.MYTHIC_FORGE.get(),
                    MythicForgeScreen::new);
        });
    }

    /**
     * Registra os renderers GeckoLib de todas as entidades do mod.
     * Adicione uma linha por mob conforme forem implementados.
     */
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Mobs hostis
        // event.registerEntityRenderer(ModEntities.ABYSSAL_KNIGHT.get(), AbyssalKnightRenderer::new);

        // Bosses
        // event.registerEntityRenderer(ModEntities.TARTARUS_GUARDIAN.get(), TartarusGuardianRenderer::new);
    }
}