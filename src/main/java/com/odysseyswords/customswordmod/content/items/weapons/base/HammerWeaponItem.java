package com.odysseyswords.customswordmod.content.items.weapons.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.odysseyswords.customswordmod.api.weapon.IOdysseyWeapon;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

import java.util.UUID;

public abstract class HammerWeaponItem extends SwordItem implements IOdysseyWeapon{

    protected static final int BASE_DAMAGE = 9;
    protected static final float BASE_ATTACK_SPEED = -3.2F;
    protected static final double EXTRA_KNOCKBACK = 1.5D;

    private static final UUID KNOCKBACK_UUID =
        UUID.fromString("8e88a5c3-3f6a-4d72-b5a0-9c7e6e0c0001");

    protected HammerWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_ATTACK_SPEED, properties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        Multimap<Attribute, AttributeModifier> base =
            super.getDefaultAttributeModifiers(slot);

        if (slot != EquipmentSlot.MAINHAND) {
            return base;
        }

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder =
            ImmutableMultimap.builder();

        builder.putAll(base);

        builder.put(
            Attributes.ATTACK_KNOCKBACK,
            new AttributeModifier(
                KNOCKBACK_UUID,
                "Hammer knockback bonus",
                EXTRA_KNOCKBACK,
                AttributeModifier.Operation.ADDITION
            )
        );

        return builder.build();
    }
}
