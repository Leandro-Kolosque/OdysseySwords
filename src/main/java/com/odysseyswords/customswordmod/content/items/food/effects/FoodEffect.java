package com.odysseyswords.customswordmod.content.items.food.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

public class FoodEffect {

    private final MobEffect effect;
    private final int duration;
    private final int amplifier;
    private final float chance;

    public FoodEffect(MobEffect effect, int duration, int amplifier, float chance) {
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
        this.chance = chance;
    }

    public MobEffectInstance createInstance() {
        return new MobEffectInstance(this.effect, this.duration, this.amplifier);
    }

    public float getChance() {
        return this.chance;
    }

    public MobEffect getEffect() {
        return this.effect;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getAmplifier() {
        return this.amplifier;
    }
}