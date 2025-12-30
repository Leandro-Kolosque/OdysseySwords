package com.odysseyswords.customswordmod.content.items.weapons.axes;

import com.odysseyswords.customswordmod.content.items.weapons.base.AxeWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class IceWhisper extends AxeWeaponItem {
    
    public IceWhisper(){
        super(
            Tiers.DIAMOND,
            7.0F,
            new Item.Properties()
                .stacksTo(1)
                .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }
}
