package com.odysseyswords.customswordmod.content.blocks.interactive.dice;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;

import java.util.List;

public class DiceLogic {

    private static final Logger LOGGER = LogUtils.getLogger();

    public static void execute(Level level, BlockPos pos, Player player) {
        if (!(level instanceof ServerLevel serverLevel)) return;

        RandomSource random = serverLevel.getRandom();

        // 50% chance de creeper carregado
        if (random.nextFloat() < 0.50f) {
            LOGGER.info("Dado ativado: spawnando creeper carregado em {}", pos);
            spawnChargedCreeper(serverLevel, pos);
            return;
        }

        // Drop ruim ponderado
        ItemStack drop = getRandomBadDrop(random);
        Block.popResource(serverLevel, pos, drop);
    }

    // ===============================
    // SISTEMA DE DROPS PONDERADOS
    // ===============================

    private static final java.util.Random RANDOM = new java.util.Random();

    private static final List<WeightedDrop> BAD_DROPS = List.of(
            new WeightedDrop(30, () -> new ItemStack(Items.ROTTEN_FLESH, 1 + RANDOM.nextInt(3))),
            new WeightedDrop(20, () -> new ItemStack(Items.SPIDER_EYE, 1 + RANDOM.nextInt(2))),
            new WeightedDrop(15, () -> new ItemStack(Items.POISONOUS_POTATO, 1)),
            new WeightedDrop(10, () -> new ItemStack(Items.CACTUS, 1)),
            new WeightedDrop(10, () -> new ItemStack(Items.INK_SAC, 1)),
            new WeightedDrop(15, () -> new ItemStack(Items.STICK, 1 + RANDOM.nextInt(2)))
    );


    private static ItemStack getRandomBadDrop(RandomSource random) {
        int totalWeight = BAD_DROPS.stream().mapToInt(WeightedDrop::getWeight).sum();

        int roll = random.nextInt(totalWeight);
        int cumulative = 0;

        for (WeightedDrop drop : BAD_DROPS) {
            cumulative += drop.getWeight();
            if (roll < cumulative) {
                return drop.create();
            }
        }

        return ItemStack.EMPTY;
    }

    // ===============================
    // CREEPER
    // ===============================

    private static void spawnChargedCreeper(ServerLevel level, BlockPos pos) {
        Creeper creeper = EntityType.CREEPER.create(level);
        if (creeper == null) return;

        creeper.moveTo(
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                level.getRandom().nextFloat() * 360F,
                0
        );

        creeper.setPersistenceRequired();

        float originalMaxHealth = creeper.getMaxHealth();
        creeper.getAttribute(Attributes.MAX_HEALTH).setBaseValue(100.0);
        creeper.setHealth(100.0f);

        level.addFreshEntity(creeper);

        LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
        if (lightning != null) {
            lightning.moveTo(creeper.getX(), creeper.getY(), creeper.getZ());
            level.addFreshEntity(lightning);
        }

        level.getServer().execute(() -> {
            if (creeper.isAlive()) {
                creeper.getAttribute(Attributes.MAX_HEALTH).setBaseValue(originalMaxHealth);
                creeper.setHealth(originalMaxHealth);
            }
        });
    }
}