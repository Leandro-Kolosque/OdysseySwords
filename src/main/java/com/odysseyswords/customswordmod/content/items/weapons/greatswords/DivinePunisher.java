package com.odysseyswords.customswordmod.content.items.weapons.greatswords;

import com.odysseyswords.customswordmod.content.items.weapons.base.GreatswordWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class DivinePunisher extends GreatswordWeaponItem{
    
    public DivinePunisher(){
        super(
            Tiers.NETHERITE,
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }
}
