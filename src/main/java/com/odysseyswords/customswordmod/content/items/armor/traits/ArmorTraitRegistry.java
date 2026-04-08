package com.odysseyswords.customswordmod.content.items.armor.traits;

import com.odysseyswords.customswordmod.content.items.armor.base.AbstractOdysseyArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;

public class ArmorTraitRegistry {

    public static List<IArmorTrait> getActiveTraits(LivingEntity entity) {

        AbstractOdysseyArmorItem reference = null;

        // Slots corretos e explícitos
        EquipmentSlot[] slots = {
                EquipmentSlot.HEAD,
                EquipmentSlot.CHEST,
                EquipmentSlot.LEGS,
                EquipmentSlot.FEET
        };

        for (EquipmentSlot slot : slots) {

            ItemStack stack = entity.getItemBySlot(slot);

            // Se qualquer peça não for do sistema → cancela tudo
            if (!(stack.getItem() instanceof AbstractOdysseyArmorItem armor)) {
                return Collections.emptyList();
            }

            if (reference == null) {
                reference = armor;
            } else if (!reference.getArmorSetId().equals(armor.getArmorSetId())) {
                return Collections.emptyList(); // Sets diferentes
            }
        }

        return reference != null
                ? reference.getDefinition().traits()
                : Collections.emptyList();
    }
}