package com.odysseyswords.customswordmod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ModBowItem extends BowItem {
    
    public ModBowItem(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity player, int timeLeft) {
        // Primeiro executa o comportamento padrão do arco
        super.releaseUsing(stack, world, player, timeLeft);
    }
}