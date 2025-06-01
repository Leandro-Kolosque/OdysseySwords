package com.odysseyswords.customswordmod.item.custom;

import com.odysseyswords.customswordmod.util.TooltipStyleHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModMaterialItem extends Item {

    public ModMaterialItem(Properties properties) {
        super(properties);
    }

@Override
public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
    String itemId = stack.getItem().getDescriptionId();
    String baseId = itemId.replace("item.odysseyswords.", "");

    String materialName = baseId.split("_")[0];

    String specificKey = itemId + ".tooltip";
    MutableComponent specificTooltip = Component.translatable(specificKey);

    if (!specificTooltip.getString().equals(specificKey)) {
        tooltip.add(specificTooltip.withStyle(TooltipStyleHelper.getColorFromId(materialName))
                .withStyle(ChatFormatting.ITALIC));
    } else {
        String materialKey = "item.odysseyswords.material_tooltip." + materialName;
        MutableComponent text = Component.translatable(materialKey);
        tooltip.add(text.withStyle(TooltipStyleHelper.getColorFromId(materialName))
                .withStyle(ChatFormatting.ITALIC));
    }

    super.appendHoverText(stack, world, tooltip, flag);
}
}