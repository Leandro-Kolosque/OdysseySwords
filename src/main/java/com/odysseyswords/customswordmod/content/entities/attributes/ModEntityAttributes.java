package com.odysseyswords.customswordmod.content.entities.attributes;

import com.odysseyswords.customswordmod.OdysseySwords;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Registro de atributos customizados do OdysseySwords.
 *
 * Atributos customizados são usados quando o vanilla não oferece
 * o atributo necessário — por exemplo, "soul power" de um boss,
 * ou "bleed resistance" de uma armadura especial.
 *
 * Como registrar um atributo customizado:
 *   1. Declare o RegistryObject aqui
 *   2. Use o atributo na entidade via getAttribute(ModEntityAttributes.SEU_ATRIBUTO.get())
 *   3. Adicione-o ao AttributeSupplier da entidade via AttributeBuilder ou diretamente
 *
 * Obs: atributos do vanilla (MAX_HEALTH, ATTACK_DAMAGE, etc.) NÃO precisam
 * ser registrados aqui — use diretamente via Attributes.MAX_HEALTH etc.
 */
public class ModEntityAttributes {

    public static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(ForgeRegistries.ATTRIBUTES, OdysseySwords.MODID);

    // -------------------------------------------------------------------------
    // Atributos customizados
    // Padrão de nomenclatura: "attribute.odysseyswords.nome_do_atributo"
    // Valores: (translationKey, defaultValue, minValue, maxValue)
    // -------------------------------------------------------------------------

    /**
     * Representa a resistência ao sangramento.
     * Usado em armaduras e mobs que devem ignorar o BleedEffect.
     */
    public static final RegistryObject<Attribute> BLEED_RESISTANCE =
            ATTRIBUTES.register("bleed_resistance", () ->
                    new RangedAttribute("attribute.odysseyswords.bleed_resistance",
                            0.0, 0.0, 1.0)
                            .setSyncable(true));

    /**
     * Multiplicador de dano em fases de boss.
     * Aumentado automaticamente pelo BossPhaseManager nas transições.
     */
    public static final RegistryObject<Attribute> PHASE_DAMAGE_MULTIPLIER =
            ATTRIBUTES.register("phase_damage_multiplier", () ->
                    new RangedAttribute("attribute.odysseyswords.phase_damage_multiplier",
                            1.0, 0.5, 5.0)
                            .setSyncable(true));

    /**
     * Velocidade de invocação — usada por bosses que spawniam minions.
     * Quanto maior o valor, mais rápido o cooldown de invocação.
     */
    public static final RegistryObject<Attribute> SUMMON_SPEED =
            ATTRIBUTES.register("summon_speed", () ->
                    new RangedAttribute("attribute.odysseyswords.summon_speed",
                            1.0, 0.1, 10.0)
                            .setSyncable(true));

    // -------------------------------------------------------------------------
    // Registro no mod bus
    // -------------------------------------------------------------------------

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }
}