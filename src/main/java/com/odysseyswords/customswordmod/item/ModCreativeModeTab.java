package com.odysseyswords.customswordmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import com.odysseyswords.customswordmod.item.ModItems;

public class ModCreativeModeTab {
    // Define the creative tab instance directly for Forge 1.19.2
    public static final CreativeModeTab ODYSSEY_TAB = new CreativeModeTab("odysseyTab") {
        @Override
        public ItemStack makeIcon() {
            // Set the icon for the tab (using steel_sword as before)
            return new ItemStack(ModItems.STEEL_SWORD.get());
        }
        // Note: In 1.19.2, items are added to the tab in their registration (.tab() method),
        // so we don't need the displayItems builder here.
    };
}

