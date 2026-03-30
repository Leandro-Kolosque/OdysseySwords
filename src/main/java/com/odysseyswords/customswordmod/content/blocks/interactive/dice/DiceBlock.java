package com.odysseyswords.customswordmod.content.blocks.interactive.dice;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DiceBlock extends Block {

    public DiceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            DiceLogic.execute(level, pos, player);
        }
        super.playerWillDestroy(level, pos, state, player);
    }
}