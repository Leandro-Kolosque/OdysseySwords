package com.odysseyswords.customswordmod.content.items.armor.traits.types;

import com.odysseyswords.customswordmod.content.items.armor.traits.IArmorTrait;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class CyberTrait implements IArmorTrait {

    @Override
    public void onTick(ArmorTraitContext context) {
        // Já existia: visão noturna enquanto o set completo estiver equipado
        if (context.entity().tickCount % 20 == 0) {
            context.entity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
        }
    }

    // ===== TEMPORÁRIO — só para validar visualmente o onHurt, remover/substituir depois =====
    @Override
    public void onHurt(ArmorTraitContext context, LivingHurtEvent event) {
        if (context.entity() instanceof Player player && !player.level().isClientSide) {
            player.displayClientMessage(
                    Component.literal("[CyberTrait] onHurt disparado — dano: " + event.getAmount()),
                    true // true = mostra na action bar, acima da hotbar
            );
        }
    }

    // ===== TEMPORÁRIO — só para validar visualmente o onSetEquipped, remover/substituir depois =====
    @Override
    public void onSetEquipped(LivingEntity entity) {
        if (!entity.level().isClientSide) {
            entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0, false, true));
            if (entity instanceof Player player) {
                player.displayClientMessage(
                        Component.literal("[CyberTrait] Set completo equipado!"),
                        true
                );
            }
        }
    }
}