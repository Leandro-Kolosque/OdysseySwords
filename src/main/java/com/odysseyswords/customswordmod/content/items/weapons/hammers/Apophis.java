package com.odysseyswords.customswordmod.content.items.weapons.hammers;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.HammerWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class Apophis extends HammerWeaponItem {

    public Apophis() {
        super(
                Tiers.NETHERITE,
                new Item.Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(net.minecraft.world.item.Rarity.EPIC));
    }

    @Override
    public MaterialType getMaterialType() {
        return MaterialType.BLOOD;
    }
}
