package com.odysseyswords.customswordmod.content.entities.projectile;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public abstract class AbstractThrowableWeaponEntity extends ThrowableItemProjectile {

    protected static final EntityDataAccessor<Float> DAMAGE =
            SynchedEntityData.defineId(AbstractThrowableWeaponEntity.class, EntityDataSerializers.FLOAT);

    protected int life;
    protected int maxLife = 200; // 10 segundos por padrão

    protected AbstractThrowableWeaponEntity(
            EntityType<? extends ThrowableItemProjectile> type,
            Level level
    ) {
        super(type, level);
    }

    protected AbstractThrowableWeaponEntity(
            EntityType<? extends ThrowableItemProjectile> type,
            Level level,
            LivingEntity owner
    ) {
        super(type, owner, level);
    }

    // --------------------------------------------------
    // Synced Data
    // --------------------------------------------------

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, getBaseDamage());
    }

    // --------------------------------------------------
    // Tick
    // --------------------------------------------------

    @Override
    public void tick() {
        super.tick();

        if (!level().isClientSide) {
            life++;
            if (life >= maxLife) {
                onLifetimeExpired();
            }
        }
    }

    // --------------------------------------------------
    // Hit logic
    // --------------------------------------------------

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (level().isClientSide) return;

        Entity target = result.getEntity();
        Entity owner = getOwner();

        if (target != owner && target instanceof LivingEntity livingTarget) {
            DamageSource source = damageSources().thrown(this, owner);
            livingTarget.hurt(source, getDamage());

            afterEntityHit(livingTarget);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);

        if (!level().isClientSide) {
            afterBlockHit(result);
        }
    }

    // --------------------------------------------------
    // Damage
    // --------------------------------------------------

    public float getDamage() {
        return this.entityData.get(DAMAGE);
    }

    public void setDamage(float damage) {
        this.entityData.set(DAMAGE, damage);
    }

    protected float getBaseDamage() {
        return 4.0F;
    }

    // --------------------------------------------------
    // Hooks (override nos filhos)
    // --------------------------------------------------

    /**
     * Chamado após atingir uma entidade.
     * Chakram pode iniciar retorno aqui.
     */
    protected void afterEntityHit(LivingEntity target) {
    }

    /**
     * Chamado após atingir um bloco.
     * Chakram pode iniciar retorno aqui.
     */
    protected void afterBlockHit(BlockHitResult hitResult) {
    }

    /**
     * Chamado quando o tempo máximo de vida é atingido.
     */
    protected void onLifetimeExpired() {
        discard();
    }

    /**
     * Indica se a arma pode retornar ao jogador.
     */
    protected boolean canReturn() {
        return false;
    }
}
