package com.odysseyswords.customswordmod.util;

import net.minecraft.ChatFormatting;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class TooltipStyleHelper {
    private static final Map<String, ChatFormatting> STYLE_MAP = new HashMap<>();
    private static final Map<String, String> MATERIAL_TOOLTIP_MAP = new HashMap<>();

    static {
        
        // Mapeamento de cores
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
        
        // Mapeamento de descrições por material
        MATERIAL_TOOLTIP_MAP.put("blood", "item.odysseyswords.material_tooltip.blood");
        MATERIAL_TOOLTIP_MAP.put("crystal", "item.odysseyswords.material_tooltip.crystal");
        MATERIAL_TOOLTIP_MAP.put("cyber", "item.odysseyswords.material_tooltip.cyber");
        MATERIAL_TOOLTIP_MAP.put("divine", "item.odysseyswords.material_tooltip.divine");
        MATERIAL_TOOLTIP_MAP.put("royal", "item.odysseyswords.material_tooltip.royal");
        MATERIAL_TOOLTIP_MAP.put("frost", "item.odysseyswords.material_tooltip.frost");
        MATERIAL_TOOLTIP_MAP.put("sculk", "item.odysseyswords.material_tooltip.sculk");
        MATERIAL_TOOLTIP_MAP.put("silverine", "item.odysseyswords.material_tooltip.silverine");
        MATERIAL_TOOLTIP_MAP.put("soul", "item.odysseyswords.material_tooltip.soul");
        MATERIAL_TOOLTIP_MAP.put("tartarus", "item.odysseyswords.material_tooltip.tartarus");
        MATERIAL_TOOLTIP_MAP.put("storm", "item.odysseyswords.material_tooltip.storm");
        MATERIAL_TOOLTIP_MAP.put("toxic", "item.odysseyswords.material_tooltip.toxic");
        MATERIAL_TOOLTIP_MAP.put("void", "item.odysseyswords.material_tooltip.void");
    }

    public static ChatFormatting getColorFromId(String itemId) {
        return STYLE_MAP.entrySet().stream()
            .filter(entry -> itemId.contains(entry.getKey()))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(ChatFormatting.GRAY);
    }

    public static Optional<String> getMaterialTooltipKey(String itemId) {
        return MATERIAL_TOOLTIP_MAP.entrySet().stream()
            .filter(entry -> itemId.contains(entry.getKey()))
            .map(Map.Entry::getValue)
            .findFirst();
    }
}
