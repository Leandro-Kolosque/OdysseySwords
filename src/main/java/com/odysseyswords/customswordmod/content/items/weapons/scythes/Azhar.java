package com.odysseyswords.customswordmod.content.items.weapons.scythes;

import com.odysseyswords.customswordmod.content.items.weapons.base.ScytheWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class Azhar extends ScytheWeaponItem {
    
    public Azhar() {
        super(
            Tiers.NETHERITE,
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.EPIC)
        );
    }
}
