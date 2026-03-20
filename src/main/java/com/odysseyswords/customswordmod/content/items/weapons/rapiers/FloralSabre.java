package com.odysseyswords.customswordmod.content.items.weapons.rapiers;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.RapierWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class FloralSabre extends RapierWeaponItem {

    public FloralSabre() {
        super(
                Tiers.NETHERITE,
                new Item.Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(net.minecraft.world.item.Rarity.RARE));
    }

    @Override
    public MaterialType getMaterialType() {
        return MaterialType.BLOOD;
    }
}
