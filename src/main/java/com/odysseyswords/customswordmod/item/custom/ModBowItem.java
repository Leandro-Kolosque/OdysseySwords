package com.odysseyswords.customswordmod.item.custom;

import com.odysseyswords.customswordmod.util.TooltipStyleHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class ModBowItem extends BowItem {

    public ModBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, world, tooltip, flag);

        String itemId = stack.getItem().getDescriptionId();
        String weaponId = itemId.replace("item.odysseyswords.", "");

        // 1. Verifica tooltip específico do item
        String specificKey = itemId + ".tooltip";
        Component specificTooltip = Component.translatable(specificKey);
        if (!specificTooltip.getString().equals(specificKey)) {
            addStyledTooltip(tooltip, specificKey, weaponId);
        }
        // 2. Se não tiver, usa tooltip genérico do material
        else {
            Optional<String> material = TooltipStyleHelper.getBaseMaterial(weaponId);
            material.ifPresent(mat -> {
                String materialKey = TooltipStyleHelper.getMaterialTooltipKey(mat);
                addStyledTooltip(tooltip, materialKey, weaponId);
            });
        }
    }

    private void addStyledTooltip(List<Component> tooltip, String tooltipKey, String weaponId) {
        ChatFormatting color = TooltipStyleHelper.getColorForWeapon(weaponId);
        MutableComponent text = Component.translatable(tooltipKey);
        tooltip.add(text.withStyle(color).withStyle(ChatFormatting.ITALIC));
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }

    @Override
    public boolean isFireResistant() {
        return true;
    }
}
