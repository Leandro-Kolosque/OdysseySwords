package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.Item;

public abstract class ScytheWeaponItem extends AbstractWeaponItem {

    protected ScytheWeaponItem(Properties properties, WeaponTier weaponTier) {
        super(properties, WeaponClass.SCYTHE, weaponTier);
    }
}
