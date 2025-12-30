package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public abstract class ScytheWeaponItem extends SwordItem {

    protected static final int BASE_DAMAGE = 7;
    protected static final float BASE_SPEED = -3.0F;

    protected ScytheWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_SPEED, properties);
    }
}
