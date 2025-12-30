package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractWeaponItem extends Item {

    protected final WeaponClass weaponClass;
    protected final WeaponTier weaponTier;

    protected AbstractWeaponItem(Properties properties, WeaponClass weaponClass, WeaponTier weaponTier) {
        super(properties);
        this.weaponClass = weaponClass;
        this.weaponTier = weaponTier;
    }

    public WeaponClass getWeaponClass() {
        return weaponClass;
    }

    public WeaponTier getWeaponTier() {
        return weaponTier;
    }

    protected void onHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // sobrescreva nas armas concretas
    }
}
