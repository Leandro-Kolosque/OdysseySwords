package com.odysseyswords.customswordmod.content.items.weapons.base;

import com.odysseyswords.customswordmod.api.weapon.IOdysseyWeapon;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public abstract class ScytheWeaponItem extends SwordItem implements IOdysseyWeapon{

    protected static final int BASE_DAMAGE = 7;
    protected static final float BASE_SPEED = -3.0F;

    protected ScytheWeaponItem(Tier tier, Properties properties) {
        super(tier, BASE_DAMAGE, BASE_SPEED, properties);
    }
}
