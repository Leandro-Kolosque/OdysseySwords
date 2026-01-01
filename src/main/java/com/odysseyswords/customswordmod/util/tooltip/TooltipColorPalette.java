package com.odysseyswords.customswordmod.util.tooltip;

import net.minecraft.ChatFormatting;

import java.util.HashMap;
import java.util.Map;

public final class TooltipColorPalette {

    private static final Map<String, ChatFormatting> MATERIAL_COLORS = new HashMap<>();

    static {
        MATERIAL_COLORS.put("blood", ChatFormatting.DARK_RED);
        MATERIAL_COLORS.put("cyber", ChatFormatting.RED);
        MATERIAL_COLORS.put("frost", ChatFormatting.AQUA);
        MATERIAL_COLORS.put("royal", ChatFormatting.YELLOW);
        MATERIAL_COLORS.put("sculk", ChatFormatting.DARK_GRAY);
        MATERIAL_COLORS.put("soul", ChatFormatting.GRAY);
        MATERIAL_COLORS.put("tartarus", ChatFormatting.GOLD);
        MATERIAL_COLORS.put("void", ChatFormatting.DARK_PURPLE);
        MATERIAL_COLORS.put("toxic", ChatFormatting.DARK_GREEN);
        MATERIAL_COLORS.put("silverine", ChatFormatting.WHITE);
        MATERIAL_COLORS.put("divine", ChatFormatting.GOLD);
        MATERIAL_COLORS.put("storm", ChatFormatting.BLUE);
        MATERIAL_COLORS.put("crystal", ChatFormatting.LIGHT_PURPLE);
    }

    private TooltipColorPalette() {}

    public static ChatFormatting getColor(String materialId) {
        return MATERIAL_COLORS.getOrDefault(materialId, ChatFormatting.GRAY);
    }
}
