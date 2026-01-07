package com.odysseyswords.customswordmod.content.items.armor.base;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public abstract class AbstractOdysseyArmorItem extends ArmorItem {

    protected AbstractOdysseyArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    /**
     * Usado futuramente para identificar sets
     */
    public abstract String getArmorSetId();
}
