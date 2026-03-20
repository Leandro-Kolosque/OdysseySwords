package com.odysseyswords.customswordmod.content.items.weapons.spears;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.SpearWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class ForestGuardianGlaive extends SpearWeaponItem {

    public ForestGuardianGlaive() {
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
