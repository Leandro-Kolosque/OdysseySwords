package com.odysseyswords.customswordmod.content.items.weapons.definition;

import com.odysseyswords.customswordmod.api.weapon.IOdysseyWeapon;
import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.WeaponClass;
import com.odysseyswords.customswordmod.util.tooltip.TooltipContext;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeMod;

public class GenericWeaponItem extends SwordItem implements IOdysseyWeapon {

    private final WeaponDefinition definition;

    public GenericWeaponItem(WeaponDefinition definition) {
        super(
                definition.tier(),
                definition.weaponClass().getBaseDamage(),
                definition.weaponClass().getBaseAttackSpeed(),
                buildProperties(definition)
        );
        this.definition = definition;
    }

    private static Item.Properties buildProperties(WeaponDefinition def) {
        Item.Properties props = new Item.Properties().stacksTo(1).rarity(def.rarity());
        if (def.fireResistant()) {
            props = props.fireResistant();
        }
        return props;
    }

    // -------------------------------------------------------------------------
    // IOdysseyWeapon
    // -------------------------------------------------------------------------

    @Override
    public MaterialType getMaterialType() {
        return definition.materialType();
    }

    @Override
    public boolean useMaterialTooltip() {
        return !definition.hasCustomTooltip();
    }

    @Override
    public void appendCustomTooltip(TooltipContext context) {
        if (definition.hasCustomTooltip()) {
            context.add(definition.buildTooltipComponent());
        }
    }

    // -------------------------------------------------------------------------
    // Atributos — lidos do WeaponClass
    // -------------------------------------------------------------------------

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
        if (slot != EquipmentSlot.MAINHAND) {
            return super.getDefaultAttributeModifiers(slot);
        }

        Multimap<Attribute, AttributeModifier> base = super.getDefaultAttributeModifiers(slot);
        WeaponClass weaponClass = definition.weaponClass();

        if (!weaponClass.hasExtraAttributes()) {
            return base;
        }

        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(base);

        if (weaponClass.getKnockbackBonus() > 0) {
            builder.put(
                    Attributes.ATTACK_KNOCKBACK,
                    new AttributeModifier(
                            weaponClass.getKnockbackUUID(),
                            weaponClass.name() + " knockback bonus",
                            weaponClass.getKnockbackBonus(),
                            AttributeModifier.Operation.ADDITION
                    )
            );
        }

        if (weaponClass.getReachBonus() > 0) {
            builder.put(
                    ForgeMod.ENTITY_REACH.get(),
                    new AttributeModifier(
                            weaponClass.getReachUUID(),
                            weaponClass.name() + " reach bonus",
                            weaponClass.getReachBonus(),
                            AttributeModifier.Operation.ADDITION
                    )
            );
        }

        return builder.build();
    }
}