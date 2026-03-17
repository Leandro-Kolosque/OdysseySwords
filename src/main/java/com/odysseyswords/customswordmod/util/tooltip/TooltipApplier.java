package com.odysseyswords.customswordmod.util.tooltip;

import com.odysseyswords.customswordmod.content.items.materials.MaterialDefinitions;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Optional;

public final class TooltipApplier {

    private static String getItemId(ItemStack stack) {
        ResourceLocation id = ForgeRegistries.ITEMS.getKey(stack.getItem());
        return id != null ? id.getPath() : "";
    }

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> tooltip = event.getToolTip();

        String itemId = getItemId(stack);

        // 1. Overrides (armas únicas)
        if (WeaponTooltipOverrides.hasOverride(stack)) {
            WeaponTooltipOverrides.applyOverride(stack, tooltip);
            return;
        }

        // 2. Verifica se é arma com material
        Optional<String> materialOpt = MaterialDefinitions.getMaterial(itemId);

        if (materialOpt.isPresent()) {
            String material = materialOpt.get();
            ChatFormatting color = TooltipColorPalette.getColor(material);

            MutableComponent materialText = Component.translatable(
                    "item.odysseyswords.material_tooltip." + material);

            tooltip.add(materialText.withStyle(color, ChatFormatting.ITALIC));
            return;
        }

        // 3. Caso contrário = ITEM NORMAL (blood, phoenix_feather, etc)
        String itemTooltipKey = stack.getItem().getDescriptionId() + ".tooltip";
        
        if (net.minecraft.client.resources.language.I18n.exists(itemTooltipKey)) {
            ChatFormatting color = ItemTooltipColorPalette.getColor(itemId);

            tooltip.add(Component.translatable(itemTooltipKey)
                    .withStyle(color, ChatFormatting.ITALIC));
        }
    }
}
