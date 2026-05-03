package com.odysseyswords.customswordmod.content.entities.base;

import com.odysseyswords.customswordmod.content.entities.base.interfaces.IBoss;
import com.odysseyswords.customswordmod.content.entities.base.interfaces.IPhased;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

/**
 * Base para todos os bosses do mod.
 * Gerencia bossbar, fases e XP automaticamente.
 * Subclasses definem: getBossName(), getMaxPhases(),
 * shouldTransitionPhase() e onPhaseTransition().
 */
public abstract class AbstractOdysseyBoss extends AbstractOdysseyHostile implements IBoss, IPhased {

    protected final ServerBossEvent bossBar;
    protected int currentPhase = 0;

    protected AbstractOdysseyBoss(EntityType<? extends AbstractOdysseyBoss> type, Level level) {
        super(type, level);
        this.xpReward = 100;
        this.bossBar = new ServerBossEvent(
                Component.translatable(getBossName()),
                BossEvent.BossBarColor.RED,
                BossEvent.BossBarOverlay.PROGRESS);
    }

    // -------------------------------------------------------------------------
    // Bossbar — exibida apenas para jogadores que enxergam o boss
    // -------------------------------------------------------------------------

    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        this.bossBar.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    public void tickBossBar() {
        this.bossBar.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public ServerBossEvent getBossBar() {
        return bossBar;
    }

    // -------------------------------------------------------------------------
    // Tick — atualiza bossbar e verifica transição de fase no servidor
    // -------------------------------------------------------------------------

    @Override
    public void tick() {
        super.tick();
        tickBossBar();

        if (!this.level().isClientSide()
                && !isInFinalPhase()
                && shouldTransitionPhase()) {

            int previous = currentPhase;
            currentPhase++;
            onPhaseTransition(previous, currentPhase);
        }
    }

    // -------------------------------------------------------------------------
    // IPhased
    // -------------------------------------------------------------------------

    @Override
    public int getCurrentPhase() {
        return currentPhase;
    }

    @Override
    public void setCurrentPhase(int phase) {
        this.currentPhase = phase;
    }

    @Override
    public abstract boolean shouldTransitionPhase();

    @Override
    public abstract void onPhaseTransition(int previousPhase, int newPhase);

    @Override
    public abstract int getMaxPhases();

    // -------------------------------------------------------------------------
    // IBoss
    // -------------------------------------------------------------------------

    @Override
    public abstract String getBossName();

    // -------------------------------------------------------------------------
    // Atributos padrão de boss — subclasses sobrescrevem
    // -------------------------------------------------------------------------

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 300.0)
                .add(Attributes.ATTACK_DAMAGE, 12.0)
                .add(Attributes.MOVEMENT_SPEED, 0.28)
                .add(Attributes.FOLLOW_RANGE, 50.0)
                .add(Attributes.ARMOR, 10.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }
}