package com.odysseyswords.customswordmod.content.items.food.definition;

import com.odysseyswords.customswordmod.content.items.food.effects.FoodEffect;
import net.minecraft.world.food.FoodProperties;

import java.util.List;

public class FoodDefinition {

    private final int nutrition;
    private final float saturation;
    private final boolean fastFood;
    private final boolean alwaysEat;
    private final List<FoodEffect> effects;

    public FoodDefinition(int nutrition, float saturation, boolean fastFood, boolean alwaysEat, List<FoodEffect> effects) {
        this.nutrition = nutrition;
        this.saturation = saturation;
        this.fastFood = fastFood;
        this.alwaysEat = alwaysEat;
        this.effects = List.copyOf(effects);
    }

    public FoodProperties createFoodProperties() {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(this.nutrition)
                .saturationMod(this.saturation);

        if (this.fastFood) {
            builder.fast();
        }

        if (this.alwaysEat) {
            builder.alwaysEat();
        }

        for (FoodEffect effect : this.effects) {
            builder.effect(effect::createInstance, effect.getChance());
        }

        return builder.build();
    }

    public int getNutrition() {
        return this.nutrition;
    }

    public float getSaturation() {
        return this.saturation;
    }

    public boolean isFastFood() {
        return this.fastFood;
    }

    public boolean canAlwaysEat() {
        return this.alwaysEat;
    }

    public List<FoodEffect> getEffects() {
        return this.effects;
    }
}