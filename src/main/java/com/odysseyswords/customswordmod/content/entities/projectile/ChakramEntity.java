package com.odysseyswords.customswordmod.content.entities.projectile;

import com.odysseyswords.customswordmod.registry.ModItems;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.network.NetworkHooks;
import net.minecraft.world.entity.EntityType;
import com.odysseyswords.customswordmod.registry.ModEntities;

public class ChakramEntity extends AbstractThrowableWeaponEntity {

    private ChakramState state = ChakramState.FLYING;
    private ItemStack stack = ItemStack.EMPTY;
    private static final int MAX_LIFE = 60;

    private enum ChakramState {
        FLYING,
        RETURNING
    }

    /* =========================
       CONSTRUTORES
       ========================= */

    public ChakramEntity(EntityType<? extends ChakramEntity> type, Level level) {
        super(type, level);
    }

    public ChakramEntity(Level level, LivingEntity owner, ItemStack stack) {
        super(ModEntities.CHAKRAM.get(), level, owner);
        this.stack = stack.copy();
        this.setItem(stack.copy());
    }

    /* =========================
       TICK
       ========================= */

    @Override
    public void tick() {
        super.tick();

        // Server-side logic
        if (!level().isClientSide) {

            // Increment life
            life++;
            if (life > MAX_LIFE && state == ChakramState.FLYING) {
                state = ChakramState.RETURNING;
            }

            // Retorno ao jogador
            if (state == ChakramState.RETURNING) {
                // getOwner() retorna Entity, mas sabemos que é LivingEntity (passado no construtor)
                LivingEntity owner = getOwner() instanceof LivingEntity ? (LivingEntity) getOwner() : null;
                if (owner != null && !owner.isRemoved()) {
                    double dx = owner.getX() - getX();
                    double dy = owner.getEyeY() - getY();
                    double dz = owner.getZ() - getZ();

                    double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
                    double speed = 0.5; // Ajustável

                    setDeltaMovement(dx / distance * speed, dy / distance * speed, dz / distance * speed);

                    // Se chegou no player, devolve
                    if (distance < 1.0) {
                        if (owner instanceof Player player) {
                            player.getInventory().add(stack.copy());
                        }
                        discard();
                    }
                } else {
                    // Se owner removido, dropa no chão
                    level().addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(level(), getX(), getY(), getZ(), stack.copy()));
                    discard();
                }
            }
        }
    }

    /* =========================
       COLISÕES
       ========================= */

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (!level().isClientSide && state == ChakramState.FLYING) {
            if (result.getEntity() instanceof LivingEntity target && target != getOwner()) {
                target.hurt(damageSources().thrown(this, getOwner()), getDamage());
                state = ChakramState.RETURNING;
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (!level().isClientSide && state == ChakramState.FLYING) {
            state = ChakramState.RETURNING;
        }
    }

    /* =========================
       ITEM / NETWORK
       ========================= */

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROYAL_CHAKRAM.get();
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    /* =========================
       DAMAGE BASE
       ========================= */

    @Override
    protected float getBaseDamage() {
        return 7.0F;
    }

    @Override
    protected boolean canReturn() {
        return true;
    }
}