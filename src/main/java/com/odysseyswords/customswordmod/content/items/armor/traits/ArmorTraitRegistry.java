package com.odysseyswords.customswordmod.content.items.armor.traits;

import com.odysseyswords.customswordmod.content.items.armor.base.AbstractOdysseyArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ArmorTraitRegistry {

    private static final EquipmentSlot[] ARMOR_SLOTS = {
            EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS,
            EquipmentSlot.FEET
    };

    /**
     * Varre os 4 slots de armadura da entidade e retorna uma peça de referência
     * apenas se as 4 pertencerem ao sistema OdysseySwords E ao mesmo conjunto
     * (mesmo armorSetId). Caso contrário, retorna Optional vazio.
     */
    public static Optional<AbstractOdysseyArmorItem> getEquippedSetReference(LivingEntity entity) {

        AbstractOdysseyArmorItem reference = null;

        for (EquipmentSlot slot : ARMOR_SLOTS) {

            ItemStack stack = entity.getItemBySlot(slot);

            // Se qualquer peça não for do sistema → cancela tudo
            if (!(stack.getItem() instanceof AbstractOdysseyArmorItem armor)) {
                return Optional.empty();
            }

            if (reference == null) {
                reference = armor;
            } else if (!reference.getArmorSetId().equals(armor.getArmorSetId())) {
                return Optional.empty(); // Sets diferentes
            }
        }

        return Optional.ofNullable(reference);
    }

    public static List<IArmorTrait> getActiveTraits(LivingEntity entity) {
        return getEquippedSetReference(entity)
                .map(reference -> reference.getDefinition().traits())
                .orElse(Collections.emptyList());
    }
}