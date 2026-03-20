package com.odysseyswords.customswordmod.content.items.weapons.scythes;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.ScytheWeaponItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class MagicScythe extends ScytheWeaponItem {

    public MagicScythe() {
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
