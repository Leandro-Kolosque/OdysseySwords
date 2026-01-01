package com.odysseyswords.customswordmod.util.tooltip;

import com.odysseyswords.customswordmod.content.items.materials.MaterialDefinitions;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;
import java.util.Optional;

public final class TooltipApplier {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        String itemId = getItemId(stack);

        // 1️⃣ Overrides absolutos (fyralath, etc)
        if (WeaponTooltipOverrides.hasOverride(stack)) {
            WeaponTooltipOverrides.applyOverride(stack, tooltip);
            return;
        }

        // 2️⃣ Material padrão
        Optional<String> materialOpt = MaterialDefinitions.getMaterial(itemId);

        if (materialOpt.isEmpty()) return;

        String material = materialOpt.get();
        ChatFormatting color = TooltipColorPalette.getColor(material);

        MutableComponent text = Component.translatable(
                "item.odysseyswords.material_tooltip." + material
        );

        tooltip.add(text.withStyle(color).withStyle(ChatFormatting.ITALIC));
    }

    private static String getItemId(ItemStack stack) {
        return stack.getItem()
                .getDescriptionId()
                .replace("item.odysseyswords.", "");
    }
}
