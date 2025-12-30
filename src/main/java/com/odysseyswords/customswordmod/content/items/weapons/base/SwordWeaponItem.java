package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;

public abstract class SwordWeaponItem extends SwordItem {

    protected final WeaponTier weaponTier;

    protected SwordWeaponItem(Properties properties, WeaponTier weaponTier) {
        super(
            weaponTier.tier(),
            (int) weaponTier.damageBonus(),
            weaponTier.attackSpeed(),
            properties
        );
        this.weaponTier = weaponTier;
    }

    protected void onHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // efeito padrão de espadas (se houver)
    }
}
