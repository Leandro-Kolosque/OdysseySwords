package com.odysseyswords.customswordmod.content.entities;

import com.odysseyswords.customswordmod.registry.ModEntities;
import com.odysseyswords.customswordmod.registry.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class ChakramEntity extends ThrowableItemProjectile {

    private ItemStack stack = ItemStack.EMPTY;
    private int life;
    private static final int MAX_LIFE = 60;

    /* =========================
       CONSTRUTORES
       ========================= */

    // OBRIGATÓRIO PELO REGISTRY
    public ChakramEntity(EntityType<? extends ChakramEntity> type, Level level) {
        super(type, level);
    }

    // USADO AO LANÇAR
    public ChakramEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntities.CHAKRAM.get(), owner, level);
        this.stack = stack.copy();
    }

    /* =========================
       BEHAVIOR
       ========================= */

    @Override
    public void tick() {
        super.tick();
        life++;

        if (life > MAX_LIFE) {
            discard();
        }
    }

    @Override
    protected void onHitEntity(net.minecraft.world.phys.EntityHitResult result) {
        super.onHitEntity(result);

        if (result.getEntity() instanceof LivingEntity target) {
            target.hurt(damageSources().thrown(this, getOwner()), 7.0F);
            discard();
        }
    }

    @Override
    protected void onHitBlock(net.minecraft.world.phys.BlockHitResult result) {
        super.onHitBlock(result);
        discard();
    }

    /* =========================
       ITEM / NETWORK
       ========================= */

    @Override
    protected Item getDefaultItem() {
        // item base usado para render fallback
        return ModItems.ROYAL_CHAKRAM.get();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
