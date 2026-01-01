package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.materials.ModArmorMaterials;
import com.odysseyswords.customswordmod.content.items.armor.sets.spartan.SpartanEliteArmorItem;
import com.odysseyswords.customswordmod.content.items.materials.ModMaterialItem;
import com.odysseyswords.customswordmod.content.items.weapons.axes.Arcanethyst;
import com.odysseyswords.customswordmod.content.items.weapons.axes.DemonlordGreataxe;
import com.odysseyswords.customswordmod.content.items.weapons.axes.DivineAxeRhitta;
import com.odysseyswords.customswordmod.content.items.weapons.axes.Fyralath;
import com.odysseyswords.customswordmod.content.items.weapons.axes.IceWhisper;
import com.odysseyswords.customswordmod.content.items.weapons.bows.OrionBow;
import com.odysseyswords.customswordmod.content.items.weapons.claws.FistOfFury;
import com.odysseyswords.customswordmod.content.items.weapons.claws.FuryOfAThousandsFists;
import com.odysseyswords.customswordmod.content.items.weapons.greatswords.AncientRoyalGreatsword;
import com.odysseyswords.customswordmod.content.items.weapons.greatswords.DivinePunisher;
import com.odysseyswords.customswordmod.content.items.weapons.greatswords.DragonSlayingBlade;
import com.odysseyswords.customswordmod.content.items.weapons.greatswords.SoulDevourer;
import com.odysseyswords.customswordmod.content.items.weapons.greatswords.Waxweaver;
import com.odysseyswords.customswordmod.content.items.weapons.hammers.Apophis;
import com.odysseyswords.customswordmod.content.items.weapons.hammers.Hearthflame;
import com.odysseyswords.customswordmod.content.items.weapons.hammers.PowerfuseHammer;
import com.odysseyswords.customswordmod.content.items.weapons.rapiers.FloralSabre;
import com.odysseyswords.customswordmod.content.items.weapons.rapiers.RoyalRapier;
import com.odysseyswords.customswordmod.content.items.weapons.rapiers.Sabre;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.AbominableScythe;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.Azhar;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.DivineReaper;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.FrostScythe;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.FrostScytheAxe;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.MagicScythe;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.SculkScythe;
import com.odysseyswords.customswordmod.content.items.weapons.scythes.SoulCollector;
import com.odysseyswords.customswordmod.content.items.weapons.spears.AquanticTrident;
import com.odysseyswords.customswordmod.content.items.weapons.spears.DivineJustice;
import com.odysseyswords.customswordmod.content.items.weapons.spears.FallenGodSpear;
import com.odysseyswords.customswordmod.content.items.weapons.spears.ForestGuardianGlaive;
import com.odysseyswords.customswordmod.content.items.weapons.spears.JadeHalberd;
import com.odysseyswords.customswordmod.content.items.weapons.spears.Sunbreak;
import com.odysseyswords.customswordmod.content.items.weapons.spears.Thunderwrath;
import com.odysseyswords.customswordmod.content.items.weapons.spears.Wickpiercer;
import com.odysseyswords.customswordmod.content.items.weapons.swords.AbominableBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.AbominableGreatsaber;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Apocalypse;
import com.odysseyswords.customswordmod.content.items.weapons.swords.AquanticSacredBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Ash;
import com.odysseyswords.customswordmod.content.items.weapons.swords.BladeOfAnubis;
import com.odysseyswords.customswordmod.content.items.weapons.swords.CorruptedMythicBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.CyberneticKatana;
import com.odysseyswords.customswordmod.content.items.weapons.swords.DarkBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.DarkCleaver;
import com.odysseyswords.customswordmod.content.items.weapons.swords.DeathKnightSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.DemonicBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.DemonlordSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Edar;
import com.odysseyswords.customswordmod.content.items.weapons.swords.EdgeOfTheAstralplane;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Excalibur;
import com.odysseyswords.customswordmod.content.items.weapons.swords.FallenGodSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.FloralLongsword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.FrostBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Ghaj;
import com.odysseyswords.customswordmod.content.items.weapons.swords.MoltenBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.MoltenSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Muramasa;
import com.odysseyswords.customswordmod.content.items.weapons.swords.MysticalSpellBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.MythicBlade;
import com.odysseyswords.customswordmod.content.items.weapons.swords.PhoenixGrace;
import com.odysseyswords.customswordmod.content.items.weapons.swords.RiversOfBlood;
import com.odysseyswords.customswordmod.content.items.weapons.swords.SculkCleaver;
import com.odysseyswords.customswordmod.content.items.weapons.swords.SculkSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.SteelSword;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Supernova;
import com.odysseyswords.customswordmod.content.items.weapons.swords.ThousandDemonDaggers;
import com.odysseyswords.customswordmod.content.items.weapons.swords.UniqueLongswordHoly;
import com.odysseyswords.customswordmod.content.items.weapons.swords.WatcherClaymore;
import com.odysseyswords.customswordmod.content.items.weapons.swords.Whisperwind;
import com.odysseyswords.customswordmod.content.items.weapons.warglaives.StarsEdge;
import com.odysseyswords.customswordmod.content.items.weapons.warglaives.StormsEdge;
import com.odysseyswords.customswordmod.content.items.weapons.warglaives.WatchingWarglaive;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            OdysseySwords.MODID);
    
    //===========================================        
    // Armor - ARMADURAS
    public static final RegistryObject<Item> SPARTAN_ELITE_HELMET = ITEMS.register("spartan_elite_helmet",
            () -> new SpartanEliteArmorItem(ModArmorMaterials.SPARTAN_ELITE, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1)));
    //===========================================
    
    //===========================================
    // Bows - ARCOS
    public static final RegistryObject<Item> ORION =
        ITEMS.register("orion", OrionBow::new);
    //===========================================

    //===========================================
    // Weapons - Swords - ESPADAS
    public static final RegistryObject<Item> ABOMINABLE_BLADE =
        ITEMS.register("abominable_blade", AbominableBlade::new);

    public static final RegistryObject<Item> ABOMINABLE_GREATSABER =
        ITEMS.register("abominable_greatsaber", AbominableGreatsaber::new);

    public static final RegistryObject<Item> APOCALYPSE =
        ITEMS.register("apocalypse", Apocalypse::new);

    public static final RegistryObject<Item> AQUANTIC_SACRED_BLADE =
        ITEMS.register("aquantic_sacred_blade", AquanticSacredBlade::new);

    public static final RegistryObject<Item> ASH =
        ITEMS.register("ash", Ash::new);

    public static final RegistryObject<Item> BLADE_OF_ANUBIS =
        ITEMS.register("blade_of_anubis", BladeOfAnubis::new);

    public static final RegistryObject<Item> CORRUPTED_MYTHIC_BLADE =
        ITEMS.register("corrupted_mythic_blade", CorruptedMythicBlade::new);
        
    public static final RegistryObject<Item> CYBERNETIC_KATANA =
        ITEMS.register("cybernetic_katana", CyberneticKatana::new);

    public static final RegistryObject<Item> DARK_BLADE =
        ITEMS.register("dark_blade", DarkBlade::new);

    public static final RegistryObject<Item> DARK_CLEAVER =
        ITEMS.register("dark_cleaver", DarkCleaver::new);

    public static final RegistryObject<Item> DEATH_KNIGHT_SWORD =
        ITEMS.register("death_knight_sword", DeathKnightSword::new);

    public static final RegistryObject<Item> DEMONIC_BLADE =
        ITEMS.register("demonic_blade", DemonicBlade::new);

    public static final RegistryObject<Item> DEMONLORD_SWORD =
        ITEMS.register("demonlord_sword", DemonlordSword::new);

    public static final RegistryObject<Item> EDAR =
        ITEMS.register("edar", Edar::new);

    public static final RegistryObject<Item> EDGE_OF_THE_ASTRALPLANE =
        ITEMS.register("edge_of_the_astralplane", EdgeOfTheAstralplane::new);
        
    public static final RegistryObject<Item> EXCALIBUR =
        ITEMS.register("excalibur", Excalibur::new);

    public static final RegistryObject<Item> FALLEN_GOD_SWORD =
        ITEMS.register("fallen_god_sword", FallenGodSword::new);

    public static final RegistryObject<Item> FLORAL_LONGSWORD =
        ITEMS.register("floral_longsword", FloralLongsword::new);

    public static final RegistryObject<Item> FROST_BLADE =
        ITEMS.register("frost_blade", FrostBlade::new);

    public static final RegistryObject<Item> GHAJ =
        ITEMS.register("ghaj", Ghaj::new);

    public static final RegistryObject<Item> MOLTEN_BLADE =
        ITEMS.register("molten_blade", MoltenBlade::new);

    public static final RegistryObject<Item> MOLTEN_SWORD =
        ITEMS.register("molten_sword", MoltenSword::new);

    public static final RegistryObject<Item> MURAMASA =
        ITEMS.register("muramasa", Muramasa::new);

    public static final RegistryObject<Item> MYTHIC_BLADE =
        ITEMS.register("mythic_blade", MythicBlade::new);

    public static final RegistryObject<Item> MYSTICAL_SPELL_BLADE =
        ITEMS.register("mystical_spell_blade", MysticalSpellBlade::new);

    public static final RegistryObject<Item> PHOENIX_GRACE =
        ITEMS.register("phoenix_grace", PhoenixGrace::new);

    public static final RegistryObject<Item> RIVERS_OF_BLOOD =
        ITEMS.register("rivers_of_blood", RiversOfBlood::new);

    public static final RegistryObject<Item> SCULK_CLEAVER =
        ITEMS.register("sculk_cleaver", SculkCleaver::new);

    public static final RegistryObject<Item> SCULK_SWORD =
        ITEMS.register("sculk_sword", SculkSword::new);

    public static final RegistryObject<Item> STEEL_SWORD =
        ITEMS.register("steel_sword", SteelSword::new);

    public static final RegistryObject<Item> SUPERNOVA =
        ITEMS.register("supernova", Supernova::new);

    public static final RegistryObject<Item> THOUSAND_DEMON_DAGGERS =
        ITEMS.register("thousand_demon_daggers", ThousandDemonDaggers::new);

    public static final RegistryObject<Item> UNIQUE_LONGSWORD_HOLY =
        ITEMS.register("unique_longsword_holy", UniqueLongswordHoly::new);

    public static final RegistryObject<Item> WATCHER_CLAYMORE =
        ITEMS.register("watcher_claymore", WatcherClaymore::new);

    public static final RegistryObject<Item> WHISPERWIND =
        ITEMS.register("whisperwind", Whisperwind::new);
    //===========================================

    //===========================================
    // Weapons - Greatswords - ESPADAS GRANDES
    public static final RegistryObject<Item> ANCIENT_ROYAL_GREATSWORD =
    ITEMS.register("ancient_royal_greatsword", AncientRoyalGreatsword::new);

    public static final RegistryObject<Item> DIVINE_PUNISHER =
    ITEMS.register("divine_punisher", DivinePunisher::new);

    public static final RegistryObject<Item> DRAGON_SLAYING_BLADE =
    ITEMS.register("dragon_slaying_blade", DragonSlayingBlade::new);

    public static final RegistryObject<Item> SOUL_DEVOURER =
    ITEMS.register("soul_devourer", SoulDevourer::new);

    public static final RegistryObject<Item> WAXWEAVER =
    ITEMS.register("waxweaver", Waxweaver::new);
    //===========================================

    //===========================================
    // Weapons - Rapiers - FLORETES
     public static final RegistryObject<Item> FLORAL_SABRE =
    ITEMS.register("floral_sabre", FloralSabre::new);

    public static final RegistryObject<Item> ROYAL_RAPIER =
    ITEMS.register("royal_rapier", RoyalRapier::new);

    public static final RegistryObject<Item> SABRE =
    ITEMS.register("sabre", Sabre::new);
    //===========================================

    //===========================================
    // Weapons - Spears - LANÇAS
    public static final RegistryObject<Item> AQUANTIC_TRIDENT =
    ITEMS.register("aquantic_trident", AquanticTrident::new);

    public static final RegistryObject<Item> DIVINE_JUSTICE =
    ITEMS.register("divine_justice", DivineJustice::new);

    public static final RegistryObject<Item> FALLEN_GOD_SPEAR =
    ITEMS.register("fallen_god_spear", FallenGodSpear::new);

    public static final RegistryObject<Item> FOREST_GUARDIAN_GLAIVE =
    ITEMS.register("forest_guardian_glaive", ForestGuardianGlaive::new);

    public static final RegistryObject<Item> JADE_HALBERD =
    ITEMS.register("jade_halberd", JadeHalberd::new);

    public static final RegistryObject<Item> SUNBREAK =
    ITEMS.register("sunbreak", Sunbreak::new);

    public static final RegistryObject<Item> THUNDERWRATH =
    ITEMS.register("thunderwrath", Thunderwrath::new);

    public static final RegistryObject<Item> WICKPIERCER =
    ITEMS.register("wickpiercer", Wickpiercer::new);
    //===========================================

    //===========================================
    // Weapons - Scythes - FOICES
    public static final RegistryObject<Item> ABOMINABLE_SCYTHE =
        ITEMS.register("abominable_scythe", AbominableScythe::new);

    public static final RegistryObject<Item> AZHAR =
        ITEMS.register("azhar", Azhar::new);

    public static final RegistryObject<Item> DIVINE_REAPER =
        ITEMS.register("divine_reaper", DivineReaper::new);

    public static final RegistryObject<Item> FROST_SCYTHE =
        ITEMS.register("frost_scythe", FrostScythe::new);

    public static final RegistryObject<Item> FROST_SCYTHE_AXE =
        ITEMS.register("frost_scythe_axe", FrostScytheAxe::new);

    public static final RegistryObject<Item> MAGIC_SCYTHE =
        ITEMS.register("magic_scythe", MagicScythe::new);

    public static final RegistryObject<Item> SCULK_SCYTHE =
        ITEMS.register("sculk_scythe", SculkScythe::new);

    public static final RegistryObject<Item> SOUL_COLLECTOR =
        ITEMS.register("soul_collector", SoulCollector::new);
    //===========================================

    //===========================================
    // Weapons - Axes - MACHADOS
    public static final RegistryObject<Item> ARCANETHYST =
    ITEMS.register("arcanethyst", Arcanethyst::new);

    public static final RegistryObject<Item> DEMONLORD_GREATAXE =
    ITEMS.register("demonlord_greataxe", DemonlordGreataxe::new);

    public static final RegistryObject<Item> DIVINE_AXE_RHITTA =
    ITEMS.register("divine_axe_rhitta", DivineAxeRhitta::new);

    public static final RegistryObject<Item> FYRALATH =
    ITEMS.register("fyralath", Fyralath::new);

    public static final RegistryObject<Item> ICEWHISPER =
    ITEMS.register("icewhisper", IceWhisper::new);
    //===========================================

    //===========================================
    // Weapons - Hammers - MARRETAS
    public static final RegistryObject<Item> APOPHIS =
    ITEMS.register("apophis", Apophis::new);

    public static final RegistryObject<Item> HEARTHFLAME =
    ITEMS.register("hearthflame", Hearthflame::new);

    public static final RegistryObject<Item> POWERFUSE_HAMMER =
    ITEMS.register("powerfuse_hammer", PowerfuseHammer::new);
    //===========================================
    
    //===========================================
    // Weapons - Warglaives - GLAIVES DE GUERRA
    public static final RegistryObject<Item> STARS_EDGE =
    ITEMS.register("stars_edge", StarsEdge::new);

    public static final RegistryObject<Item> STORMS_EDGE =
    ITEMS.register("storms_edge", StormsEdge::new);

    public static final RegistryObject<Item> WATCHING_WARGLAIVE =
    ITEMS.register("watching_warglaive", WatchingWarglaive::new);
    //===========================================

    //===========================================
    // Weapons - Claws - GARRAS
    public static final RegistryObject<Item> FIST_OF_FURY =
        ITEMS.register("fist_of_fury", FistOfFury::new);

    public static final RegistryObject<Item> FURY_OF_A_THOUSAND_FISTS =
        ITEMS.register("fury_of_a_thousand_fists", FuryOfAThousandsFists::new);
    //===========================================
    
    public static final RegistryObject<Item> BLOOD_INGOT = ITEMS.register("blood_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));

    public static final RegistryObject<Item> CRYSTAL_INGOT = ITEMS.register("crystal_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));

    public static final RegistryObject<Item> CYBER_INGOT = ITEMS.register("cyber_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> DIVINE_INGOT = ITEMS.register("divine_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> FROST_INGOT = ITEMS.register("frost_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> ROYAL_INGOT = ITEMS.register("royal_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));

    public static final RegistryObject<Item> SILVERINE_INGOT = ITEMS.register("silverine_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));

    public static final RegistryObject<Item> SCULK_INGOT = ITEMS.register("sculk_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> SOUL_INGOT = ITEMS.register("soul_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> STORM_INGOT = ITEMS.register("storm_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> TARTARUS_INGOT = ITEMS.register("tartarus_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));  

    public static final RegistryObject<Item> TOXIC_INGOT = ITEMS.register("toxic_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant())); 

    public static final RegistryObject<Item> VOID_INGOT = ITEMS.register("void_ingot",
    () -> new ModMaterialItem(new Item.Properties()
        .fireResistant()));

    // Method to register the DeferredRegister to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
