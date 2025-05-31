package com.odysseyswords.customswordmod.item;

import com.odysseyswords.customswordmod.OdysseySwords;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            OdysseySwords.MODID);

    // Helper methods for different weapon types
    private static Item.Properties swordProperties() {
        return new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB).fireResistant();
    }

    // Sword (balanced speed/damage)
    private static SwordItem createSword() {
        return new SwordItem(Tiers.NETHERITE, 4, -2.4F, swordProperties());
    }

    // Spear (long reach, slower but more damage)
    private static SwordItem createLance() {
        return new SwordItem(Tiers.NETHERITE, 5, -2.6F, swordProperties());
    }

    // Axe (high damage, very slow)
    private static SwordItem createAxe() {
        return new SwordItem(Tiers.NETHERITE, 7, -2.8F, swordProperties());
    }

    // Chakram (fast but low damage)
    private static SwordItem createChakram() {
        return new SwordItem(Tiers.NETHERITE, 3, -1.6F, swordProperties());
    }

    // Hammer (very high damage, extremely slow)
    private static SwordItem createHammer() {
        return new SwordItem(Tiers.NETHERITE, 8, -3.2F, swordProperties());
    }

    // Knife (very fast, low damage)
    private static SwordItem createKnife() {
        return new SwordItem(Tiers.NETHERITE, 2, -1.3F, swordProperties());
    }

    // Claw (fast, moderate damage)
    private static SwordItem createClaw() {
        return new SwordItem(Tiers.NETHERITE, 2, -1.4F, swordProperties());
    }

    // Greatsword (high damage, slow)
    private static SwordItem createGreatsword() {
        return new SwordItem(Tiers.NETHERITE, 6, -2.8F, swordProperties());
    }

    // Scythe (moderate damage, moderate speed)
    private static SwordItem createScythe() {
        return new SwordItem(Tiers.NETHERITE, 4, -2.4F, swordProperties());
    }

    // Warglaive (moderate damage, fast)
    private static SwordItem createWarglaive() {
        return new SwordItem(Tiers.NETHERITE, 5, -2.5F, swordProperties());
}

    // ===== Item Registrations ===== //

    // Sword
    public static final RegistryObject<Item> ABOMINABLE_BLADE = ITEMS.register("abominable_blade", () -> createSword());
    public static final RegistryObject<Item> ABOMINABLE_GREATSABER = ITEMS.register("abominable_greatsaber", () -> createSword());
    public static final RegistryObject<Item> ACID_DEMON = ITEMS.register("acid_demon", () -> createSword());
    public static final RegistryObject<Item> AQUANTIC_SACRED_BLADE = ITEMS.register("aquantic_sacred_blade", () -> createSword());
    public static final RegistryObject<Item> ASHURAS_BLADE = ITEMS.register("ashuras_blade", () -> createSword());
    public static final RegistryObject<Item> BLADE_OF_ANUBIS = ITEMS.register("blade_of_anubis", () -> createSword());
    public static final RegistryObject<Item> BLOOD_EDGE = ITEMS.register("blood_edge", () -> createSword());
    public static final RegistryObject<Item> BRAMBLETHORN = ITEMS.register("bramblethorn", () -> createSword());
    public static final RegistryObject<Item> CARIAN_SWORD = ITEMS.register("carian_sword", () -> createSword());
    public static final RegistryObject<Item> CHRONO_BLADE = ITEMS.register("chrono_blade", () -> createSword());
    public static final RegistryObject<Item> CORRUPTED_MYTHIC_BLADE = ITEMS.register("corrupted_mythic_blade", () -> createSword());
    public static final RegistryObject<Item> CREATION_SPLITTER = ITEMS.register("creation_splitter", () -> createSword());
    public static final RegistryObject<Item> CYBER_KATANA = ITEMS.register("cyber_katana", () -> createSword());
    public static final RegistryObject<Item> CYBER_SWORD = ITEMS.register("cyber_sword", () -> createSword());
    public static final RegistryObject<Item> CYBERNETIC_KATANA = ITEMS.register("cybernetic_katana", () -> createSword());
    public static final RegistryObject<Item> CYBERNETIC_SAWBLADE = ITEMS.register("cybernetic_sawblade", () -> createSword());
    public static final RegistryObject<Item> DARK_BLADE = ITEMS.register("dark_blade", () -> createSword());
    public static final RegistryObject<Item> DARK_CLEAVER = ITEMS.register("dark_cleaver", () -> createSword());
    public static final RegistryObject<Item> DEATH_KNIGHT_SWORD = ITEMS.register("death_knight_sword", () -> createSword());
    public static final RegistryObject<Item> DEMONIC_BLADE = ITEMS.register("demonic_blade", () -> createSword());
    public static final RegistryObject<Item> DEMONIC_CLEAVER = ITEMS.register("demonic_cleaver", () -> createSword());
    public static final RegistryObject<Item> DEMONLORD_SWORD = ITEMS.register("demonlord_sword", () -> createSword());
    public static final RegistryObject<Item> DIVINE_PUNISHER = ITEMS.register("divine_punisher", () -> createSword());
    public static final RegistryObject<Item> EDGE_OF_THE_ASTRALPLANE = ITEMS.register("edge_of_the_astralplane", () -> createSword());
    public static final RegistryObject<Item> EMBER_BLADE = ITEMS.register("ember_blade", () -> createSword());
    public static final RegistryObject<Item> EPIC_SWORD = ITEMS.register("epic_sword", () -> createSword());
    public static final RegistryObject<Item> ESTOC = ITEMS.register("estoc", () -> createSword());
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", () -> createSword());
    public static final RegistryObject<Item> FALLEN_GOD_SWORD = ITEMS.register("fallen_god_sword", () -> createSword());
    public static final RegistryObject<Item> FLORAL_LONGSWORD = ITEMS.register("floral_longsword", () -> createSword());
    public static final RegistryObject<Item> FLORAL_SABRE = ITEMS.register("floral_sabre", () -> createSword());
    public static final RegistryObject<Item> FROST_BLADE = ITEMS.register("frost_blade", () -> createSword());
    public static final RegistryObject<Item> HOLY_MOONLIGHT_SWORD = ITEMS.register("holy_moonlight_sword", () -> createSword());
    public static final RegistryObject<Item> HORNETS_NEEDLE = ITEMS.register("hornets_needle", () -> createSword());
    public static final RegistryObject<Item> KATANA = ITEMS.register("katana", () -> createSword());
    public static final RegistryObject<Item> LEGENDARY_SWORD = ITEMS.register("legendary_sword", () -> createSword());
    public static final RegistryObject<Item> LONGSWORD = ITEMS.register("longsword", () -> createSword());
    public static final RegistryObject<Item> MASAMUNE = ITEMS.register("masamune", () -> createSword());
    public static final RegistryObject<Item> MOLTEN_BLADE = ITEMS.register("molten_blade", () -> createSword());
    public static final RegistryObject<Item> MOLTEN_SWORD = ITEMS.register("molten_sword", () -> createSword());
    public static final RegistryObject<Item> MURAMASA = ITEMS.register("muramasa", () -> createSword());
    public static final RegistryObject<Item> MYSTICAL_SPELL_BLADE = ITEMS.register("mystical_spell_blade", () -> createSword());
    public static final RegistryObject<Item> MYTHIC_BLADE = ITEMS.register("mythic_blade", () -> createSword());
    public static final RegistryObject<Item> PHEONIX_GRACE = ITEMS.register("pheonix_grace", () -> createSword());
    public static final RegistryObject<Item> POWERFUSE_SWORD = ITEMS.register("powerfuse_sword", () -> createSword());
    public static final RegistryObject<Item> RIBBON_CLEAVER = ITEMS.register("ribbon_cleaver", () -> createSword());
    public static final RegistryObject<Item> RIVERS_OF_BLOOD = ITEMS.register("rivers_of_blood", () -> createSword());
    public static final RegistryObject<Item> ROYAL_RAPIER = ITEMS.register("royal_rapier", () -> createSword());
    public static final RegistryObject<Item> SABRE = ITEMS.register("sabre", () -> createSword());
    public static final RegistryObject<Item> SCISSOR_BLADE = ITEMS.register("scissor_blade", () -> createSword());
    public static final RegistryObject<Item> SCULK_CLEAVER = ITEMS.register("sculk_cleaver", () -> createSword());
    public static final RegistryObject<Item> SCULK_SWORD = ITEMS.register("sculk_sword", () -> createSword());
    public static final RegistryObject<Item> SILVERINE_BLADE = ITEMS.register("silverine_blade", () -> createSword());
    public static final RegistryObject<Item> SOUL_EDGE = ITEMS.register("soul_edge", () -> createSword());
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> createSword());
    public static final RegistryObject<Item> STORMBRINGER = ITEMS.register("stormbringer", () -> createSword());
    public static final RegistryObject<Item> TENGEN_BLADE = ITEMS.register("tengen_blade", () -> createSword());
    public static final RegistryObject<Item> TERRA_BLADE = ITEMS.register("terra_blade", () -> createSword());
    public static final RegistryObject<Item> THOUSAND_DEMON_DAGGERS = ITEMS.register("thousand_demon_daggers", () -> createSword());
    public static final RegistryObject<Item> THUNDERBRINGER = ITEMS.register("thunderbringer", () -> createSword());
    public static final RegistryObject<Item> TOXIC_BLADE = ITEMS.register("toxic_blade", () -> createSword());
    public static final RegistryObject<Item> UNIQUE_LONGSWORD_HOLY = ITEMS.register("unique_longsword_holy", () -> createSword());
    public static final RegistryObject<Item> VAMPIRIC_NEEDLE = ITEMS.register("vampiric_needle", () -> createSword());
    public static final RegistryObject<Item> WATCHER_CLAYMORE = ITEMS.register("watcher_claymore", () -> createSword());
    public static final RegistryObject<Item> WHISPERWIND = ITEMS.register("whisperwind", () -> createSword());
        
    // Greatsword
    public static final RegistryObject<Item> ANCIENT_ROYAL_GREATSWORD = ITEMS.register("ancient_royal_greatsword", () -> createGreatsword());
    public static final RegistryObject<Item> BRIMSTONE_CLAYMORE = ITEMS.register("brimstone_claymore", () -> createGreatsword());
    public static final RegistryObject<Item> DEMIGODS_UNHOLY_BLADE = ITEMS.register("demigods_unholy_blade", () -> createGreatsword());
    public static final RegistryObject<Item> DRAGON_SLAYING_BLADE = ITEMS.register("dragon_slaying_blade", () -> createGreatsword());
    public static final RegistryObject<Item> ENIGMA = ITEMS.register("enigma", () -> createGreatsword());
    public static final RegistryObject<Item> SOUL_DEVOURER = ITEMS.register("soul_devourer", () -> createGreatsword());
    public static final RegistryObject<Item> WAXWEAVER = ITEMS.register("waxweaver", () -> createGreatsword());
    public static final RegistryObject<Item> YORU = ITEMS.register("yoru", () -> createGreatsword());

    // Spear
    public static final RegistryObject<Item> AQUANTIC_TRIDENT = ITEMS.register("aquantic_trident", () -> createLance());
    public static final RegistryObject<Item> DEMIGODS_UNHOLY_HALBERD = ITEMS.register("demigods_unholy_halberd", () -> createLance());
    public static final RegistryObject<Item> DIVINE_JUSTICE = ITEMS.register("divine_justice", () -> createLance());
    public static final RegistryObject<Item> FALLEN_GOD_SPEAR = ITEMS.register("fallen_god_spear", () -> createLance());
    public static final RegistryObject<Item> FOREST_GUARDIAN_GLAIVE = ITEMS.register("forest_guardian_glaive", () -> createLance());
    public static final RegistryObject<Item> JADE_HALBERD = ITEMS.register("jade_halberd", () -> createLance());
    public static final RegistryObject<Item> PARTISAN = ITEMS.register("partisan", () -> createLance());
    public static final RegistryObject<Item> SENTINELS_WILL = ITEMS.register("sentinels_will", () -> createLance());
    public static final RegistryObject<Item> SUNBREAK = ITEMS.register("sunbreak", () -> createLance());
    public static final RegistryObject<Item> WICKPIERCER = ITEMS.register("wickpiercer", () -> createLance());

    // Axe
    public static final RegistryObject<Item> ARCANETHYST = ITEMS.register("arcanethyst", () -> createAxe());
    public static final RegistryObject<Item> DEMONLORD_GREATAXE = ITEMS.register("demonlord_greataxe", () -> createAxe());
    public static final RegistryObject<Item> DIVINE_AXE_RHITTA = ITEMS.register("divine_axe_rhitta", () -> createAxe());
    public static final RegistryObject<Item> HEARTHFLAME = ITEMS.register("hearthflame", () -> createAxe());
    public static final RegistryObject<Item> ICEWHISPER = ITEMS.register("icewhisper", () -> createAxe());
    public static final RegistryObject<Item> THUNDERBRAND = ITEMS.register("thunderbrand", () -> createAxe());

    // Chakram
    public static final RegistryObject<Item> AMETHYST_SHURIKEN = ITEMS.register("amethyst_shuriken", () -> createChakram());
    public static final RegistryObject<Item> ROYAL_CHAKRAM = ITEMS.register("royal_chakram", () -> createChakram());

    // Hammer
    public static final RegistryObject<Item> MJOLNIR = ITEMS.register("mjolnir", () -> createHammer());
    public static final RegistryObject<Item> POWERFUSE_HAMMER = ITEMS.register("powerfuse_hammer", () -> createHammer());

    // Knife
    public static final RegistryObject<Item> CYBERNETIC_KNIFE = ITEMS.register("cybernetic_knife", () -> createKnife());
    public static final RegistryObject<Item> DEATH_KNIGHT_DAGGER = ITEMS.register("death_knight_dagger", () -> createKnife());
    public static final RegistryObject<Item> SOUL_STEALER = ITEMS.register("soul_stealer", () -> createKnife());
    public static final RegistryObject<Item> WAKIZASHI = ITEMS.register("wakizashi", () -> createKnife());

    // Claw
    public static final RegistryObject<Item> CYBER_MANTIS_BLADE = ITEMS.register("cyber_mantis_blade", () -> createClaw());
    public static final RegistryObject<Item> SOUL_CLAWS = ITEMS.register("soul_claws", () -> createClaw());
    public static final RegistryObject<Item> SOUL_HARVESTER = ITEMS.register("soul_harvester", () -> createClaw());

    // Scythe
    public static final RegistryObject<Item> ABOMINABLE_SCYTHE = ITEMS.register("abominable_scythe", () -> createScythe());
    public static final RegistryObject<Item> BLOODY_DEATH = ITEMS.register("bloody_death", () -> createScythe());
    public static final RegistryObject<Item> CRESCENT_ROSE = ITEMS.register("crescent_rose", () -> createScythe());
    public static final RegistryObject<Item> DIVINE_REAPER = ITEMS.register("divine_reaper", () -> createScythe());
    public static final RegistryObject<Item> FROST_SCYTHE = ITEMS.register("frost_scythe", () -> createScythe());
    public static final RegistryObject<Item> FROST_SCYTHE_AXE = ITEMS.register("frost_scythe_axe", () -> createScythe());
    public static final RegistryObject<Item> MAGIC_SCYTHE = ITEMS.register("magic_scythe", () -> createScythe());
    public static final RegistryObject<Item> SCULK_SCYTHE = ITEMS.register("sculk_scythe", () -> createScythe());
    public static final RegistryObject<Item> SOUL_COLLECTOR = ITEMS.register("soul_collector", () -> createScythe());
    public static final RegistryObject<Item> SOUL_RENDER = ITEMS.register("soul_render", () -> createScythe());
    public static final RegistryObject<Item> WRAIHT_SCYTHE = ITEMS.register("wraiht_scythe", () -> createScythe());

    // Warglaive
    public static final RegistryObject<Item> WATCHING_WARGLAIVE = ITEMS.register("watching_warglaive", () -> createWarglaive());
    public static final RegistryObject<Item> STARS_EDGE = ITEMS.register("stars_edge", () -> createWarglaive());
    public static final RegistryObject<Item> STORMS_EDGE = ITEMS.register("storms_edge", () -> createWarglaive());

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> BLOOD_INGOT = ITEMS.register("blood_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> CYBER_INGOT = ITEMS.register("cyber_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> FROST_INGOT = ITEMS.register("frost_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> ROYAL_INGOT = ITEMS.register("royal_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> SCULK_INGOT = ITEMS.register("sculk_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> SOUL_INGOT = ITEMS.register("soul_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> TARTARUS_INGOT = ITEMS.register("tartarus_ingot", 
        () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB)));

    public static final RegistryObject<Item> VOID_INGOT = ITEMS.register("void_ingot", 
    () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB).fireResistant())); 
}
