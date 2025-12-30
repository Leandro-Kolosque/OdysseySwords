package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.AxeItem;

public abstract class AxeWeaponItem extends AxeItem {

    protected final WeaponTier weaponTier;

    protected AxeWeaponItem(Properties properties, WeaponTier weaponTier) {
        super(
            weaponTier.tier(),
            weaponTier.damageBonus(),
            weaponTier.attackSpeed(),
            properties
        );
        this.weaponTier = weaponTier;
    }
}
