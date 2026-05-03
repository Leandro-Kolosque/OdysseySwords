package com.odysseyswords.customswordmod.content.entities.ai.boss;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyBoss;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

/**
 * Goal responsável por acionar a transição de fase do boss.
 * Roda com prioridade alta (recomendado: prioridade 0 ou 1)
 * para garantir que a transição interrompa outros comportamentos.
 *
 * A lógica de QUANDO transicionar fica em shouldTransitionPhase()
 * dentro de cada boss concreto — esta goal apenas observa e aciona.
 *
 * Uso:
 *   this.goalSelector.addGoal(0, new PhaseTransitionGoal(this));
 */
public class PhaseTransitionGoal extends Goal {

    private final AbstractOdysseyBoss boss;
    private boolean isTransitioning = false;
    private int transitionTimer = 0;

    /** Ticks que o boss fica "travado" durante a animação de transição. */
    private static final int TRANSITION_DURATION = 60;

    public PhaseTransitionGoal(AbstractOdysseyBoss boss) {
        this.boss = boss;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK, Flag.TARGET));
    }

    // -------------------------------------------------------------------------
    // Condições
    // -------------------------------------------------------------------------

    @Override
    public boolean canUse() {
        return !boss.level().isClientSide()
                && !boss.isInFinalPhase()
                && boss.shouldTransitionPhase()
                && !isTransitioning;
    }

    @Override
    public boolean canContinueToUse() {
        return isTransitioning && transitionTimer < TRANSITION_DURATION;
    }

    // -------------------------------------------------------------------------
    // Execução
    // -------------------------------------------------------------------------

    @Override
    public void start() {
        isTransitioning = true;
        transitionTimer = 0;

        // Para o movimento durante a transição
        boss.getNavigation().stop();
        boss.setTarget(null);
    }

    @Override
    public void tick() {
        transitionTimer++;

        // Na metade da transição, efetiva a mudança de fase
        if (transitionTimer == TRANSITION_DURATION / 2) {
            int previous = boss.getCurrentPhase();
            int next = previous + 1;
            boss.setCurrentPhase(next);
            boss.onPhaseTransition(previous, next);
        }
    }

    @Override
    public void stop() {
        isTransitioning = false;
        transitionTimer = 0;
    }
}