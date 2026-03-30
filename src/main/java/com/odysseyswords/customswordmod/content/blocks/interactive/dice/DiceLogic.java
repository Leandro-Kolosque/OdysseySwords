package com.odysseyswords.customswordmod.content.blocks.interactive.dice;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class DiceLogic {

    private static final org.slf4j.Logger LOGGER = com.mojang.logging.LogUtils.getLogger();

    public static void execute(Level level, BlockPos pos, Player player) {
        if (!(level instanceof ServerLevel serverLevel)) return;

        RandomSource random = serverLevel.getRandom();

        // 50% de chance de spawnar creeper carregado (ajuste conforme desejar)
        if (random.nextFloat() < 0.50f) {
            LOGGER.info("Dado ativado: spawnando creeper carregado em {}", pos);
            spawnChargedCreeper(serverLevel, pos);
            return;
        }

        // Drops ruins com distribuição ponderada
        int roll = random.nextInt(100);
        ItemStack drop;

        if (roll < 30) {
            drop = new ItemStack(Items.ROTTEN_FLESH, 1 + random.nextInt(3));
        } else if (roll < 50) {
            drop = new ItemStack(Items.SPIDER_EYE, 1 + random.nextInt(2));
        } else if (roll < 65) {
            drop = new ItemStack(Items.POISONOUS_POTATO, 1);
        } else if (roll < 75) {
            drop = new ItemStack(Items.CACTUS, 1);
        } else if (roll < 85) {
            drop = new ItemStack(Items.INK_SAC, 1);
        } else {
            drop = new ItemStack(Items.STICK, 1 + random.nextInt(2));
        }

        Block.popResource(serverLevel, pos, drop);
    }

    private static void spawnChargedCreeper(ServerLevel level, BlockPos pos) {
        Creeper creeper = EntityType.CREEPER.create(level);
        if (creeper == null) return;

        // Posiciona o creeper meio bloco acima para não ficar dentro do chão
        creeper.moveTo(
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                level.getRandom().nextFloat() * 360F,
                0);
        creeper.setPersistenceRequired();

        // Aumenta a vida temporariamente para garantir que o creeper sobreviva ao raio
        float originalMaxHealth = creeper.getMaxHealth();
        creeper.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(100.0);
        creeper.setHealth(100.0f);
        level.addFreshEntity(creeper);

        // Cria um raio na posição do creeper
        LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
        if (lightning != null) {
            lightning.moveTo(creeper.getX(), creeper.getY(), creeper.getZ());
            level.addFreshEntity(lightning);
        }

        // Após o raio, restaura a vida original do creeper
        level.getServer().execute(() -> {
            if (creeper.isAlive()) {
                creeper.getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH).setBaseValue(originalMaxHealth);
                creeper.setHealth(originalMaxHealth);
            }
        });
    }
}