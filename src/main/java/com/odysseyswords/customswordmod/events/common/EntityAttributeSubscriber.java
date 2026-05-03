package com.odysseyswords.customswordmod.events.common;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.registry.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OdysseySwords.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class EntityAttributeSubscriber {

    private EntityAttributeSubscriber() {}

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        // Mobs hostis
        // event.put(ModEntities.ABYSSAL_KNIGHT.get(), AbyssalKnightEntity.createAttributes().build());

        // Bosses
        // event.put(ModEntities.TARTARUS_GUARDIAN.get(), TartarusGuardianEntity.createAttributes().build());
    }
}