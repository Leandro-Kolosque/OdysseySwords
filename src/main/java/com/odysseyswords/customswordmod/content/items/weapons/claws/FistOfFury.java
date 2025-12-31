package com.odysseyswords.customswordmod.content.items.weapons.claws;

import com.odysseyswords.customswordmod.content.items.weapons.base.ClawWeaponItem;
import net.minecraft.world.item.Tiers;

public class FistOfFury extends ClawWeaponItem {
    
    public FistOfFury(){
        super(
                Tiers.NETHERITE,
                new Properties()
                        .stacksTo(1)
                        .durability(400)
        );
    }
}
