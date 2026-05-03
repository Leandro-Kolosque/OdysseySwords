package com.odysseyswords.customswordmod.content.entities.boss;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyBoss;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.List;

/**
 * Gerencia as transições de fase de um boss.
 * Deve ser instanciado dentro de cada boss concreto e
 * ter o método tick() chamado a cada tick da entidade.
 *
 * Responsabilidades:
 *   - Verificar se a fase atual deve mudar com base na vida do boss
 *   - Aplicar multiplicadores de dano e velocidade na transição
 *   - Atualizar a bossbar com a cor da nova fase
 *   - Notificar o boss via onPhaseTransition()
 *
 * Uso dentro de um boss concreto:
 *
 *   private final BossPhaseManager phaseManager = new BossPhaseManager(this, PHASES);
 *
 *   @Override
 *   public void tick() {
 *       super.tick();
 *       phaseManager.tick();
 *   }
 *
 *   @Override
 *   public boolean shouldTransitionPhase() {
 *       return phaseManager.shouldTransition();
 *   }
 */
public class BossPhaseManager {

    private final AbstractOdysseyBoss boss;
    private final List<BossPhase> phases;

    public BossPhaseManager(AbstractOdysseyBoss boss, List<BossPhase> phases) {
        this.boss = boss;
        this.phases = phases;
    }

    // -------------------------------------------------------------------------
    // Tick — chamado a cada tick do boss
    // -------------------------------------------------------------------------

    public void tick() {
        if (boss.level().isClientSide()) return;
        if (boss.isInFinalPhase()) return;

        if (shouldTransition()) {
            int previous = boss.getCurrentPhase();
            int next = previous + 1;

            if (next < phases.size()) {
                BossPhase nextPhase = phases.get(next);
                applyPhase(nextPhase);
                boss.setCurrentPhase(next);
                boss.onPhaseTransition(previous, next);
            }
        }
    }

    // -------------------------------------------------------------------------
    // Verificação de transição
    // -------------------------------------------------------------------------

    /**
     * Retorna true se o boss deve transicionar para a próxima fase.
     * Baseado no percentual de vida atual vs o threshold da próxima fase.
     */
    public boolean shouldTransition() {
        int nextPhaseIndex = boss.getCurrentPhase() + 1;
        if (nextPhaseIndex >= phases.size()) return false;

        BossPhase nextPhase = phases.get(nextPhaseIndex);
        float healthPercent = boss.getHealth() / boss.getMaxHealth();
        return nextPhase.shouldActivate(healthPercent);
    }

    // -------------------------------------------------------------------------
    // Aplicação da fase
    // -------------------------------------------------------------------------

    /**
     * Aplica os multiplicadores de atributos e atualiza a bossbar.
     */
    private void applyPhase(BossPhase phase) {
        applyDamageMultiplier(phase.getDamageMultiplier());
        applySpeedMultiplier(phase.getSpeedMultiplier());
        phase.applyToBossBar(boss.getBossBar());
    }

    private void applyDamageMultiplier(double multiplier) {
        var attribute = boss.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attribute != null) {
            double base = attribute.getBaseValue();
            attribute.setBaseValue(base * multiplier);
        }
    }

    private void applySpeedMultiplier(double multiplier) {
        var attribute = boss.getAttribute(Attributes.MOVEMENT_SPEED);
        if (attribute != null) {
            double base = attribute.getBaseValue();
            attribute.setBaseValue(base * multiplier);
        }
    }

    // -------------------------------------------------------------------------
    // Getters utilitários
    // -------------------------------------------------------------------------

    public BossPhase getCurrentPhaseData() {
        int index = boss.getCurrentPhase();
        if (index < 0 || index >= phases.size()) return phases.get(0);
        return phases.get(index);
    }

    public int getTotalPhases() {
        return phases.size();
    }
}