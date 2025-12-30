package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public abstract class GreatswordWeaponItem extends SwordItem {

    protected static final int BASE_DAMAGE = 7;
    protected static final float BASE_ATTACK_SPEED = -2.8F;

    protected GreatswordWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_ATTACK_SPEED, properties);
    }
}
