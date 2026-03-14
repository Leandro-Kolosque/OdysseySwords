package com.odysseyswords.customswordmod.content.items.food.builder;

import com.odysseyswords.customswordmod.content.items.food.definition.FoodDefinition;
import com.odysseyswords.customswordmod.content.items.food.effects.FoodEffect;
import net.minecraft.world.effect.MobEffect;

import java.util.ArrayList;
import java.util.List;

public class FoodBuilder {

    private int nutrition;
    private float saturation;
    private boolean fastFood;
    private boolean alwaysEat;
    private final List<FoodEffect> effects = new ArrayList<>();

    private FoodBuilder() {
    }

    public static FoodBuilder create() {
        return new FoodBuilder();
    }

    public FoodBuilder nutrition(int nutrition) {
        this.nutrition = nutrition;
        return this;
    }

    public FoodBuilder saturation(float saturation) {
        this.saturation = saturation;
        return this;
    }

    public FoodBuilder fast() {
        this.fastFood = true;
        return this;
    }

    public FoodBuilder alwaysEat() {
        this.alwaysEat = true;
        return this;
    }

    public FoodBuilder effect(MobEffect effect, int duration, int amplifier, float chance) {
        this.effects.add(new FoodEffect(effect, duration, amplifier, chance));
        return this;
    }

    public FoodBuilder effect(FoodEffect effect) {
        this.effects.add(effect);
        return this;
    }

    public FoodDefinition build() {
        return new FoodDefinition(
                this.nutrition,
                this.saturation,
                this.fastFood,
                this.alwaysEat,
                this.effects
        );
    }
}