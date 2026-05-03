package com.odysseyswords.customswordmod;

import com.mojang.logging.LogUtils;
import com.odysseyswords.customswordmod.content.entities.attributes.ModEntityAttributes;
import com.odysseyswords.customswordmod.content.recipes.ModRecipes;
import com.odysseyswords.customswordmod.registry.ModBlockEntities;
import com.odysseyswords.customswordmod.registry.ModBlocks;
import com.odysseyswords.customswordmod.registry.ModCreativeModeTab;
import com.odysseyswords.customswordmod.registry.ModEntities;
import com.odysseyswords.customswordmod.registry.ModItems;
import com.odysseyswords.customswordmod.registry.ModMenuTypes;
import com.odysseyswords.customswordmod.registry.ModSoundEvents;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import software.bernie.geckolib.GeckoLib;

// O MODID deve corresponder ao modid no mods.toml
@Mod(OdysseySwords.MODID)
public class OdysseySwords {
    public static final String MODID = "odysseyswords";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OdysseySwords() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        GeckoLib.initialize();

        // Registra os itens
        ModItems.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);

        // Registra o método commonSetup para o carregamento do mod
        modEventBus.addListener(this::commonSetup);

        // Registra o próprio mod para eventos do servidor e outros eventos do jogo
        MinecraftForge.EVENT_BUS.register(this);

        // Registra os SoundEvents
        ModSoundEvents.register(modEventBus);

        // Registra os Blocos do Mod
        ModBlockEntities.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        // Registra as Receitas do MOD
        ModRecipes.register(modEventBus);

        // Registra as Entidades
        ModEntities.register(modEventBus);
        ModEntityAttributes.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Código de setup comum (executado após o registro)
        LOGGER.info("OdysseySwords: Setup inicial concluído.");
    }
}
