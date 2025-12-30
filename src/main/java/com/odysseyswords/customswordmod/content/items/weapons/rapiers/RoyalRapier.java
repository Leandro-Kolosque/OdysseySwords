package com.odysseyswords.customswordmod.content.items.weapons.rapiers;

import com.odysseyswords.customswordmod.content.items.weapons.base.RapierWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class RoyalRapier extends RapierWeaponItem {

    public RoyalRapier() {
        super(
            Tiers.NETHERITE,
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }
}

