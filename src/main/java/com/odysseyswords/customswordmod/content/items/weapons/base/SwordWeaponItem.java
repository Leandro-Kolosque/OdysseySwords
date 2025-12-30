package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public abstract class SwordWeaponItem extends SwordItem {

    protected static final int BASE_DAMAGE = 5;
    protected static final float BASE_SPEED = -2.3F;

    protected SwordWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_SPEED, properties);
    }
}
