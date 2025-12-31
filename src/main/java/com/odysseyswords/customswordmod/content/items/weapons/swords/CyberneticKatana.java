package com.odysseyswords.customswordmod.content.items.weapons.swords;

import com.odysseyswords.customswordmod.content.items.weapons.base.SwordWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class CyberneticKatana extends SwordWeaponItem {

    public CyberneticKatana(){
        super(
            Tiers.NETHERITE,
                new Item.Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(net.minecraft.world.item.Rarity.RARE));
    }
}
