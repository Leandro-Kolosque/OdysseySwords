package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.item.Tier;

public record WeaponTier(
        Tier tier,
        float damageBonus,
        float attackSpeed
) {}
