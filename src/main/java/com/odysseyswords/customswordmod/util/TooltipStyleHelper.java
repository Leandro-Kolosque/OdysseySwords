package com.odysseyswords.customswordmod.util;

import net.minecraft.ChatFormatting;

import java.util.HashMap;
import java.util.Map;

public class TooltipStyleHelper {

    private static final Map<String, ChatFormatting> STYLE_MAP = new HashMap<>();

    static {
        STYLE_MAP.put("blood", ChatFormatting.DARK_RED);
        STYLE_MAP.put("crystal", ChatFormatting.LIGHT_PURPLE);
        STYLE_MAP.put("cyber", ChatFormatting.RED);
        STYLE_MAP.put("divine", ChatFormatting.GOLD);
        STYLE_MAP.put("frost", ChatFormatting.DARK_AQUA);
        STYLE_MAP.put("lightningbolt_of_zeus", ChatFormatting.AQUA);
        STYLE_MAP.put("nether_rod", ChatFormatting.RED);
        STYLE_MAP.put("royal", ChatFormatting.YELLOW);
        STYLE_MAP.put("sculk", ChatFormatting.DARK_GRAY);
        STYLE_MAP.put("silverine", ChatFormatting.WHITE);
        STYLE_MAP.put("soul", ChatFormatting.GRAY);
        STYLE_MAP.put("storm", ChatFormatting.BLUE);
        STYLE_MAP.put("tartarus", ChatFormatting.GOLD);
        STYLE_MAP.put("toxic", ChatFormatting.DARK_GREEN);
        STYLE_MAP.put("void", ChatFormatting.DARK_PURPLE);
    }

    public static ChatFormatting getColorFromId(String itemId) {
        return STYLE_MAP.entrySet().stream()
            .filter(entry -> itemId.contains(entry.getKey()))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(ChatFormatting.GRAY);
    }
}
