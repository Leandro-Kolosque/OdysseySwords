package com.odysseyswords.customswordmod.registry;

import com.odysseyswords.customswordmod.core.OdysseyConstants;
import com.odysseyswords.customswordmod.content.blocks.mythic_forge.MythicForgeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(
                    ForgeRegistries.BLOCK_ENTITY_TYPES,
                    OdysseyConstants.MOD_ID
            );

    public static final RegistryObject<BlockEntityType<MythicForgeBlockEntity>> MYTHIC_FORGE =
            BLOCK_ENTITIES.register(
                    "mythic_forge",
                    () -> BlockEntityType.Builder
                            .of(
                                    MythicForgeBlockEntity::new,
                                    ModBlocks.MYTHIC_FORGE.get()
                            )
                            .build(null)
            );

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
