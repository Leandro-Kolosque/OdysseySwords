package com.odysseyswords.customswordmod.content.items.weapons.base;

import com.odysseyswords.customswordmod.api.weapon.IOdysseyWeapon;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

public abstract class AxeWeaponItem extends AxeItem implements IOdysseyWeapon{

    protected static final float BASE_ATTACK_SPEED = -2.9F;

    protected AxeWeaponItem(Tier tier, float baseDamage, Properties properties) {
        super(tier, baseDamage, BASE_ATTACK_SPEED, properties);
    }
}
