package com.odysseyswords.customswordmod.gui.menus;

import com.odysseyswords.customswordmod.content.blocks.mythic_forge.MythicForgeBlockEntity;
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
    public final MythicForgeBlockEntity blockEntity;
    private final Level level;

    public MythicForgeMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()));
    }

    public MythicForgeMenu(int containerId, Inventory inv, BlockEntity entity) {
        super(ModMenuTypes.MYTHIC_FORGE_MENU.get(), containerId);
        checkContainerSize(inv, 4);
        this.blockEntity = (MythicForgeBlockEntity) entity;
        this.level = inv.player.level();

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        // SLOTS PERSONALIZADOS PARA A FORJA MÍTICA
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 0, 21, 60) {   // Input 1
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return true;
            }
        });
        
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 1, 51, 60) {   // Input 2
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return true;
            }
        });
        
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 2, 80, 60) {  // Input 3
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return true;
            }
        });
        
        // SLOT DE OUTPUT - NÃO PERMITE COLOCAR ITENS, SÓ TIRAR
        this.addSlot(new SlotItemHandler(blockEntity.getItemHandler(), 3, 135, 60) {   // Output
            @Override
            public boolean mayPlace(@NotNull ItemStack stack) {
                return false; // Não permite colocar itens no slot de output
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                // Quando o jogador pega o item do output, consome os ingredientes
                blockEntity.consumeIngredients();
                super.onTake(player, stack);
            }
        });
    }

    // Lógica para o Shift+Click
    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack stack = slot.getItem();
            itemstack = stack.copy();
            
            if (index == 3) {
                // Se for o slot de output
                if (!this.moveItemStackTo(stack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onQuickCraft(stack, itemstack);
            } else if (index < 3) {
                // Se for um slot de input, move para o inventário
                if (!this.moveItemStackTo(stack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                // Se for do inventário, tenta mover para os slots de input
                if (!this.moveItemStackTo(stack, 0, 3, false)) {
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
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 100 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 158));
        }
    }
}