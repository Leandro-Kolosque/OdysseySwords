package com.odysseyswords.customswordmod.block.entity;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, OdysseySwords.MODID);

    public static final RegistryObject<BlockEntityType<MythicForgeBlockEntity>> MYTHIC_FORGE_BE =
            BLOCK_ENTITIES.register("mythic_forge_be", () ->
                    BlockEntityType.Builder.of(MythicForgeBlockEntity::new,
                            ModBlocks.MYTHIC_FORGE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}