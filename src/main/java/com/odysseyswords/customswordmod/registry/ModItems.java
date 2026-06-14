package com.odysseyswords.customswordmod.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.ChatFormatting;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.definition.ArmorSetDefinition;
import com.odysseyswords.customswordmod.content.items.armor.material.ModArmorMaterials;
import com.odysseyswords.customswordmod.content.items.armor.traits.types.CyberTrait;
import com.odysseyswords.customswordmod.content.items.food.base.AbstractFoodItem;
import com.odysseyswords.customswordmod.content.items.food.foods.PopsicleFood;
import com.odysseyswords.customswordmod.content.items.materials.MaterialItemProperties;
import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.materials.ModMaterialItem;
import com.odysseyswords.customswordmod.content.items.misc.WeaponSmithingTemplateItem;
import com.odysseyswords.customswordmod.content.items.weapons.base.WeaponClass;
import com.odysseyswords.customswordmod.content.items.weapons.bows.OrionBow;
import com.odysseyswords.customswordmod.content.items.weapons.definition.GenericWeaponItem;
import com.odysseyswords.customswordmod.content.items.weapons.definition.WeaponDefinition;
import com.odysseyswords.customswordmod.registry.helpers.ArmorRegistryHelper;

import java.util.List;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OdysseySwords.MODID);

    // =========================================================================
    // ARMOR - ARMADURAS
    // =========================================================================
    public static final ArmorSetDefinition CYBER_DEF = new ArmorSetDefinition(
            "cyber", ModArmorMaterials.CYBER, List.of(new CyberTrait()));

    public static final ArmorSetDefinition TESTE_DEF = new ArmorSetDefinition(
            "teste", ModArmorMaterials.TESTE, List.of(new CyberTrait()));

    public static final ArmorSetDefinition EDU_DEF = new ArmorSetDefinition(
            "edu", ModArmorMaterials.EDU, List.of(new CyberTrait()));

    public static final List<RegistryObject<Item>> CYBER_SET =
            ArmorRegistryHelper.registerArmorSet(ITEMS, CYBER_DEF);

    public static final List<RegistryObject<Item>> TESTE_SET =
            ArmorRegistryHelper.registerArmorSet(ITEMS, TESTE_DEF);

    public static final List<RegistryObject<Item>> EDU_SET =
            ArmorRegistryHelper.registerArmorSet(ITEMS, EDU_DEF);

    // =========================================================================
    // BOWS - ARCOS
    // =========================================================================
    public static final RegistryObject<Item> ORION =
            ITEMS.register("orion", OrionBow::new);

    // =========================================================================
    // WEAPONS — SWORDS - ESPADAS
    // =========================================================================
    public static final RegistryObject<Item> ABOMINABLE_BLADE = weapon("abominable_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> ABOMINABLE_GREATSABER = weapon("abominable_greatsaber",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> APOCALYPSE = weapon("apocalypse",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> AQUANTIC_SACRED_BLADE = weapon("aquantic_sacred_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    // Ash tem tooltip de lore própria — passa a chave de tradução
    public static final RegistryObject<Item> ASH = weapon("ash",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant()
                    .tooltip("item.odysseyswords.ash.tooltip", ChatFormatting.YELLOW, ChatFormatting.ITALIC)
                    .build());

    public static final RegistryObject<Item> BLADE_OF_ANUBIS = weapon("blade_of_anubis",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> BRIMSTONE_CLAYMORE = weapon("brimstone_claymore",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> CORRUPTED_MYTHIC_BLADE = weapon("corrupted_mythic_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> CYBERNETIC_KATANA = weapon("cybernetic_katana",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.CYBER)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DARK_BLADE = weapon("dark_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DARK_CLEAVER = weapon("dark_cleaver",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DEATH_KNIGHT_SWORD = weapon("death_knight_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.SOUL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DEMONIC_BLADE = weapon("demonic_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DEMONLORD_SWORD = weapon("demonlord_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> EDAR = weapon("edar",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> EDGE_OF_THE_ASTRALPLANE = weapon("edge_of_the_astralplane",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> EXCALIBUR = weapon("excalibur",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.EPIC).fireResistant().build());

    public static final RegistryObject<Item> FALLEN_GOD_SWORD = weapon("fallen_god_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> FLORAL_LONGSWORD = weapon("floral_longsword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> FROST_BLADE = weapon("frost_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> GHAJ = weapon("ghaj",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> MOLTEN_BLADE = weapon("molten_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> MOLTEN_SWORD = weapon("molten_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> MURAMASA = weapon("muramasa",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> MYTHIC_BLADE = weapon("mythic_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> MYSTICAL_SPELL_BLADE = weapon("mystical_spell_blade",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.CRYSTAL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> PHOENIX_GRACE = weapon("phoenix_grace",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> RIVERS_OF_BLOOD = weapon("rivers_of_blood",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> SCULK_CLEAVER = weapon("sculk_cleaver",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.SCULK)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> SCULK_SWORD = weapon("sculk_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.SCULK)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> STEEL_SWORD = weapon("steel_sword",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.IRON, MaterialType.SILVERINE)
                    .rarity(Rarity.COMMON).build());

    public static final RegistryObject<Item> SUPERNOVA = weapon("supernova",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.STORM)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> THOUSAND_DEMON_DAGGERS = weapon("thousand_demon_daggers",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> UNIQUE_LONGSWORD_HOLY = weapon("unique_longsword_holy",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> WATCHER_CLAYMORE = weapon("watcher_claymore",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> WHISPERWIND = weapon("whisperwind",
            WeaponDefinition.of(WeaponClass.SWORD, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    // =========================================================================
    // WEAPONS — GREATSWORDS - ESPADAS GRANDES
    // =========================================================================
    public static final RegistryObject<Item> ANCIENT_ROYAL_GREATSWORD = weapon("ancient_royal_greatsword",
            WeaponDefinition.of(WeaponClass.GREATSWORD, Tiers.NETHERITE, MaterialType.ROYAL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DIVINE_PUNISHER = weapon("divine_punisher",
            WeaponDefinition.of(WeaponClass.GREATSWORD, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DRAGON_SLAYING_BLADE = weapon("dragon_slaying_blade",
            WeaponDefinition.of(WeaponClass.GREATSWORD, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.EPIC).fireResistant().build());

    public static final RegistryObject<Item> SOUL_DEVOURER = weapon("soul_devourer",
            WeaponDefinition.of(WeaponClass.GREATSWORD, Tiers.NETHERITE, MaterialType.SOUL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> WAXWEAVER = weapon("waxweaver",
            WeaponDefinition.of(WeaponClass.GREATSWORD, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    // =========================================================================
    // WEAPONS — RAPIERS - FLORETES
    // =========================================================================
    public static final RegistryObject<Item> FLORAL_SABRE = weapon("floral_sabre",
            WeaponDefinition.of(WeaponClass.RAPIER, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> ROYAL_RAPIER = weapon("royal_rapier",
            WeaponDefinition.of(WeaponClass.RAPIER, Tiers.NETHERITE, MaterialType.ROYAL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> SABRE = weapon("sabre",
            WeaponDefinition.of(WeaponClass.RAPIER, Tiers.IRON, MaterialType.SILVERINE)
                    .rarity(Rarity.COMMON).build());

    // =========================================================================
    // WEAPONS — SPEARS - LANÇAS
    // =========================================================================
    public static final RegistryObject<Item> AQUANTIC_TRIDENT = weapon("aquantic_trident",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> DEATH_SPEAR = weapon("death_spear",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.NETHERITE, MaterialType.SOUL)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DIVINE_JUSTICE = weapon("divine_justice",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> FALLEN_GOD_SPEAR = weapon("fallen_god_spear",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> FOREST_GUARDIAN_GLAIVE = weapon("forest_guardian_glaive",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> GONDOR_SPEAR = weapon("gondor_spear",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.IRON, MaterialType.SILVERINE)
                    .rarity(Rarity.COMMON).build());

    public static final RegistryObject<Item> JADE_HALBERD = weapon("jade_halberd",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> SUNBREAK = weapon("sunbreak",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> THUNDERWRATH = weapon("thunderwrath",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.NETHERITE, MaterialType.STORM)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> WICKPIERCER = weapon("wickpiercer",
            WeaponDefinition.of(WeaponClass.SPEAR, Tiers.DIAMOND, MaterialType.TOXIC)
                    .rarity(Rarity.UNCOMMON).build());

    // =========================================================================
    // WEAPONS — SCYTHES - FOICES
    // =========================================================================
    public static final RegistryObject<Item> ABOMINABLE_SCYTHE = weapon("abominable_scythe",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> AZHAR = weapon("azhar",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DIVINE_REAPER = weapon("divine_reaper",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> FROST_SCYTHE = weapon("frost_scythe",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> FROST_SCYTHE_AXE = weapon("frost_scythe_axe",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> MAGIC_SCYTHE = weapon("magic_scythe",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.DIAMOND, MaterialType.CRYSTAL)
                    .rarity(Rarity.UNCOMMON).build());

    public static final RegistryObject<Item> SCULK_SCYTHE = weapon("sculk_scythe",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.NETHERITE, MaterialType.SCULK)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> SOUL_COLLECTOR = weapon("soul_collector",
            WeaponDefinition.of(WeaponClass.SCYTHE, Tiers.NETHERITE, MaterialType.SOUL)
                    .rarity(Rarity.RARE).fireResistant().build());

    // =========================================================================
    // WEAPONS — AXES - MACHADOS
    // =========================================================================
    public static final RegistryObject<Item> ARCANETHYST = weapon("arcanethyst",
            WeaponDefinition.of(WeaponClass.AXE, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DEMONLORD_GREATAXE = weapon("demonlord_greataxe",
            WeaponDefinition.of(WeaponClass.AXE, Tiers.NETHERITE, MaterialType.BLOOD)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> DIVINE_AXE_RHITTA = weapon("divine_axe_rhitta",
            WeaponDefinition.of(WeaponClass.AXE, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.EPIC).fireResistant().build());

    public static final RegistryObject<Item> FYRALATH = weapon("fyralath",
            WeaponDefinition.of(WeaponClass.AXE, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> ICEWHISPER = weapon("icewhisper",
            WeaponDefinition.of(WeaponClass.AXE, Tiers.DIAMOND, MaterialType.FROST)
                    .rarity(Rarity.UNCOMMON).build());

    // =========================================================================
    // WEAPONS — HAMMERS - MARRETAS
    // =========================================================================
    public static final RegistryObject<Item> APOPHIS = weapon("apophis",
            WeaponDefinition.of(WeaponClass.HAMMER, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> HEARTHFLAME = weapon("hearthflame",
            WeaponDefinition.of(WeaponClass.HAMMER, Tiers.NETHERITE, MaterialType.TARTARUS)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> POWERFUSE_HAMMER = weapon("powerfuse_hammer",
            WeaponDefinition.of(WeaponClass.HAMMER, Tiers.NETHERITE, MaterialType.CYBER)
                    .rarity(Rarity.RARE).fireResistant().build());

    // =========================================================================
    // WEAPONS — WARGLAIVES - GLAIVES DE GUERRA
    // =========================================================================
    public static final RegistryObject<Item> STARS_EDGE = weapon("stars_edge",
            WeaponDefinition.of(WeaponClass.WARGLAIVE, Tiers.NETHERITE, MaterialType.DIVINE)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> STORMS_EDGE = weapon("storms_edge",
            WeaponDefinition.of(WeaponClass.WARGLAIVE, Tiers.NETHERITE, MaterialType.STORM)
                    .rarity(Rarity.RARE).fireResistant().build());

    public static final RegistryObject<Item> WATCHING_WARGLAIVE = weapon("watching_warglaive",
            WeaponDefinition.of(WeaponClass.WARGLAIVE, Tiers.NETHERITE, MaterialType.VOID)
                    .rarity(Rarity.RARE).fireResistant().build());

    // =========================================================================
    // MATERIALS - MATERIAIS
    // =========================================================================
    public static final RegistryObject<Item> BLOOD_INGOT = ITEMS.register("blood_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.BLOOD));

    public static final RegistryObject<Item> CRYSTAL_INGOT = ITEMS.register("crystal_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.CRYSTAL));

    public static final RegistryObject<Item> CYBER_INGOT = ITEMS.register("cyber_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.CYBER));

    public static final RegistryObject<Item> DIVINE_INGOT = ITEMS.register("divine_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.DIVINE));

    public static final RegistryObject<Item> FROST_INGOT = ITEMS.register("frost_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.FROST));

    public static final RegistryObject<Item> ROYAL_INGOT = ITEMS.register("royal_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.ROYAL));

    public static final RegistryObject<Item> SCULK_INGOT = ITEMS.register("sculk_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.SCULK));

    public static final RegistryObject<Item> SILVERINE_INGOT = ITEMS.register("silverine_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.SILVERINE));

    public static final RegistryObject<Item> SOUL_INGOT = ITEMS.register("soul_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.SOUL));

    public static final RegistryObject<Item> STORM_INGOT = ITEMS.register("storm_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.STORM));

    public static final RegistryObject<Item> TARTARUS_INGOT = ITEMS.register("tartarus_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.TARTARUS));

    public static final RegistryObject<Item> TOXIC_INGOT = ITEMS.register("toxic_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.TOXIC));

    public static final RegistryObject<Item> VOID_INGOT = ITEMS.register("void_ingot",
            () -> new ModMaterialItem(MaterialItemProperties.ingot(), MaterialType.VOID));

    public static final RegistryObject<Item> PHOENIX_FEATHER = ITEMS.register("phoenix_feather",
            () -> new ModMaterialItem(MaterialItemProperties.drop(), MaterialType.TARTARUS));

    public static final RegistryObject<Item> BLOOD = ITEMS.register("blood",
            () -> new ModMaterialItem(MaterialItemProperties.essence(), MaterialType.BLOOD));

    // =========================================================================
    // TEMPLATES - TEMPLATES
    // =========================================================================
    public static final RegistryObject<Item> AXE_SMITHING_TEMPLATE = ITEMS.register("axe_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> GREATSWORD_SMITHING_TEMPLATE = ITEMS.register("greatsword_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HAMMER_SMITHING_TEMPLATE = ITEMS.register("hammer_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RAPIER_SMITHING_TEMPLATE = ITEMS.register("rapier_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SCYTHE_SMITHING_TEMPLATE = ITEMS.register("scythe_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPEAR_SMITHING_TEMPLATE = ITEMS.register("spear_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWORD_SMITHING_TEMPLATE = ITEMS.register("sword_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WARGLAIVE_SMITHING_TEMPLATE = ITEMS.register("warglaive_smithing_template",
            () -> new WeaponSmithingTemplateItem(new Item.Properties().stacksTo(1)));

    // =========================================================================
    // FOODS - COMIDAS
    // =========================================================================
    public static final RegistryObject<Item> POPSICLE = ITEMS.register("popsicle",
            () -> new AbstractFoodItem(PopsicleFood.POPSICLE));

    // =========================================================================
    // Registration
    // =========================================================================
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // =========================================================================
    // Helper interno
    // =========================================================================
    private static RegistryObject<Item> weapon(String id, WeaponDefinition definition) {
        return ITEMS.register(id, () -> new GenericWeaponItem(definition));
    }
}