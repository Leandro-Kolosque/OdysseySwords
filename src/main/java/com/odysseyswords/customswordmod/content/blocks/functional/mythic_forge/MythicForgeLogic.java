package com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge;

import com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge.recipe.MythicForgeRecipe;
import com.odysseyswords.customswordmod.content.recipes.ModRecipes;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import net.minecraftforge.items.ItemStackHandler;

import java.util.Optional;

public class MythicForgeLogic {

    public static void updateResult(Level level, ItemStackHandler itemHandler) {
        if (level == null || level.isClientSide())
            return;

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Optional<MythicForgeRecipe> match = level.getRecipeManager()
                .getRecipeFor(ModRecipes.MYTHIC_FORGING_TYPE.get(), inventory, level);

        if (match.isPresent()) {
            ItemStack result = match.get().assemble(inventory, level.registryAccess());
            itemHandler.setStackInSlot(3, result.copy());
        } else {
            itemHandler.setStackInSlot(3, ItemStack.EMPTY);
        }
    }

    public static Optional<MythicForgeRecipe> findMatchingRecipe(Level level, ItemStackHandler itemHandler) {
        if (level == null)
            return Optional.empty();

        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        return level.getRecipeManager()
                .getRecipeFor(ModRecipes.MYTHIC_FORGING_TYPE.get(), inventory, level);
    }

public static void consumeIngredients(Level level, ItemStackHandler itemHandler) {
    if (level == null || level.isClientSide()) return;

    if (findMatchingRecipe(level, itemHandler).isPresent()) {
        itemHandler.extractItem(0, 1, false);
        itemHandler.extractItem(1, 1, false);
        itemHandler.extractItem(2, 1, false);

        updateResult(level, itemHandler);
    }
}
}