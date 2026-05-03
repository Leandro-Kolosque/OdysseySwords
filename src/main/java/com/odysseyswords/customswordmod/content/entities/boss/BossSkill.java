package com.odysseyswords.customswordmod.content.entities.boss;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyBoss;

/**
 * Representa uma habilidade especial de um boss.
 * Cada skill possui:
 *   - Duração em ticks
 *   - Cooldown entre usos
 *   - Fase mínima para ser usada
 *   - Callbacks de ciclo de vida: onStart, onTick, onEnd
 *
 * Uso — criando uma skill inline no boss concreto:
 *
 *   private static final BossSkill SUMMON_MINIONS = new BossSkill("summon_minions", 40, 200, 1) {
 *       @Override
 *       public void onStart(AbstractOdysseyBoss boss) {
 *           // lógica de invocação de minions
 *       }
 *
 *       @Override
 *       public void onTick(AbstractOdysseyBoss boss, int tick) {
 *           // efeito visual a cada tick
 *       }
 *
 *       @Override
 *       public void onEnd(AbstractOdysseyBoss boss) {
 *           // limpeza após a skill terminar
 *       }
 *   };
 *
 * Ou estendendo em uma classe dedicada para skills mais complexas:
 *
 *   public class SummonMinionsSkill extends BossSkill { ... }
 */
public abstract class BossSkill {

    private final String id;
    private final int duration;
    private final int cooldown;
    private final int minPhase;

    private int cooldownRemaining = 0;

    /**
     * @param id        Identificador único da skill (para debug e logs)
     * @param duration  Duração da execução em ticks
     * @param cooldown  Cooldown em ticks após o uso
     * @param minPhase  Fase mínima do boss para esta skill ser usada
     */
    public BossSkill(String id, int duration, int cooldown, int minPhase) {
        this.id = id;
        this.duration = duration;
        this.cooldown = cooldown;
        this.minPhase = minPhase;
    }

    // -------------------------------------------------------------------------
    // Ciclo de vida — implementados por cada skill concreta
    // -------------------------------------------------------------------------

    /** Chamado quando a skill começa. */
    public abstract void onStart(AbstractOdysseyBoss boss);

    /** Chamado a cada tick durante a execução da skill. */
    public abstract void onTick(AbstractOdysseyBoss boss, int tick);

    /** Chamado quando a skill termina (naturalmente ou interrompida). */
    public abstract void onEnd(AbstractOdysseyBoss boss);

    // -------------------------------------------------------------------------
    // Disponibilidade e cooldown
    // -------------------------------------------------------------------------

    /**
     * Retorna true se a skill pode ser usada na fase atual.
     * Leva em conta a fase mínima e o cooldown restante.
     */
    public boolean isAvailable(int currentPhase) {
        return currentPhase >= minPhase && cooldownRemaining <= 0;
    }

    /** Chamado pela BossSkillGoal ao fim da execução. */
    public void resetCooldown() {
        this.cooldownRemaining = cooldown;
    }

    /** Deve ser chamado a cada tick do boss para decrementar o cooldown. */
    public void tickCooldown() {
        if (cooldownRemaining > 0) cooldownRemaining--;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public String getId()       { return id; }
    public int getDuration()    { return duration; }
    public int getCooldown()    { return cooldown; }
    public int getMinPhase()    { return minPhase; }
}