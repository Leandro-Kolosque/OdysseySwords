package com.odysseyswords.customswordmod.util.tooltip;

import com.odysseyswords.customswordmod.api.tooltip.IOdysseyTooltip;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TooltipHandler {

    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();

        if (item instanceof IOdysseyTooltip tooltipItem) {
            TooltipContext context = new TooltipContext(
                stack,
                event.getToolTip(),
                event.getFlags()
            );

            tooltipItem.appendTooltip(context);
            return;
        }
    }
}