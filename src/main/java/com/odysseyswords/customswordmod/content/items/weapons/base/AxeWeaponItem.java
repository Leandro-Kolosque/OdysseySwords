package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public abstract class AxeWeaponItem extends AxeItem {

    protected static final float BASE_ATTACK_SPEED = -2.9F;

    protected AxeWeaponItem(Tier tier, float baseDamage, Properties properties) {
        super(tier, baseDamage, BASE_ATTACK_SPEED, properties);
    }
}
