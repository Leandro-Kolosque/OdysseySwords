package com.odysseyswords.customswordmod.util.tooltip;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public final class WeaponTooltipOverrides {

    private static final Map<String, ChatFormatting> OVERRIDES = new HashMap<>();

    static {
        OVERRIDES.put("fyralath", ChatFormatting.RED);
        OVERRIDES.put("thunderwrath", ChatFormatting.GOLD);
        OVERRIDES.put("supernova", ChatFormatting.LIGHT_PURPLE);
        OVERRIDES.put("edar", ChatFormatting.DARK_GRAY);
        OVERRIDES.put("ash", ChatFormatting.YELLOW);
        OVERRIDES.put("ghaj", ChatFormatting.DARK_GREEN);
        OVERRIDES.put("azhar", ChatFormatting.DARK_PURPLE);
        OVERRIDES.put("orion", ChatFormatting.AQUA);
        OVERRIDES.put("apophis", ChatFormatting.DARK_RED);
        OVERRIDES.put("apocalypse", ChatFormatting.BLUE);
        OVERRIDES.put("fist_of_fury", ChatFormatting.DARK_AQUA);
        OVERRIDES.put("fury_of_a_thousand_fists", ChatFormatting.DARK_AQUA);
    }

    private WeaponTooltipOverrides() {}

    public static boolean hasOverride(ItemStack stack) {
        return OVERRIDES.containsKey(getItemId(stack));
    }

    public static void applyOverride(ItemStack stack, List<Component> tooltip) {
        String id = getItemId(stack);
        ChatFormatting color = OVERRIDES.get(id);

        if (color == null) return;

        MutableComponent text = Component.translatable(
                "item.odysseyswords." + id + ".tooltip"
        );

        tooltip.add(text.withStyle(color).withStyle(ChatFormatting.ITALIC));
    }

    private static String getItemId(ItemStack stack) {
        return stack.getItem()
                .getDescriptionId()
                .replace("item.odysseyswords.", "");
    }
}
