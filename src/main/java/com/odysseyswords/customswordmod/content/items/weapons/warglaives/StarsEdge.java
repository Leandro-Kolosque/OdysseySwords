package com.odysseyswords.customswordmod.content.items.weapons.warglaives;

import com.odysseyswords.customswordmod.content.items.weapons.base.WarglaiveWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class StarsEdge extends WarglaiveWeaponItem {
    
    public StarsEdge(){
        super(
            Tiers.NETHERITE,
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }
}
