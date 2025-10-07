package com.odysseyswords.customswordmod.block.entity;

import com.odysseyswords.customswordmod.recipe.MythicForgeRecipe;
import com.odysseyswords.customswordmod.screen.MythicForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MythicForgeBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            // Atualiza o resultado quando os slots de input mudam
            if (slot < 3 && level != null && !level.isClientSide()) {
                updateResult();
            }
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0, 1, 2 -> true; // 3 slots de entrada
                case 3 -> false;      // Slot de saída (apenas leitura)
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public MythicForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MYTHIC_FORGE_BE.get(), pos, state);
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        itemHandler.deserializeNBT(tag.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    // MÉTODO PARA ATUALIZAR O RESULTADO BASEADO NOS INGREDIENTES
    private void updateResult() {
        if (level == null || level.isClientSide()) return;

        Optional<MythicForgeRecipe> match = findMatchingRecipe();
        
        if (match.isPresent()) {
            ItemStack result = match.get().getResultItem(level.registryAccess()).copy();
            itemHandler.setStackInSlot(3, result);
        } else {
            itemHandler.setStackInSlot(3, ItemStack.EMPTY);
        }
        setChanged();
    }

    // MÉTODO PARA ENCONTRAR A RECEITA CORRESPONDENTE
    private Optional<MythicForgeRecipe> findMatchingRecipe() {
        if (level == null) return Optional.empty();

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        return level.getRecipeManager()
                .getRecipeFor(MythicForgeRecipe.Type.INSTANCE, inventory, level);
    }

    // MÉTODO PARA CONSUMIR OS INGREDIENTES QUANDO O JOGADOR PEGA O RESULTADO
    public void consumeIngredients() {
        if (level == null || level.isClientSide()) return;

        // Verifica se há uma receita válida antes de consumir
        Optional<MythicForgeRecipe> match = findMatchingRecipe();
        if (match.isPresent()) {
            // Consome 1 item de cada slot de entrada
            itemHandler.extractItem(0, 1, false);
            itemHandler.extractItem(1, 1, false);
            itemHandler.extractItem(2, 1, false);
            
            // Atualiza o resultado após consumir os ingredientes
            updateResult();
            setChanged();
        }
    }

    // MÉTODO PARA VERIFICAR SE HÁ UMA RECEITA VÁLIDA
    public boolean hasValidRecipe() {
        return findMatchingRecipe().isPresent();
    }

    // MenuProvider implementation
    @Override
    public Component getDisplayName() {
        return Component.translatable("container.odysseyswords.mythic_forge");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        return new MythicForgeMenu(containerId, playerInventory, this);
    }

    // REMOVEMOS O MÉTODO tick() POIS NÃO PRECISAMOS MAIS DE CRAFTING AUTOMÁTICO
}