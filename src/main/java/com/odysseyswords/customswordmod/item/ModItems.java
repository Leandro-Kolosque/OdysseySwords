package com.odysseyswords.customswordmod.item;

import com.odysseyswords.customswordmod.OdysseySwords;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OdysseySwords.MODID);

    // Helper method to create SwordItem properties
    private static Item.Properties swordProperties() {
        return new Item.Properties().tab(ModCreativeModeTab.ODYSSEY_TAB).fireResistant();
    }

    // Item Registrations (Reconstructed based on previous list)
    public static final RegistryObject<Item> ABOMINABLE_BLADE = ITEMS.register("abominable_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ABOMINABLE_GREATSABER = ITEMS.register("abominable_greatsaber", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ABOMINABLE_SCYTHE = ITEMS.register("abominable_scythe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ACID_DEMON = ITEMS.register("acid_demon", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> AMETHYST_SHURIKEN = ITEMS.register("amethyst_shuriken", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ANCIENT_ROYAL_GREATSWORD = ITEMS.register("ancient_royal_greatsword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> AQUANTIC_SACRED_BLADE = ITEMS.register("aquantic_sacred_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> AQUANTIC_TRIDENT = ITEMS.register("aquantic_trident", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ARCANETHYST = ITEMS.register("arcanethyst", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ASHURAS_BLADE = ITEMS.register("ashuras_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> BLADE_OF_ANUBIS = ITEMS.register("blade_of_anubis", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> BLOOD_EDGE = ITEMS.register("blood_edge", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> BLOODY_DEATH = ITEMS.register("bloody_death", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> BRAMBLETHORN = ITEMS.register("bramblethorn", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> BRIMSTONE_CLAYMORE = ITEMS.register("brimstone_claymore", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CARIAN_SWORD = ITEMS.register("carian_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CHRONO_BLADE = ITEMS.register("chrono_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CORRUPTED_MYTHIC_BLADE = ITEMS.register("corrupted_mythic_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CREATION_SPLITTER = ITEMS.register("creation_splitter", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CRESCENT_ROSE = ITEMS.register("crescent_rose", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBER_KATANA = ITEMS.register("cyber_katana", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBER_MANTIS_BLADE = ITEMS.register("cyber_mantis_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBER_SWORD = ITEMS.register("cyber_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBERNETIC_KATANA = ITEMS.register("cybernetic_katana", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBERNETIC_KNIFE = ITEMS.register("cybernetic_knife", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> CYBERNETIC_SAWBLADE = ITEMS.register("cybernetic_sawblade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DARK_BLADE = ITEMS.register("dark_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DARK_CLEAVER = ITEMS.register("dark_cleaver", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEATH_KNIGHT_DAGGER = ITEMS.register("death_knight_dagger", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEATH_KNIGHT_SWORD = ITEMS.register("death_knight_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMIGODS_UNHOLY_BLADE = ITEMS.register("demigods_unholy_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMIGODS_UNHOLY_HALBERD = ITEMS.register("demigods_unholy_halberd", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMONIC_BLADE = ITEMS.register("demonic_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMONIC_CLEAVER = ITEMS.register("demonic_cleaver", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMONLORD_GREATAXE = ITEMS.register("demonlord_greataxe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DEMONLORD_SWORD = ITEMS.register("demonlord_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DIVINE_AXE_RHITTA = ITEMS.register("divine_axe_rhitta", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DIVINE_JUSTICE = ITEMS.register("divine_justice", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DIVINE_PUNISHER = ITEMS.register("divine_punisher", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DIVINE_REAPER = ITEMS.register("divine_reaper", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> DRAGON_SLAYING_BLADE = ITEMS.register("dragon_slaying_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> EDGE_OF_THE_ASTRALPLANE = ITEMS.register("edge_of_the_astralplane", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> EMBER_BLADE = ITEMS.register("ember_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ENIGMA = ITEMS.register("enigma", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> EPIC_SWORD = ITEMS.register("epic_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ESTOC = ITEMS.register("estoc", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> EXCALIBUR = ITEMS.register("excalibur", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FALLEN_GOD_SPEAR = ITEMS.register("fallen_god_spear", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FALLEN_GOD_SWORD = ITEMS.register("fallen_god_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FLORAL_LONGSWORD = ITEMS.register("floral_longsword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FLORAL_SABRE = ITEMS.register("floral_sabre", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FOREST_GUARDIAN_GLAIVE = ITEMS.register("forest_guardian_glaive", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FROST_BLADE = ITEMS.register("frost_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FROST_SCYTHE = ITEMS.register("frost_scythe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> FROST_SCYTHE_AXE = ITEMS.register("frost_scythe_axe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> HEARTHFLAME = ITEMS.register("hearthflame", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> HOLY_MOONLIGHT_SWORD = ITEMS.register("holy_moonlight_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> HORNETS_NEEDLE = ITEMS.register("hornets_needle", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ICEWHISPER = ITEMS.register("icewhisper", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> JADE_HALBERD = ITEMS.register("jade_halberd", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> KATANA = ITEMS.register("katana", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> LEGENDARY_SWORD = ITEMS.register("legendary_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> LONGSWORD = ITEMS.register("longsword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MAGIC_SCYTHE = ITEMS.register("magic_scythe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MASAMUNE = ITEMS.register("masamune", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MJOLNIR = ITEMS.register("mjolnir", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MOLTEN_BLADE = ITEMS.register("molten_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MOLTEN_SWORD = ITEMS.register("molten_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MURAMASA = ITEMS.register("muramasa", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MYSTICAL_SPELL_BLADE = ITEMS.register("mystical_spell_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> MYTHIC_BLADE = ITEMS.register("mythic_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> PARTISAN = ITEMS.register("partisan", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> PHEONIX_GRACE = ITEMS.register("pheonix_grace", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> POWERFUSE_HAMMER = ITEMS.register("powerfuse_hammer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> POWERFUSE_SWORD = ITEMS.register("powerfuse_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> RIBBON_CLEAVER = ITEMS.register("ribbon_cleaver", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> RIVERS_OF_BLOOD = ITEMS.register("rivers_of_blood", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ROYAL_CHAKRAM = ITEMS.register("royal_chakram", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> ROYAL_RAPIER = ITEMS.register("royal_rapier", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SABRE = ITEMS.register("sabre", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SCISSOR_BLADE = ITEMS.register("scissor_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SCULK_CLEAVER = ITEMS.register("sculk_cleaver", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SCULK_SCYTHE = ITEMS.register("sculk_scythe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SCULK_SWORD = ITEMS.register("sculk_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SENTINELS_WILL = ITEMS.register("sentinels_will", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SILVERINE_BLADE = ITEMS.register("silverine_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_CLAWS = ITEMS.register("soul_claws", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_COLLECTOR = ITEMS.register("soul_collector", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_DEVOURER = ITEMS.register("soul_devourer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_EDGE = ITEMS.register("soul_edge", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_HARVESTER = ITEMS.register("soul_harvester", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_RENDER = ITEMS.register("soul_render", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SOUL_STEALER = ITEMS.register("soul_stealer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> STARS_EDGE = ITEMS.register("stars_edge", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> STORMBRINGER = ITEMS.register("stormbringer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> STORMS_EDGE = ITEMS.register("storms_edge", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> SUNBREAK = ITEMS.register("sunbreak", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> TENGEN_BLADE = ITEMS.register("tengen_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> TERRA_BLADE = ITEMS.register("terra_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> THOUSAND_DEMON_DAGGERS = ITEMS.register("thousand_demon_daggers", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> THUNDERBRAND = ITEMS.register("thunderbrand", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> THUNDERBRINGER = ITEMS.register("thunderbringer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> TOXIC_BLADE = ITEMS.register("toxic_blade", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> UNIQUE_LONGSWORD_HOLY = ITEMS.register("unique_longsword_holy", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> VAMPIRIC_NEEDLE = ITEMS.register("vampiric_needle", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WAKIZASHI = ITEMS.register("wakizashi", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WATCHER_CLAYMORE = ITEMS.register("watcher_claymore", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WATCHING_WARGLAIVE = ITEMS.register("watching_warglaive", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WAXWEAVER = ITEMS.register("waxweaver", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WHISPERWIND = ITEMS.register("whisperwind", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WICKPIERCER = ITEMS.register("wickpiercer", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> WRAIHT_SCYTHE = ITEMS.register("wraiht_scythe", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));
    public static final RegistryObject<Item> YORU = ITEMS.register("yoru", () -> new SwordItem(Tiers.NETHERITE, 5, -2.8F, swordProperties()));

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

