package com.odysseyswords.customswordmod.content.items.food.foods;

import com.odysseyswords.customswordmod.content.items.food.builder.FoodBuilder;
import com.odysseyswords.customswordmod.content.items.food.definition.FoodDefinition;

public final class PopsicleFood {

    public static final FoodDefinition POPSICLE = FoodBuilder.create()
            .nutrition(3)
            .saturation(0.2f)
            .fast()
            .build();

    private PopsicleFood() {
    }
}