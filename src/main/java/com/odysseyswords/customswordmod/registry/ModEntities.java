package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.OdysseySwords;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Registro central de todas as entidades do OdysseySwords.
 *
 * Padrão de registro:
 *   ENTITY_TYPES.register("nome_do_mob", () ->
 *       EntityType.Builder.of(NomeDaEntidade::new, MobCategory.CATEGORIA)
 *           .sized(largura, altura)
 *           .build("nome_do_mob"));
 *
 * Categorias comuns:
 *   MobCategory.MONSTER  → mobs hostis, spawnados no escuro
 *   MobCategory.CREATURE → mobs passivos, spawnados na superfície
 *   MobCategory.MISC     → entidades sem regra de spawn natural (ex: bosses)
 *
 * Tamanhos de referência:
 *   Jogador  → 0.6f x 1.8f
 *   Zombie   → 0.6f x 1.95f
 *   Enderman → 0.6f x 2.9f
 *   Wither   → 0.9f x 3.5f
 *
 * Bosses usam MobCategory.MISC pois não spawnão naturalmente —
 * são invocados via item, bloco ou evento.
 *
 * Quando adicionar um novo mob:
 *   1. Declare o RegistryObject aqui
 *   2. Registre os atributos em ModEventSubscriber via EntityAttributeCreationEvent
 *   3. Registre o renderer em ClientSetup via EntityRenderersEvent.RegisterRenderers
 */
public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OdysseySwords.MODID);

    // -------------------------------------------------------------------------
    // Mobs hostis
    // Adicione novos mobs hostis abaixo seguindo o padrão
    // -------------------------------------------------------------------------

    // Exemplo (descomente ao implementar o mob):
    //
    // public static final RegistryObject<EntityType<AbyssalKnightEntity>> ABYSSAL_KNIGHT =
    //         ENTITY_TYPES.register("abyssal_knight", () ->
    //                 EntityType.Builder.of(AbyssalKnightEntity::new, MobCategory.MONSTER)
    //                         .sized(0.6f, 1.95f)
    //                         .build("abyssal_knight"));

    // -------------------------------------------------------------------------
    // Bosses
    // Sempre MobCategory.MISC — nunca spawnão naturalmente
    // -------------------------------------------------------------------------

    // Exemplo (descomente ao implementar o boss):
    //
    // public static final RegistryObject<EntityType<TartarusGuardianEntity>> TARTARUS_GUARDIAN =
    //         ENTITY_TYPES.register("tartarus_guardian", () ->
    //                 EntityType.Builder.of(TartarusGuardianEntity::new, MobCategory.MISC)
    //                         .sized(1.2f, 3.0f)
    //                         .clientTrackingRange(10)
    //                         .build("tartarus_guardian"));

    // -------------------------------------------------------------------------
    // Registro no mod bus
    // -------------------------------------------------------------------------

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}