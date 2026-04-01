package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.core.OdysseyConstants;
import com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge.MythicForgeBlock;
import com.odysseyswords.customswordmod.content.blocks.interactive.dice.DiceBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        OdysseyConstants.MOD_ID);

        public static final RegistryObject<Block> MYTHIC_FORGE = register(
                        "mythic_forge",
                        () -> new MythicForgeBlock(
                                        BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.METAL)
                                                        .strength(3.0F)
                                                        .requiresCorrectToolForDrops()
                                                        .sound(SoundType.METAL)
                                                        .noOcclusion()
                                                        .lightLevel(state -> 15)));

        public static final RegistryObject<Block> DICE = register(
                        "dice",
                        () -> new DiceBlock(
                                        BlockBehaviour.Properties.of()
                                                        .mapColor(MapColor.COLOR_PURPLE)
                                                        .strength(1.5F)
                                                        .sound(SoundType.STONE)));

        private static <T extends Block> RegistryObject<T> register(
                        String name,
                        Supplier<T> blockSupplier) {
                RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
                registerBlockItem(name, block);
                return block;
        }

        private static <T extends Block> void registerBlockItem(
                        String name,
                        RegistryObject<T> block) {
                ModItems.ITEMS.register(
                                name,
                                () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
