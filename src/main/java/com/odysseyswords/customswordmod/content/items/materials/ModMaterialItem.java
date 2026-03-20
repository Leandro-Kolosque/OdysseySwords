package com.odysseyswords.customswordmod.content.items.materials;

import com.odysseyswords.customswordmod.api.material.IOdysseyMaterialItem;
import net.minecraft.world.item.Item;

public class ModMaterialItem extends Item implements IOdysseyMaterialItem {

    private final MaterialItemProperties materialProperties;
    private final MaterialType materialType;

    public ModMaterialItem(MaterialItemProperties materialProperties,
                           MaterialType materialType) {
        super(materialProperties.getProperties());
        this.materialProperties = materialProperties;
        this.materialType = materialType;
    }

    public MaterialItemType getItemType() {
        return materialProperties.getType();
    }

    @Override
    public MaterialType getMaterialType() {
        return materialType;
    }
}