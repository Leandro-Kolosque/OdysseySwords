package com.odysseyswords.customswordmod.content.items.weapons.swords;

import com.odysseyswords.customswordmod.content.items.weapons.base.SwordWeaponItem;
import com.odysseyswords.customswordmod.content.items.weapons.base.WeaponTier;
import net.minecraft.world.item.Tiers;

public class SteelSword extends SwordWeaponItem {

    public SteelSword(Properties properties) {
        super(
            properties,
            new WeaponTier(Tiers.IRON, 3.0f, -2.4f)
        );
    }
}
