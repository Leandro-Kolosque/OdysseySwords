package com.odysseyswords.customswordmod.content.items.weapons.base;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public abstract class AbstractThrowableWeaponItem extends AbstractWeaponItem {

    protected AbstractThrowableWeaponItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            ThrowableItemProjectile projectile =
                    createProjectile(level, player, stack);

            projectile.setOwner(player);
            projectile.setPos(
                    player.getX(),
                    player.getEyeY() - 0.1D,
                    player.getZ()
            );

            projectile.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot(),
                    0.0F,
                    getVelocity(),
                    getInaccuracy()
            );

            level.addFreshEntity(projectile);
        }

        player.getCooldowns().addCooldown(this, getCooldownTicks());

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }

    protected abstract ThrowableItemProjectile createProjectile(
            Level level,
            LivingEntity shooter,
            ItemStack stack
    );

    protected float getVelocity() {
        return 1.5F;
    }

    protected float getInaccuracy() {
        return 0.0F;
    }

    protected int getCooldownTicks() {
        return 20;
    }
}
