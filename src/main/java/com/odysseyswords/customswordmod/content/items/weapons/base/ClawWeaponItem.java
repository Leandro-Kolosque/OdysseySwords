package com.odysseyswords.customswordmod.content.items.weapons.base;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public abstract class ClawWeaponItem extends AbstractWeaponItem {

    // UUIDs próprios (OBRIGATÓRIO em 1.20+)
    private static final UUID DAMAGE_UUID =
            UUID.fromString("9a1d6c62-3b1f-4d7a-8b3e-6b9d4e9f1a01");

    private static final UUID SPEED_UUID =
            UUID.fromString("c4b7f9c1-8f7e-4f3b-9c4a-1e6a8d3b7f02");

    private static final UUID REACH_UUID =
            UUID.fromString("f7c89d44-8e6f-4b8b-9e9b-5d7c9c1f0c22");

    // Identidade das Claws
    protected static final float BASE_ATTACK_DAMAGE = 3.0F;
    protected static final float BASE_ATTACK_SPEED = 2.8F;
    protected static final float REACH_REDUCTION = -0.75F;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    protected ClawWeaponItem(Tier tier, Properties properties) {
        super(tier, properties);

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder =
                ImmutableMultimap.builder();

        // Dano
        builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                        DAMAGE_UUID,
                        "Claw damage",
                        BASE_ATTACK_DAMAGE + tier.getAttackDamageBonus(),
                        AttributeModifier.Operation.ADDITION
                )
        );

        // Attack Speed REAL
        builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(
                        SPEED_UUID,
                        "Claw speed",
                        BASE_ATTACK_SPEED,
                        AttributeModifier.Operation.ADDITION
                )
        );

        // Alcance reduzido
        builder.put(
                ForgeMod.ENTITY_REACH.get(),
                new AttributeModifier(
                        REACH_UUID,
                        "Claw reach reduction",
                        REACH_REDUCTION,
                        AttributeModifier.Operation.ADDITION
                )
        );

        this.defaultModifiers = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier>
    getDefaultAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND
                ? defaultModifiers
                : super.getDefaultAttributeModifiers(slot);
    }
}
