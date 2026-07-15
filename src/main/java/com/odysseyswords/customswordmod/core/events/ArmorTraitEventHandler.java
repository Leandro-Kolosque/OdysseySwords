package com.odysseyswords.customswordmod.core.events;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.base.AbstractOdysseyArmorItem;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitContext;
import com.odysseyswords.customswordmod.content.items.armor.traits.ArmorTraitRegistry;
import com.odysseyswords.customswordmod.content.items.armor.traits.IArmorTrait;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Mod.EventBusSubscriber(modid = OdysseySwords.MODID)
public class ArmorTraitEventHandler {

    /**
     * Guarda, por entidade, o armorSetId do último conjunto completo reconhecido.
     * Usado exclusivamente para detectar a TRANSIÇÃO para um novo set completo
     * e disparar onSetEquipped() uma única vez, não a cada tick.
     *
     * Simplificação conhecida: entradas de entidades que deixam o mundo (morrem,
     * descarregam o chunk) não são removidas proativamente daqui, apenas quando
     * a própria entidade troca de equipamento sem set completo. Aceitável para
     * o volume de entidades do jogo, mas fica registrado como possível ponto de
     * atenção caso o mod passe a lidar com um número muito grande de entidades.
     */
    private static final Map<UUID, String> lastKnownSetId = new ConcurrentHashMap<>();

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();

        // Otimização de performance: roda 1x por segundo, não a cada tick
        if (entity.level().isClientSide || entity.tickCount % 20 != 0) return;

        List<IArmorTrait> activeTraits = ArmorTraitRegistry.getActiveTraits(entity);

        if (!activeTraits.isEmpty()) {
            ArmorTraitContext context = new ArmorTraitContext(entity, entity.getItemBySlot(EquipmentSlot.CHEST), 0);
            activeTraits.forEach(trait -> trait.onTick(context));
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntity();

        List<IArmorTrait> activeTraits = ArmorTraitRegistry.getActiveTraits(entity);
        if (activeTraits.isEmpty()) return;

        ArmorTraitContext context = new ArmorTraitContext(entity, entity.getItemBySlot(EquipmentSlot.CHEST), 0);
        activeTraits.forEach(trait -> trait.onHurt(context, event));
    }

    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        EquipmentSlot slot = event.getSlot();

        // Só nos interessam trocas nos 4 slots de armadura
        if (slot != EquipmentSlot.HEAD && slot != EquipmentSlot.CHEST
                && slot != EquipmentSlot.LEGS && slot != EquipmentSlot.FEET) {
            return;
        }

        LivingEntity entity = event.getEntity();
        UUID entityId = entity.getUUID();

        String currentSetId = ArmorTraitRegistry.getEquippedSetReference(entity)
                .map(AbstractOdysseyArmorItem::getArmorSetId)
                .orElse(null);

        String previousSetId = lastKnownSetId.get(entityId);

        // Só dispara onSetEquipped se um set completo passou a existir AGORA
        // e não era o mesmo set já reconhecido no tick anterior.
        if (currentSetId != null && !currentSetId.equals(previousSetId)) {
            ArmorTraitRegistry.getActiveTraits(entity)
                    .forEach(trait -> trait.onSetEquipped(entity));
        }

        if (currentSetId != null) {
            lastKnownSetId.put(entityId, currentSetId);
        } else {
            lastKnownSetId.remove(entityId);
        }
    }
}