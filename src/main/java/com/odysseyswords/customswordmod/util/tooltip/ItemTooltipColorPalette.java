package com.odysseyswords.customswordmod.util.tooltip;

import net.minecraft.ChatFormatting;

import java.util.HashMap;
import java.util.Map;

public final class ItemTooltipColorPalette {

    private static final Map<String, ChatFormatting> ITEM_COLORS = new HashMap<>();

    static {
        ITEM_COLORS.put("blood", ChatFormatting.DARK_RED);
        ITEM_COLORS.put("phoenix_feather", ChatFormatting.GOLD);
    }

    private ItemTooltipColorPalette() {}

    public static ChatFormatting getColor(String itemId) {
        return ITEM_COLORS.getOrDefault(itemId, ChatFormatting.GRAY);
    }
}