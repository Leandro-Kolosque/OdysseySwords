package com.odysseyswords.customswordmod.content.items.materials;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModMaterialItem extends Item {

    private final MaterialItemProperties materialProperties;

    public ModMaterialItem(MaterialItemProperties materialProperties) {
        super(materialProperties.getProperties());
        this.materialProperties = materialProperties;
    }

    public MaterialType getMaterialType() {
        return materialProperties.getType();
    }
}