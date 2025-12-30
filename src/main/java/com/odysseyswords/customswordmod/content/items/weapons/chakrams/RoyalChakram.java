package com.odysseyswords.customswordmod.content.items.weapons.chakrams;

import com.odysseyswords.customswordmod.content.entities.ChakramEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RoyalChakram extends Item {

    public RoyalChakram() {
        super(
            new Item.Properties()
                .stacksTo(1)
                .fireResistant()
                .rarity(net.minecraft.world.item.Rarity.RARE)
        );
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            ChakramEntity chakram = new ChakramEntity(level, player, stack);

            chakram.shootFromRotation(
                player,
                player.getXRot(),
                player.getYRot(),
                0.0F,
                1.6F,
                1.0F
            );

            level.addFreshEntity(chakram);
        }

        level.playSound(
            null,
            player.getX(),
            player.getY(),
            player.getZ(),
            SoundEvents.TRIDENT_THROW,
            SoundSource.PLAYERS,
            1.0F,
            1.0F
        );

        player.getCooldowns().addCooldown(this, 20);

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
