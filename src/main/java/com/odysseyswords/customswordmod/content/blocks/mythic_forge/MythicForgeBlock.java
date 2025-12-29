package com.odysseyswords.customswordmod.content.blocks.mythic_forge;

import com.odysseyswords.customswordmod.content.blocks.mythic_forge.MythicForgeBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;

import org.jetbrains.annotations.Nullable;

public class MythicForgeBlock extends HorizontalDirectionalBlock implements EntityBlock {

    public MythicForgeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any().setValue(FACING, Direction.NORTH)
        );
    }

    /* ========================= */
    /* BLOCK ENTITY              */
    /* ========================= */

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MythicForgeBlockEntity(pos, state);
    }

    /* ========================= */
    /* RENDER                    */
    /* ========================= */

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    /* ========================= */
    /* INTERAÇÃO / GUI           */
    /* ========================= */

    @Override
    public InteractionResult use(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof MythicForgeBlockEntity forgeBE) {
            NetworkHooks.openScreen(
                    (ServerPlayer) player,
                    forgeBE,
                    pos
            );
        }

        return InteractionResult.CONSUME;
    }

    /* ========================= */
    /* FACING / BLOCKSTATE       */
    /* ========================= */

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
