package com.odysseyswords.customswordmod.api.weapon;

import com.odysseyswords.customswordmod.api.tooltip.IOdysseyTooltip;
import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.util.tooltip.TooltipContext;

public interface IOdysseyWeapon extends IOdysseyTooltip {

    MaterialType getMaterialType();

    default boolean hasCustomTooltip() {
        return false;
    }

    default void appendCustomTooltip(TooltipContext context) {}

    @Override
    default void appendTooltip(TooltipContext context) {
        if (hasCustomTooltip()) {
            appendCustomTooltip(context);
        } else {
            context.add(getMaterialType().getMaterialTooltip());
        }
    }
}