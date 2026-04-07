package com.odysseyswords.customswordmod.content.items.armor.traits;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 * Carrega os dados necessários para um efeito de armadura acontecer.
 */
public record ArmorTraitContext(LivingEntity entity, ItemStack stack, int slotIndex) {}