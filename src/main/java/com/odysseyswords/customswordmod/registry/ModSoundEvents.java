package com.odysseyswords.customswordmod.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
    // 1. Create DeferredRegister for SoundEvents
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "odysseyswords");

    // 2. Register sounds
    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_01 =
            registerSoundEvent("elemental_sword_fire_attack_01");

    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_02 =
            registerSoundEvent("elemental_sword_fire_attack_02");

    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_03 =
            registerSoundEvent("elemental_sword_fire_attack_03");

    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_HOLY_ATTACK_01 =
            registerSoundEvent("elemental_sword_holy_attack_01");

    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_HOLY_ATTACK_02 =
            registerSoundEvent("elemental_sword_holy_attack_02");

    public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_SCI_FI_ATTACK_01 =
            registerSoundEvent("elemental_sword_sci_fi_attack_01");

    // Helper method to register a single sound
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation("odysseyswords", name)));
    }

    // 3. Method to register ALL sounds with Forge
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus); // This registers the entire DeferredRegister
    }
}