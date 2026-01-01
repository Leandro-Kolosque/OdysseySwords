package com.odysseyswords.customswordmod.content.items.materials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public final class MaterialItemProperties {

    private MaterialItemProperties() {
    }

    public static Item.Properties ingot() {
        return new Item.Properties()
                .fireResistant()
                .stacksTo(64)
                .rarity(Rarity.UNCOMMON);
    }

    public static Item.Properties gem() {
        return new Item.Properties()
                .fireResistant();
    }

    public static Item.Properties specialMaterial() {
        return new Item.Properties()
                .fireResistant()
                .rarity(Rarity.RARE);
    }
}
