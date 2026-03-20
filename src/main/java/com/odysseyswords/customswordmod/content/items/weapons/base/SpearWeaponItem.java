package com.odysseyswords.customswordmod.content.items.weapons.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.odysseyswords.customswordmod.api.weapon.IOdysseyWeapon;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public abstract class SpearWeaponItem extends SwordItem implements IOdysseyWeapon{

    protected static final int BASE_DAMAGE = 6;
    protected static final float BASE_ATTACK_SPEED = -2.6F;
    protected static final double EXTRA_REACH = 1.5D;

    private static final UUID ENTITY_REACH_UUID =
        UUID.fromString("c1c7b2a3-5f41-4e61-9e89-9d3b4e2f0001");

    protected SpearWeaponItem(Tier tier, Properties properties) {
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
            ForgeMod.ENTITY_REACH.get(),
            new AttributeModifier(
                ENTITY_REACH_UUID,
                "Spear reach bonus",
                EXTRA_REACH,
                AttributeModifier.Operation.ADDITION
            )
        );

        return builder.build();
    }
}
