package com.odysseyswords.customswordmod.content.entities.ai.goals;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyHostile;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

/**
 * Goal de salto com stun no alvo.
 * O mob pula em direção ao alvo e ao aterrissar aplica Slowness no alvo
 * caso esteja dentro do raio de impacto.
 *
 * Parâmetros configuráveis:
 *   - leapStrength     Força vertical do salto
 *   - cooldownTicks    Ticks entre usos
 *   - impactRadius     Raio em blocos para aplicar o stun
 *   - stunDuration     Duração do Slowness em ticks
 *
 * Uso:
 *   this.goalSelector.addGoal(1, new LeapAndStunGoal(this, 0.6f, 200, 3.0, 60));
 */
public class LeapAndStunGoal extends Goal {

    private final AbstractOdysseyHostile mob;
    private final float leapStrength;
    private final int cooldownTicks;
    private final double impactRadiusSq;
    private final int stunDuration;

    private int cooldownRemaining = 0;
    private boolean hasLanded = false;

    public LeapAndStunGoal(AbstractOdysseyHostile mob,
                            float leapStrength,
                            int cooldownTicks,
                            double impactRadius,
                            int stunDuration) {
        this.mob = mob;
        this.leapStrength = leapStrength;
        this.cooldownTicks = cooldownTicks;
        this.impactRadiusSq = impactRadius * impactRadius;
        this.stunDuration = stunDuration;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    // -------------------------------------------------------------------------
    // Condições
    // -------------------------------------------------------------------------

    @Override
    public boolean canUse() {
        if (cooldownRemaining > 0) return false;

        LivingEntity target = mob.getTarget();
        if (target == null || !target.isAlive()) return false;

        // Só salta se o alvo estiver a uma distância razoável
        double dist = mob.distanceToSqr(target);
        return dist > 4.0 && dist < 64.0 && mob.onGround();
    }

    @Override
    public boolean canContinueToUse() {
        return !mob.onGround() || !hasLanded;
    }

    // -------------------------------------------------------------------------
    // Execução
    // -------------------------------------------------------------------------

    @Override
    public void start() {
        LivingEntity target = mob.getTarget();
        if (target == null) return;

        hasLanded = false;

        Vec3 direction = new Vec3(
                target.getX() - mob.getX(),
                0,
                target.getZ() - mob.getZ()
        ).normalize();

        mob.setDeltaMovement(
                direction.x * 0.8,
                leapStrength,
                direction.z * 0.8
        );
    }

    @Override
    public void tick() {
        if (cooldownRemaining > 0) cooldownRemaining--;

        if (!hasLanded && mob.onGround()) {
            hasLanded = true;
            onImpact();
        }
    }

    @Override
    public void stop() {
        cooldownRemaining = cooldownTicks;
        hasLanded = false;
    }

    // -------------------------------------------------------------------------
    // Impacto
    // -------------------------------------------------------------------------

    /**
     * Chamado no momento em que o mob toca o chão após o salto.
     * Aplica Slowness em alvos dentro do raio de impacto.
     * Sobrescreva para customizar o efeito do impacto.
     */
    protected void onImpact() {
        mob.level().getEntitiesOfClass(LivingEntity.class, mob.getBoundingBox().inflate(Math.sqrt(impactRadiusSq)))
                .stream()
                .filter(entity -> entity != mob && entity.distanceToSqr(mob) <= impactRadiusSq)
                .forEach(entity -> entity.addEffect(
                        new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, stunDuration, 2)));
    }
}