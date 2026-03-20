package com.odysseyswords.customswordmod.content.items.weapons.bows;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.AbstractBowWeaponItem;
import net.minecraft.world.item.Rarity;

public class OrionBow extends AbstractBowWeaponItem {

    public OrionBow() {
        super(new Properties()
                .durability(500)
                .fireResistant()
                .rarity(Rarity.EPIC));
    }

    @Override
    public MaterialType getMaterialType() {
        return MaterialType.BLOOD;
    }
}
