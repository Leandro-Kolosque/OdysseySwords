package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.Tier;

public abstract class ClawWeaponItem extends AbstractWeaponItem {

    protected static final float BASE_ATTACK_SPEED = -1.6F;

    protected ClawWeaponItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    /**
     * Hooks futuros:
     * - bleed
     * - combo
     * - dash
     */
}

