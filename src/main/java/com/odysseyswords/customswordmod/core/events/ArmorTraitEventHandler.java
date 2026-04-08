package com.odysseyswords.customswordmod.core.events;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitContext;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitRegistry;
import com.odysseyswords.customswordmod.content.items.armor.traits.IArmorTrait;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = OdysseySwords.MODID)
public class ArmorTraitEventHandler {

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        
        // Otimização de performance
        if (entity.level().isClientSide || entity.tickCount % 20 != 0) return;

        List<IArmorTrait> activeTraits = ArmorTraitRegistry.getActiveTraits(entity);
        
        if (!activeTraits.isEmpty()) {
            ArmorTraitContext context = new ArmorTraitContext(entity, entity.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.CHEST), 0);
            activeTraits.forEach(trait -> trait.onTick(context));
        }
    }
}