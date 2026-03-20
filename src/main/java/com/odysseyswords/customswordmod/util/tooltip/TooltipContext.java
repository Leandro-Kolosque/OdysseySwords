package com.odysseyswords.customswordmod.util.tooltip;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class TooltipContext {

    private final ItemStack stack;
    private final List<Component> tooltip;
    private final TooltipFlag flag;

    public TooltipContext(ItemStack stack, List<Component> tooltip, TooltipFlag flag) {
        this.stack = stack;
        this.tooltip = tooltip;
        this.flag = flag;
    }

    public void add(Component component) {
        tooltip.add(component);
    }

    public void addTranslated(String key) {
        add(Component.translatable(key));
    }

    public ItemStack getStack() {
        return stack;
    }

    public TooltipFlag getFlag() {
        return flag;
    }
}