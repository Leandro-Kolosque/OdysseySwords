package com.odysseyswords.customswordmod.content.items.misc;

import com.odysseyswords.customswordmod.api.tooltip.IOdysseyTooltip;
import com.odysseyswords.customswordmod.util.tooltip.TooltipContext;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

public class WeaponSmithingTemplateItem extends Item implements IOdysseyTooltip {

    public WeaponSmithingTemplateItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendTooltip(TooltipContext context) {

        // Header
        context.add(
            Component.literal("Smithing Template")
                .withStyle(ChatFormatting.GRAY)
        );

        // Lore
        context.add(
            Component.translatable(context.getStack().getDescriptionId() + ".tooltip")
                .withStyle(ChatFormatting.YELLOW, ChatFormatting.ITALIC)
        );
    }
}