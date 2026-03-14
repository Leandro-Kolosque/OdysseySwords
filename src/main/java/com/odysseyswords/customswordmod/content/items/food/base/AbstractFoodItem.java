package com.odysseyswords.customswordmod.content.items.food.base;

import com.odysseyswords.customswordmod.content.items.food.definition.FoodDefinition;
import net.minecraft.world.item.Item;

public class AbstractFoodItem extends Item {

    private final FoodDefinition foodDefinition;

    public AbstractFoodItem(FoodDefinition foodDefinition) {
        this(foodDefinition, new Item.Properties());
    }

    public AbstractFoodItem(FoodDefinition foodDefinition, Properties properties) {
        super(properties.food(foodDefinition.createFoodProperties()));
        this.foodDefinition = foodDefinition;
    }

    public FoodDefinition getFoodDefinition() {
        return this.foodDefinition;
    }
}