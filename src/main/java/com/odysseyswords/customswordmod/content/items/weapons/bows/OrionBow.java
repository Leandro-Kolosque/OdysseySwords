package com.odysseyswords.customswordmod.content.items.weapons.bows;

import com.odysseyswords.customswordmod.content.items.weapons.base.AbstractBowWeaponItem;
import com.odysseyswords.customswordmod.util.helpers.TooltipStyleHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class OrionBow extends AbstractBowWeaponItem {

    public OrionBow() {
        super(new Properties()
                .durability(500)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.EPIC)
        );
    }

    @Override
    public void appendHoverText(
            ItemStack stack,
            @Nullable Level level,
            List<Component> tooltip,
            TooltipFlag flag
    ) {
        super.appendHoverText(stack, level, tooltip, flag);

        String itemId = stack.getItem().getDescriptionId();
        String weaponId = itemId.replace("item.odysseyswords.", "");

        String specificKey = itemId + ".tooltip";
        Component specificTooltip = Component.translatable(specificKey);

        if (!specificTooltip.getString().equals(specificKey)) {
            addStyledTooltip(tooltip, specificKey, weaponId);
        } else {
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
}
