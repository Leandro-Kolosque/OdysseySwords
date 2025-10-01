package com.odysseyswords.customswordmod.recipe;

import com.odysseyswords.customswordmod.OdysseySwords;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, OdysseySwords.MODID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, OdysseySwords.MODID);

    public static final RegistryObject<RecipeSerializer<MythicForgeRecipe>> MYTHIC_FORGING_SERIALIZER =
            SERIALIZERS.register("mythic_forging", () -> MythicForgeRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeType<MythicForgeRecipe>> MYTHIC_FORGING_TYPE =
            RECIPE_TYPES.register("mythic_forging", () -> MythicForgeRecipe.Type.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
}
