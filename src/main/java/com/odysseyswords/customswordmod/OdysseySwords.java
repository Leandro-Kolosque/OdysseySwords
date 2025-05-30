package com.odysseyswords.customswordmod;

import com.mojang.logging.LogUtils;
import com.odysseyswords.customswordmod.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// O MODID deve corresponder ao modid no mods.toml
@Mod(OdysseySwords.MODID)
public class OdysseySwords {
    public static final String MODID = "odysseyswords";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OdysseySwords() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Registra os itens
        ModItems.register(modEventBus);

        // Registra o método commonSetup para o carregamento do mod
        modEventBus.addListener(this::commonSetup);

        // Registra o próprio mod para eventos do servidor e outros eventos do jogo
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Código de setup comum (executado após o registro)
        LOGGER.info("OdysseySwords: Setup inicial concluído.");
    }

    // Você pode adicionar outros manipuladores de eventos aqui, se necessário
    // Exemplo:
    // @SubscribeEvent
    // public void onServerStarting(ServerStartingEvent event) {
    //     LOGGER.info("OdysseySwords: Servidor iniciando.");
    // }
}

