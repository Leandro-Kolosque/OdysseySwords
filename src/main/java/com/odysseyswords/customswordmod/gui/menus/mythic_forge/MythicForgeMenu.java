package com.odysseyswords.customswordmod.gui.menus.mythic_forge;

import com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge.MythicForgeBlockEntity;
import com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge.MythicForgeLogic;
import com.odysseyswords.customswordmod.registry.ModBlocks;
import com.odysseyswords.customswordmod.registry.ModMenuTypes;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class MythicForgeMenu extends AbstractContainerMenu {

    private final MythicForgeBlockEntity blockEntity;
    private final Level level;

    public MythicForgeMenu(int id, Inventory inv, FriendlyByteBuf buf) {
        this(id, inv, inv.player.level().getBlockEntity(buf.readBlockPos()));
    }

    public MythicForgeMenu(int id, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.MYTHIC_FORGE.get(), id);

        this.blockEntity = (MythicForgeBlockEntity) entity;
        this.level = inv.player.level();

        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 0, 21, 60));
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 1, 51, 60));
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 2, 80, 60));

        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 3, 135, 60) {
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);
                MythicForgeLogic.consumeIngredients(level, blockEntity.getItemHandler());
            }
        });

        addPlayerInventory(inv);
        addPlayerHotbar(inv);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(
                ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player,
                ModBlocks.MYTHIC_FORGE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack copy = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot.hasItem()) {
            ItemStack stack = slot.getItem();
            copy = stack.copy();

            if (index == 3) {
                if (!moveItemStackTo(stack, 4, 40, true))
                    return ItemStack.EMPTY;
            } else if (index < 3) {
                if (!moveItemStackTo(stack, 4, 40, true))
                    return ItemStack.EMPTY;
            } else {
                if (!moveItemStackTo(stack, 0, 3, false))
                    return ItemStack.EMPTY;
            }

            if (stack.isEmpty())
                slot.set(ItemStack.EMPTY);
            else
                slot.setChanged();
        }

        return copy;
    }

    private void addPlayerInventory(Inventory inv) {
        for (int row = 0; row < 3; ++row)
            for (int col = 0; col < 9; ++col)
                addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 100 + row * 18));
    }

    private void addPlayerHotbar(Inventory inv) {
        for (int i = 0; i < 9; ++i)
            addSlot(new Slot(inv, i, 8 + i * 18, 158));
    }
}