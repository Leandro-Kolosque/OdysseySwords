package com.odysseyswords.customswordmod.content.items.materials;

import java.util.*;

public final class MaterialDefinitions {

    private static final Map<String, String> WEAPON_TO_MATERIAL = new HashMap<>();

    static {
        register("blood", "fallen_god_spear", "demonic_blade",
            "corrupted_mythic_blade", "soul_devourer",
            "fallen_god_sword", "soul_collector", "rivers_of_blood");

        register("cyber", "cybernetic_katana");

        register("frost", "icewhisper", "frost_scythe_axe",
            "frost_blade", "frost_scythe", "death_knight_sword");

        register("royal", "waxweaver", "divine_justice",
            "ancient_royal_greatsword", "wickpiercer",
            "royal_rapier", "divine_reaper", "divine_punisher",
            "divine_axe_rhitta", "unique_longsword_holy");

        register("sculk", "sculk_cleaver", "sculk_sword",
            "stars_edge", "sculk_scythe",
            "excalibur", "forest_guardian_glaive");

        register("soul", "dark_blade", "dark_cleaver",
            "edge_of_the_astralplane");

        register("tartarus", "dragon_slaying_blade",
            "brimstone_claymore", "phoenix_grace",
            "hearthflame", "molten_sword",
            "molten_blade", "sunbreak");

        register("void", "abominable_blade", "abominable_greatsaber",
            "demonlord_sword", "muramasa", "arcanethyst",
            "demonlord_greataxe", "abominable_scythe",
            "thousand_demon_daggers");

        register("silverine", "steel_sword", "sabre", "whisperwind");

        register("storm", "magic_scythe", "watching_warglaive",
            "storms_edge", "blade_of_anubis", "watcher_claymore");

        register("crystal", "mythic_blade", "powerfuse_hammer",
            "aquantic_trident", "aquantic_sacred_blade",
            "floral_longsword", "floral_sabre",
            "mystical_spell_blade", "jade_halberd");
    }

    private static void register(String material, String... weapons) {
        for (String weapon : weapons) {
            WEAPON_TO_MATERIAL.put(weapon, material);
        }
    }

    public static Optional<String> getMaterial(String weaponId) {
        return Optional.ofNullable(WEAPON_TO_MATERIAL.get(weaponId));
    }
}
