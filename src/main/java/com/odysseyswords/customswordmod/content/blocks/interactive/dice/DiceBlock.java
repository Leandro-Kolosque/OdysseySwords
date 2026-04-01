package com.odysseyswords.customswordmod.content.blocks.interactive.dice;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DiceBlock extends Block {

    public DiceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);

        // Evita execução desnecessária
        if (level.isClientSide) return;

        // Só executa se o bloco realmente foi removido (não substituído pelo mesmo)
        if (state.getBlock() == newState.getBlock()) return;

        Player player = level.getNearestPlayer(
                pos.getX() + 0.5,
                pos.getY() + 0.5,
                pos.getZ() + 0.5,
                5.0,
                false
        );

        if (player == null) return;

        ItemStack tool = player.getMainHandItem();

        boolean isCreative = player.getAbilities().instabuild;

        boolean hasSilkTouch = !tool.isEmpty() &&
                EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SILK_TOUCH, tool) > 0;

        /*
         * Regras finais:
         * Creative → sempre executa
         * Survival:
         *   Silk Touch → não executa
         *   Sem Silk Touch → executa
         */
        if (isCreative || !hasSilkTouch) {
            DiceLogic.execute(level, pos, player);
        }
    }
}