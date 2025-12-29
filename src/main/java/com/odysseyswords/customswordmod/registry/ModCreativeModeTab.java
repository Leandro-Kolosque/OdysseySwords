package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.OdysseySwords;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OdysseySwords.MODID);

    public static final RegistryObject<CreativeModeTab> ODYSSEY_TAB =
            CREATIVE_MODE_TABS.register("odyssey", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("creative_tab.odysseyswords.odyssey"))
                            .icon(ModCreativeModeTab::makeIcon)
                            .displayItems(ModCreativeModeTab::fillTab)
                            .build()
            );

    private static ItemStack makeIcon() {
        return new ItemStack(ModItems.STEEL_SWORD.get());
    }

    private static void fillTab(CreativeModeTab.ItemDisplayParameters params,
                                CreativeModeTab.Output output) {

        // Itens
        ModItems.ITEMS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(output::accept);

        // Blocos
        ModBlocks.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(output::accept);
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
