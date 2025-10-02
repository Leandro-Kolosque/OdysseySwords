package com.odysseyswords.customswordmod.screen;

import net.minecraft.world.inventory.SimpleContainerData;
import com.odysseyswords.customswordmod.block.ModBlocks;
import com.odysseyswords.customswordmod.block.entity.MythicForgeBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class MythicForgeMenu extends AbstractContainerMenu {
    public final MythicForgeBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public MythicForgeMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()),
                new SimpleContainerData(2)); // 2 para progress e maxProgress
    }

    public MythicForgeMenu(int containerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(ModMenuTypes.MYTHIC_FORGE_MENU.get(), containerId);
        checkContainerSize(inv, 3);
        this.blockEntity = (MythicForgeBlockEntity) entity;
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv); // ← ESTE MÉTODO ADICIONA O INVENTÁRIO VANILLA
        addPlayerHotbar(inv); // ← ESTE MÉTODO ADICIONA A HOTBAR VANILLA

        // SLOTS DA FORJA (acima do inventário vanilla)
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 0, 27, 47));
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 1, 76, 47));  
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 2, 134, 47));

        addDataSlots(data);
    }

    // Lógica para o Shift+Click (transferência rápida de itens)
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            if (index < 3) {
                if (!this.moveItemStackTo(stack, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.moveItemStackTo(stack, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (stack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, stack);
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.MYTHIC_FORGE.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public int getProgress() {
        return this.data.get(0);
    }

    public int getMaxProgress() {
        return this.data.get(1);
    }
}