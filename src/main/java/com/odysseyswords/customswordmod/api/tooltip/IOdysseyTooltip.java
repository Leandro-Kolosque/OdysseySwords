package com.odysseyswords.customswordmod.api.tooltip;

import com.odysseyswords.customswordmod.util.tooltip.TooltipContext;

public interface IOdysseyTooltip {

    default void appendTooltip(TooltipContext context) {
        // default vazio
    }
}