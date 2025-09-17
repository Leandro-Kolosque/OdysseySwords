package com.odysseyswords.customswordmod.item;

import com.odysseyswords.customswordmod.OdysseySwords;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OdysseySwords.MODID);

    public static final RegistryObject<CreativeModeTab> ODYSSEY_TAB = CREATIVE_MODE_TABS.register("odyssey_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.STEEL_SWORD.get()))
            .title(Component.translatable("itemGroup." + OdysseySwords.MODID + ".odyssey_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                ModItems.ITEMS.getEntries().stream().map(RegistryObject::get).forEach(output::accept);
            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
