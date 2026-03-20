package com.odysseyswords.customswordmod.content.items.materials;

import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;

public enum MaterialType {

    BLOOD("blood", ChatFormatting.DARK_RED),
    FROST("frost", ChatFormatting.AQUA),
    VOID("void", ChatFormatting.DARK_PURPLE),
    TARTARUS("tartarus", ChatFormatting.GOLD),
    CRYSTAL("crystal", ChatFormatting.GOLD),
    CYBER("cyber", ChatFormatting.GOLD),
    ROYAL("royal", ChatFormatting.GOLD),
    SCULK("sculk", ChatFormatting.GOLD),
    SILVERINE("silverine", ChatFormatting.GOLD),
    SOUL("soul", ChatFormatting.GOLD),
    STORM("storm", ChatFormatting.GOLD),
    TOXIC("toxic", ChatFormatting.GOLD),
    DIVINE("divine", ChatFormatting.GOLD);

    private final String id;
    private final ChatFormatting color;

    MaterialType(String id, ChatFormatting color) {
        this.id = id;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public ChatFormatting getColor() {
        return color;
    }

    public Component getMaterialTooltip() {
        return Component.translatable(
                "item.odysseyswords.material_tooltip." + id
        ).withStyle(color, ChatFormatting.ITALIC);
    }
}