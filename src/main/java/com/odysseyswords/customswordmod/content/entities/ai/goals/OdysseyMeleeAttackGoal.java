package com.odysseyswords.customswordmod.content.entities.ai.goals;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyHostile;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

/**
 * Goal de ataque corpo a corpo padrão do OdysseySwords.
 * Estende o MeleeAttackGoal vanilla adicionando:
 *   - Callback onAttackLanded() para efeitos no momento do hit
 *   - Suporte a cooldown customizado por mob
 *   - Flag para interromper o ataque ao trocar de alvo
 *
 * Uso:
 *   this.goalSelector.addGoal(2, new OdysseyMeleeAttackGoal(this, 1.0, true));
 */
public class OdysseyMeleeAttackGoal extends MeleeAttackGoal {

    private final AbstractOdysseyHostile mob;
    private int ticksSinceLastAttack = 0;
    private final int attackCooldown;

    /**
     * @param mob            A entidade dona desta goal
     * @param speedModifier  Multiplicador de velocidade durante o chase
     * @param followingTargetEvenIfNotSeen  Se persegue mesmo sem linha de visão
     */
    public OdysseyMeleeAttackGoal(AbstractOdysseyHostile mob,
                                   double speedModifier,
                                   boolean followingTargetEvenIfNotSeen) {
        this(mob, speedModifier, followingTargetEvenIfNotSeen, 20);
    }

    /**
     * @param attackCooldown Ticks entre ataques (padrão vanilla é ~20)
     */
    public OdysseyMeleeAttackGoal(AbstractOdysseyHostile mob,
                                   double speedModifier,
                                   boolean followingTargetEvenIfNotSeen,
                                   int attackCooldown) {
        super(mob, speedModifier, followingTargetEvenIfNotSeen);
        this.mob = mob;
        this.attackCooldown = attackCooldown;
    }

    // -------------------------------------------------------------------------
    // Tick
    // -------------------------------------------------------------------------

    @Override
    public void tick() {
        super.tick();
        ticksSinceLastAttack++;
    }

    @Override
    public void start() {
        super.start();
        ticksSinceLastAttack = 0;
    }

    @Override
    public void stop() {
        super.stop();
        ticksSinceLastAttack = 0;
    }

    // -------------------------------------------------------------------------
    // Ataque
    // -------------------------------------------------------------------------

    @Override
    protected void checkAndPerformAttack(LivingEntity target, double distSq) {
        if (ticksSinceLastAttack < attackCooldown) return;

        double reachSq = getAttackReachSqr(target);
        if (distSq <= reachSq && getTicksUntilNextAttack() <= 0) {
            resetAttackCooldown();
            ticksSinceLastAttack = 0;
            mob.swing(net.minecraft.world.InteractionHand.MAIN_HAND);
            mob.doHurtTarget(target);
            onAttackLanded(target);
        }
    }

    /**
     * Chamado imediatamente após o hit ser confirmado.
     * Sobrescreva em subclasses para aplicar efeitos específicos do mob
     * (ex: aplicar BleedEffect, reduzir armadura, etc.).
     */
    protected void onAttackLanded(LivingEntity target) {}
}