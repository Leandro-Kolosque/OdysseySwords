package com.odysseyswords.customswordmod.content.items.materials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class MaterialItemProperties {

    private final Item.Properties properties;
    private final MaterialType type;

    private MaterialItemProperties(Item.Properties properties, MaterialType type) {
        this.properties = properties;
        this.type = type;
    }

    public Item.Properties getProperties() {
        return properties;
    }

    public MaterialType getType() {
        return type;
    }

    // ===== FACTORIES =====

    public static MaterialItemProperties ingot() {
        return new MaterialItemProperties(
                new Item.Properties()
                        .fireResistant()
                        .stacksTo(64)
                        .rarity(Rarity.UNCOMMON),
                MaterialType.INGOT
        );
    }

    public static MaterialItemProperties gem() {
        return new MaterialItemProperties(
                new Item.Properties()
                        .fireResistant(),
                MaterialType.GEM
        );
    }

    public static MaterialItemProperties essence() {
        return new MaterialItemProperties(
                new Item.Properties()
                        .fireResistant()
                        .rarity(Rarity.RARE),
                MaterialType.ESSENCE
        );
    }

    public static MaterialItemProperties drop() {
        return new MaterialItemProperties(
                new Item.Properties(),
                MaterialType.DROP
        );
    }
}
