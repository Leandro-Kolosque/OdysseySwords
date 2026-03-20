package com.odysseyswords.customswordmod.api.material;

import com.odysseyswords.customswordmod.api.tooltip.IOdysseyTooltip;
import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.util.tooltip.TooltipContext;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public interface IOdysseyMaterialItem extends IOdysseyTooltip {

    MaterialType getMaterialType();

    @Override
    default void appendTooltip(TooltipContext context) {
        MaterialType material = getMaterialType();

        String tooltipKey = context.getStack().getDescriptionId() + ".tooltip";

        context.add(
            Component.translatable(tooltipKey)
                .withStyle(material.getColor(), ChatFormatting.ITALIC)
        );
    }
}