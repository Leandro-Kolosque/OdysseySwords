package com.odysseyswords.customswordmod.item.custom;

import com.odysseyswords.customswordmod.util.TooltipStyleHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.List;

public class ModTooltipItem extends Item {

    public ModTooltipItem(Properties properties) {
        super(properties);
    }

@Override
public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    String itemId = stack.getItem().getDescriptionId();
    
    // Primeiro tenta pegar a descrição específica do item
    String specificTooltipKey = itemId + ".tooltip";
    if (Component.translatable(specificTooltipKey).getString().equals(specificTooltipKey)) {
        // Se não houver descrição específica, usa a genérica do material
        Optional<String> materialTooltipKey = TooltipStyleHelper.getMaterialTooltipKey(itemId);
        if (materialTooltipKey.isPresent()) {
            ChatFormatting color = TooltipStyleHelper.getColorFromId(itemId);
            tooltip.add(Component.translatable(materialTooltipKey.get()).withStyle(color, ChatFormatting.ITALIC));
        }
    } else {
        // Se houver descrição específica, usa ela
        ChatFormatting color = TooltipStyleHelper.getColorFromId(itemId);
        tooltip.add(Component.translatable(specificTooltipKey).withStyle(color, ChatFormatting.ITALIC));
    }

    super.appendHoverText(stack, world, tooltip, flag);
}
}


