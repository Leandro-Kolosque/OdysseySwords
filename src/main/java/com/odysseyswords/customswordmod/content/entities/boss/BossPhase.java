package com.odysseyswords.customswordmod.content.entities.boss;

import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.world.BossEvent;

/**
 * Representa uma fase de combate de um boss.
 * Cada fase define:
 *   - Em qual porcentagem de vida ela começa
 *   - A cor da bossbar durante essa fase
 *   - O multiplicador de dano aplicado ao boss nessa fase
 *   - O multiplicador de velocidade aplicado ao boss nessa fase
 *
 * Uso — definição das fases de um boss concreto:
 *
 *   private static final List<BossPhase> PHASES = List.of(
 *       new BossPhase(0, 1.00f, BossEvent.BossBarColor.RED,   1.0, 1.0),
 *       new BossPhase(1, 0.65f, BossEvent.BossBarColor.YELLOW, 1.3, 1.1),
 *       new BossPhase(2, 0.30f, BossEvent.BossBarColor.PURPLE, 1.6, 1.2)
 *   );
 */
public class BossPhase {

    private final int phaseIndex;
    private final float healthThreshold;
    private final BossEvent.BossBarColor bossBarColor;
    private final double damageMultiplier;
    private final double speedMultiplier;

    /**
     * @param phaseIndex        Índice da fase (0 = primeira)
     * @param healthThreshold   Porcentagem de vida em que esta fase começa (0.0 a 1.0)
     * @param bossBarColor      Cor da bossbar durante esta fase
     * @param damageMultiplier  Multiplicador de dano nesta fase (1.0 = sem alteração)
     * @param speedMultiplier   Multiplicador de velocidade nesta fase (1.0 = sem alteração)
     */
    public BossPhase(int phaseIndex,
                     float healthThreshold,
                     BossEvent.BossBarColor bossBarColor,
                     double damageMultiplier,
                     double speedMultiplier) {
        this.phaseIndex = phaseIndex;
        this.healthThreshold = healthThreshold;
        this.bossBarColor = bossBarColor;
        this.damageMultiplier = damageMultiplier;
        this.speedMultiplier = speedMultiplier;
    }

    // -------------------------------------------------------------------------
    // Aplicação da fase
    // -------------------------------------------------------------------------

    /**
     * Aplica os efeitos visuais desta fase na bossbar.
     * Chamado pelo BossPhaseManager na transição.
     */
    public void applyToBossBar(ServerBossEvent bossBar) {
        bossBar.setColor(bossBarColor);
    }

    /**
     * Retorna true se o boss deve entrar nesta fase
     * dado o percentual de vida atual.
     */
    public boolean shouldActivate(float currentHealthPercent) {
        return currentHealthPercent <= healthThreshold;
    }

    // -------------------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------------------

    public int getPhaseIndex()          { return phaseIndex; }
    public float getHealthThreshold()   { return healthThreshold; }
    public double getDamageMultiplier() { return damageMultiplier; }
    public double getSpeedMultiplier()  { return speedMultiplier; }
}