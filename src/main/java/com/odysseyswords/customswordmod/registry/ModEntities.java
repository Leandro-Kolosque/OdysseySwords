package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.entities.projectile.ChakramEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OdysseySwords.MODID);

    public static final RegistryObject<EntityType<ChakramEntity>> CHAKRAM =
            ENTITIES.register(
                    "chakram",
                    () -> EntityType.Builder.<ChakramEntity>of(
                                    ChakramEntity::new,
                                    MobCategory.MISC
                            )
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(10)
                            .build("chakram")
            );

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
