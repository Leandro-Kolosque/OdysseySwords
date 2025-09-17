package com.odysseyswords.customswordmod.util;

import net.minecraft.ChatFormatting;
import java.util.*;

public class TooltipStyleHelper {
    private static final Map<String, ChatFormatting> COLOR_MAP = new HashMap<>();
    private static final Map<String, String> WEAPON_TO_MATERIAL_MAP = new HashMap<>();

    static {
        // Configuração de cores para cada material
        COLOR_MAP.put("blood", ChatFormatting.DARK_RED);
        COLOR_MAP.put("cyber", ChatFormatting.RED);
        COLOR_MAP.put("frost", ChatFormatting.AQUA);
        COLOR_MAP.put("royal", ChatFormatting.YELLOW);
        COLOR_MAP.put("sculk", ChatFormatting.DARK_GRAY);
        COLOR_MAP.put("soul", ChatFormatting.GRAY);
        COLOR_MAP.put("tartarus", ChatFormatting.GOLD);
        COLOR_MAP.put("void", ChatFormatting.DARK_PURPLE);
        COLOR_MAP.put("toxic", ChatFormatting.DARK_GREEN);
        COLOR_MAP.put("silverine", ChatFormatting.WHITE);
        COLOR_MAP.put("divine", ChatFormatting.GOLD);
        COLOR_MAP.put("storm", ChatFormatting.BLUE);
        COLOR_MAP.put("crystal", ChatFormatting.LIGHT_PURPLE);

        // Mapeamento completo de armas para materiais
        // Blood Ingot
        addWeaponsToMaterial("blood",
            "fallen_god_spear", "creation_splitter", "demonic_blade",
            "demonic_cleaver", "corrupted_mythic_blade",
            "soul_devourer", "fallen_god_sword",
            "soul_collector", "rivers_of_blood");

        // Cyber Ingot
        addWeaponsToMaterial("cyber",
            "cybernetic_knife", "cyber_mantis_blade", "cyber_katana",
            "cyber_sword", "cybernetic_katana", "cybernetic_sawblade");

        // Frost Ingot
        addWeaponsToMaterial("frost",
            "icewhisper", "frost_scythe_axe",
            "holy_moonlight_sword", "frost_blade", "frost_scythe",
            "death_knight_dagger", "death_knight_sword");

        // Royal Ingot
        addWeaponsToMaterial("royal",
            "waxweaver", "divine_justice", "ancient_royal_greatsword",
            "wickpiercer", "royal_chakram", "royal_rapier",
            "divine_reaper", "divine_punisher", "divine_axe_rhitta",
            "unique_longsword_holy");

        // Sculk Ingot
        addWeaponsToMaterial("sculk",
            "sculk_cleaver", "sculk_sword", "stars_edge",
            "sentinels_will", "epic_sword", "yoru",
            "sculk_scythe", "excalibur", "forest_guardian_glaive",
            "soul_edge");

        // Soul Ingot
        addWeaponsToMaterial("soul",
            "soul_claws",
            "dark_blade", "dark_cleaver", "soul_stealer",
            "edge_of_the_astralplane");

        // Tartarus Ingot
        addWeaponsToMaterial("tartarus",
            "dragon_slaying_blade", "brimstone_claymore", "ember_blade",
            "pheonix_grace", "hearthflame", "molten_sword",
            "molten_blade", "sunbreak");

        // Void Ingot
        addWeaponsToMaterial("void",
            "abominable_blade", "abominable_greatsaber", "demonlord_sword",
            "muramasa", "arcanethyst", "demonlord_greataxe",
            "amethyst_shuriken", "abominable_scythe", "thousand_demon_daggers");

        // Toxic Ingot
        addWeaponsToMaterial("toxic",
            "bramblethorn", "enigma", "wraiht_scythe",
            "acid_demon", "toxic_blade",
            "soul_harvester");

        // Silverine Ingot
        addWeaponsToMaterial("silverine",
            "steel_sword", "longsword", "wakizashi",
            "sabre", "silverine_blade", "estoc",
            "masamune", "ribbon_cleaver",
            "katana", "blood_edge", "whisperwind");

        // Divine Ingot
        addWeaponsToMaterial("divine",
            "mjolnir", "ashuras_blade");

        // Storm Ingot
        addWeaponsToMaterial("storm",
            "magic_scythe", "watching_warglaive", "thunderbrand",
            "storms_edge", "blade_of_anubis", "stormbringer",
            "thunderbringer", "watcher_claymore", "tengen_blade");

        // Crystal Ingot
        addWeaponsToMaterial("crystal",
            "mythic_blade", "powerfuse_sword",
            "powerfuse_hammer", "aquantic_trident", "aquantic_sacred_blade",
            "floral_longsword", "floral_sabre", "mystical_spell_blade",
            "jade_halberd");
    }
    

    private static void addWeaponsToMaterial(String material, String... weaponIds) {
        for (String weaponId : weaponIds) {
            WEAPON_TO_MATERIAL_MAP.put(weaponId, material);
        }
    }

    public static Optional<String> getBaseMaterial(String weaponId) {
        // Remove o prefixo caso exista
        String cleanId = weaponId.replace("item.odysseyswords.", "");
        return Optional.ofNullable(WEAPON_TO_MATERIAL_MAP.get(cleanId));
    }

    public static ChatFormatting getColorForWeapon(String weaponId) {
        String cleanId = weaponId.replace("item.odysseyswords.", "");

        // Cores específicas para armas lendárias/únicas
        switch (cleanId) {
            case "fyralath": return ChatFormatting.RED;
            case "thunderwrath": return ChatFormatting.GOLD;
            case "supernova": return ChatFormatting.LIGHT_PURPLE;
            case "edar": return ChatFormatting.DARK_GRAY;
            case "ash": return ChatFormatting.YELLOW;
            case "ghaj": return ChatFormatting.DARK_GREEN;
            case "azhar": return ChatFormatting.DARK_PURPLE;
            case "orion": return ChatFormatting.AQUA;
            case "apophis": return ChatFormatting.DARK_RED;
            case "apocalypse": return ChatFormatting.BLUE; // Frostmourne
            case "fury_of_a_thousand_fists":
            case "fist_of_fury": return ChatFormatting.DARK_AQUA;
        }

        // Caso não seja uma arma especial, usa o material como fallback
        String material = WEAPON_TO_MATERIAL_MAP.get(cleanId);
            return material != null ? COLOR_MAP.getOrDefault(material, ChatFormatting.GRAY) : ChatFormatting.GRAY;
    }

    public static String getMaterialTooltipKey(String material) {
        return "item.odysseyswords.material_tooltip." + material;
    }

    public static ChatFormatting getColorFromId(String itemId) {
        String cleanId = itemId.replace("item.odysseyswords.", "").replace("_ingot", "");
        return COLOR_MAP.entrySet().stream()
            .filter(entry -> cleanId.contains(entry.getKey()))
            .map(Map.Entry::getValue)
            .findFirst()
            .orElse(ChatFormatting.GRAY);
    }
}