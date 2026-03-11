package com.odysseyswords.customswordmod.content.items.weapons.hammers;

import com.odysseyswords.customswordmod.content.items.weapons.base.HammerWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class HephaestusHammer extends HammerWeaponItem{
    
    public HephaestusHammer(){
        super(
            Tiers.NETHERITE,
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.EPIC)
        );
    }
}
