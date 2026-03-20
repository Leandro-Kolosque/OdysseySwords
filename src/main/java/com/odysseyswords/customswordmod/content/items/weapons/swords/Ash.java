package com.odysseyswords.customswordmod.content.items.weapons.swords;

import com.odysseyswords.customswordmod.content.items.materials.MaterialType;
import com.odysseyswords.customswordmod.content.items.weapons.base.SwordWeaponItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class Ash extends SwordWeaponItem {

    public Ash() {
        super(
                Tiers.NETHERITE,
                new Item.Properties()
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }

    @Override
    public MaterialType getMaterialType() {
        return MaterialType.TARTARUS; // obrigatório pela interface
    }

    @Override
    public boolean hasCustomTooltip() {
        return true;
    }

    @Override
    public void appendCustomTooltip(com.odysseyswords.customswordmod.util.tooltip.TooltipContext context) {
        context.add(
                Component.translatable("item.odysseyswords.ash.tooltip")
                        .withStyle(ChatFormatting.YELLOW, ChatFormatting.ITALIC)
        );
    }
}