package com.odysseyswords.customswordmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModTooltipItem extends Item {

    public ModTooltipItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        String key = stack.getItem().getDescriptionId() + ".tooltip";
        tooltip.add(Component.translatable(key).withStyle(ChatFormatting.GRAY));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}

