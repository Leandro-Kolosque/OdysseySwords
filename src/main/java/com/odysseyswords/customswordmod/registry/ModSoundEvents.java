package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.core.OdysseyConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSoundEvents {
        // 1. Create DeferredRegister for SoundEvents
        public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister
                        .create(ForgeRegistries.SOUND_EVENTS, OdysseyConstants.MOD_ID);

        // 2. Register sounds
        /*
         * =========================
         * Sword – Dark
         * =========================
         */
        public static final RegistryObject<SoundEvent> DARK_SWORD_WHOOSH_02 = register("dark_sword_whoosh_02");

        public static final RegistryObject<SoundEvent> DARK_SWORD_WHOOSH_03 = register("dark_sword_whoosh_03");

        public static final RegistryObject<SoundEvent> DARK_SWORD_WHOOSH_04 = register("dark_sword_whoosh_04");

        /*
         * =========================
         * Sword – Elemental Fire
         * =========================
         */
        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_01 = register(
                        "elemental_sword_fire_attack_01");

        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_02 = register(
                        "elemental_sword_fire_attack_02");

        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_FIRE_ATTACK_03 = register(
                        "elemental_sword_fire_attack_03");

        /*
         * =========================
         * Sword – Elemental Holy
         * =========================
         */
        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_HOLY_ATTACK_01 = register(
                        "elemental_sword_holy_attack_01");

        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_HOLY_ATTACK_02 = register(
                        "elemental_sword_holy_attack_02");

        /*
         * =========================
         * Sword – Sci-Fi
         * =========================
         */
        public static final RegistryObject<SoundEvent> ELEMENTAL_SWORD_SCI_FI_ATTACK_01 = register(
                        "elemental_sword_sci_fi_attack_01");

        // Helper method to register a single sound
        private static RegistryObject<SoundEvent> register(String name) {
                return SOUND_EVENTS.register(
                                name,
                                () -> SoundEvent.createVariableRangeEvent(
                                                new ResourceLocation(OdysseyConstants.MOD_ID, name)));
        }

        // 3. Method to register ALL sounds with Forge
        public static void register(IEventBus eventBus) {
                SOUND_EVENTS.register(eventBus);
        }
}
