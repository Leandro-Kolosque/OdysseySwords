package com.odysseyswords.customswordmod.content.items.weapons.definition;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.WeaponClass;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

import javax.annotation.Nullable;

public record WeaponDefinition(
        WeaponClass weaponClass,
        Tier tier,
        MaterialType materialType,
        Rarity rarity,
        boolean fireResistant,
        @Nullable String tooltipKey,
        @Nullable ChatFormatting[] tooltipStyle
) {

    // -------------------------------------------------------------------------
    // Builder
    // -------------------------------------------------------------------------

    public static Builder of(WeaponClass weaponClass, Tier tier, MaterialType materialType) {
        return new Builder(weaponClass, tier, materialType);
    }

    public static class Builder {

        private final WeaponClass weaponClass;
        private final Tier tier;
        private final MaterialType materialType;
        private Rarity rarity = Rarity.UNCOMMON;
        private boolean fireResistant = false;
        private String tooltipKey = null;
        private ChatFormatting[] tooltipStyle = { ChatFormatting.YELLOW, ChatFormatting.ITALIC };

        private Builder(WeaponClass weaponClass, Tier tier, MaterialType materialType) {
            this.weaponClass = weaponClass;
            this.tier = tier;
            this.materialType = materialType;
        }

        public Builder rarity(Rarity rarity) {
            this.rarity = rarity;
            return this;
        }

        public Builder fireResistant() {
            this.fireResistant = true;
            return this;
        }

        public Builder tooltip(String tooltipKey) {
            this.tooltipKey = tooltipKey;
            return this;
        }

        public Builder tooltip(String tooltipKey, ChatFormatting... style) {
            this.tooltipKey = tooltipKey;
            this.tooltipStyle = style;
            return this;
        }

        public WeaponDefinition build() {
            return new WeaponDefinition(
                    weaponClass, tier, materialType,
                    rarity, fireResistant, tooltipKey, tooltipStyle
            );
        }
    }

    // -------------------------------------------------------------------------
    // Helpers usados pelo GenericWeaponItem
    // -------------------------------------------------------------------------

    public boolean hasCustomTooltip() {
        return tooltipKey != null;
    }

    public Component buildTooltipComponent() {
        return Component.translatable(tooltipKey).withStyle(tooltipStyle);
    }
}