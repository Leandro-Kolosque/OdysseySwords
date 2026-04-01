package com.odysseyswords.customswordmod.content.blocks.interactive.dice;

import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class WeightedDrop {

    private final int weight;
    private final Supplier<ItemStack> supplier;

    public WeightedDrop(int weight, Supplier<ItemStack> supplier) {
        this.weight = weight;
        this.supplier = supplier;
    }

    public int getWeight() {
        return weight;
    }

    public ItemStack create() {
        return supplier.get();
    }
}