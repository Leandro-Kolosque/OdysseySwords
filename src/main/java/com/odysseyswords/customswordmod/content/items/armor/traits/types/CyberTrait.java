package com.odysseyswords.customswordmod.content.items.armor.traits.types;

import com.odysseyswords.customswordmod.content.items.armor.traits.IArmorTrait;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitContext;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class CyberTrait implements IArmorTrait {
    @Override
    public void onTick(ArmorTraitContext context) {
        // Exemplo: Dar visão noturna se estiver usando o set Cyber
        if (context.entity().tickCount % 20 == 0) {
            context.entity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
        }
    }
}