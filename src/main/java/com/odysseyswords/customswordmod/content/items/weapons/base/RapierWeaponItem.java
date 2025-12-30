package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public abstract class RapierWeaponItem extends SwordItem {

    protected static final int BASE_DAMAGE = 4;
    protected static final float BASE_ATTACK_SPEED = -1.8F;

    protected RapierWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_ATTACK_SPEED, properties);
    }
}
