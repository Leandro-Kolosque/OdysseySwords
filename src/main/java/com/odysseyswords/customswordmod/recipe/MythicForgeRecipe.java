package com.odysseyswords.customswordmod.recipe;

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

    public MythicForgeRecipe(ResourceLocation id, ItemStack output, Ingredient ingotInput, Ingredient resourceInput) {
        this.id = id;
        this.output = output;
        this.ingotInput = ingotInput;
        this.resourceInput = resourceInput;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        return ingotInput.test(pContainer.getItem(0)) && resourceInput.test(pContainer.getItem(1));
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
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

    public static class Type implements RecipeType<MythicForgeRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "mythic_forging";
    }

    public static class Serializer implements RecipeSerializer<MythicForgeRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(OdysseySwords.MODID, "mythic_forging");

        @Override
        public MythicForgeRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
            Ingredient ingotInput = Ingredient.fromJson(pSerializedRecipe.get("ingotInput"));
            Ingredient resourceInput = Ingredient.fromJson(pSerializedRecipe.get("resourceInput"));
            ItemStack output = ShapedRecipe.itemStackFromJson(pSerializedRecipe.getAsJsonObject("output"));

            return new MythicForgeRecipe(pRecipeId, output, ingotInput, resourceInput);
        }

        @Override
        public @Nullable MythicForgeRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            Ingredient ingotInput = Ingredient.fromNetwork(pBuffer);
            Ingredient resourceInput = Ingredient.fromNetwork(pBuffer);
            ItemStack output = pBuffer.readItem();

            return new MythicForgeRecipe(pRecipeId, output, ingotInput, resourceInput);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, MythicForgeRecipe pRecipe) {
            pRecipe.ingotInput.toNetwork(pBuffer);
            pRecipe.resourceInput.toNetwork(pBuffer);
            pBuffer.writeItemStack(pRecipe.output, false);
        }
    }
}
