package com.odysseyswords.customswordmod.content.entities.base.interfaces;

/**
 * Contrato para entidades com múltiplas fases de combate.
 * Implementado exclusivamente por AbstractOdysseyBoss.
 */
public interface IPhased {

    int getCurrentPhase();

    void setCurrentPhase(int phase);

    /** Retorna true quando a condição de transição de fase for atendida. */
    boolean shouldTransitionPhase();

    /** Chamado no servidor quando a fase muda. */
    void onPhaseTransition(int previousPhase, int newPhase);

    int getMaxPhases();

    default boolean isInFinalPhase() {
        return getCurrentPhase() >= getMaxPhases() - 1;
    }
}