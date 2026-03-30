package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.core.OdysseyConstants;
import com.odysseyswords.customswordmod.gui.menus.mythic_forge.MythicForgeMenu;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, OdysseyConstants.MOD_ID);

    public static final RegistryObject<MenuType<MythicForgeMenu>> MYTHIC_FORGE=
            register("mythic_forge", MythicForgeMenu::new);

    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(
            String name,
            IContainerFactory<T> factory
    ) {
        return MENU_TYPES.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}
