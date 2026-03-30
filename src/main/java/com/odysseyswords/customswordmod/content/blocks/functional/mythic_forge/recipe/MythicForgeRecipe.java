package com.odysseyswords.customswordmod.content.blocks.functional.mythic_forge.recipe;

import com.google.gson.JsonObject;
import com.odysseyswords.customswordmod.OdysseySwords;

import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import org.jetbrains.annotations.Nullable;

public class MythicForgeRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final Ingredient ingotInput;
    private final Ingredient resourceInput;
    private final Ingredient additionalInput;

    public MythicForgeRecipe(ResourceLocation id, ItemStack output,
                             Ingredient ingotInput,
                             Ingredient resourceInput,
                             Ingredient additionalInput) {
        this.id = id;
        this.output = output;
        this.ingotInput = ingotInput;
        this.resourceInput = resourceInput;
        this.additionalInput = additionalInput;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (level.isClientSide()) return false;

        return ingotInput.test(container.getItem(0)) &&
               resourceInput.test(container.getItem(1)) &&
               additionalInput.test(container.getItem(2));
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    // =========================
    // TYPE
    // =========================
    public static class Type implements RecipeType<MythicForgeRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final ResourceLocation ID =
                new ResourceLocation(OdysseySwords.MODID, "mythic_forging");
    }

    // =========================
    // SERIALIZER
    // =========================
    public static class Serializer implements RecipeSerializer<MythicForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(OdysseySwords.MODID, "mythic_forging");

        @Override
        public MythicForgeRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("output"));
            Ingredient ingot = Ingredient.fromJson(json.get("ingotInput"));
            Ingredient resource = Ingredient.fromJson(json.get("resourceInput"));
            Ingredient additional = Ingredient.fromJson(json.get("additionalInput"));

            return new MythicForgeRecipe(recipeId, output, ingot, resource, additional);
        }

        @Override
        public @Nullable MythicForgeRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            Ingredient ingot = Ingredient.fromNetwork(buffer);
            Ingredient resource = Ingredient.fromNetwork(buffer);
            Ingredient additional = Ingredient.fromNetwork(buffer);
            ItemStack output = buffer.readItem();

            return new MythicForgeRecipe(recipeId, output, ingot, resource, additional);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, MythicForgeRecipe recipe) {
            recipe.ingotInput.toNetwork(buffer);
            recipe.resourceInput.toNetwork(buffer);
            recipe.additionalInput.toNetwork(buffer);
            buffer.writeItemStack(recipe.output, false);
        }
    }
}