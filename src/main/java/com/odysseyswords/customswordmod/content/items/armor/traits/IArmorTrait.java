package com.odysseyswords.customswordmod.content.items.armor.traits;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public interface IArmorTrait {
    // Chamado a cada tick (se necessário)
    default void onTick(ArmorTraitContext context) {}

    // Chamado quando a entidade toma dano
    default void onHurt(ArmorTraitContext context, LivingHurtEvent event) {}

    // Chamado ao equipar o set completo (opcional)
    default void onSetEquipped(LivingEntity entity) {}
}