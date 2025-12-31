package com.odysseyswords.customswordmod.content.items.weapons.chakrams;

import com.odysseyswords.customswordmod.content.entities.projectile.ChakramEntity;
import com.odysseyswords.customswordmod.content.items.weapons.base.AbstractThrowableWeaponItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.Level;

public class RoyalChakram extends AbstractThrowableWeaponItem {

    public RoyalChakram() {
        super(
            Tiers.NETHERITE,
            new Properties().stacksTo(1)
        );
    }

    @Override
    protected ChakramEntity createProjectile(Level level, LivingEntity shooter, ItemStack stack) {
        return new ChakramEntity(level, shooter, stack);
    }

    @Override
    protected int getCooldownTicks() {
        return 15;
    }

    @Override
    protected float getVelocity() {
        return 1.8F;
    }
}
