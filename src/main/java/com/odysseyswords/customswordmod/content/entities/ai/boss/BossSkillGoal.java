package com.odysseyswords.customswordmod.content.entities.ai.boss;

import com.odysseyswords.customswordmod.content.entities.base.AbstractOdysseyBoss;
import com.odysseyswords.customswordmod.content.entities.boss.BossSkill;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;
import java.util.List;

/**
 * Goal que gerencia a execução das skills do boss.
 * Seleciona a skill disponível de maior prioridade e a executa.
 *
 * Cada boss concreto fornece sua lista de BossSkills via getBossSkills().
 * A goal cuida do cooldown e da seleção automaticamente.
 *
 * Uso:
 *   this.goalSelector.addGoal(1, new BossSkillGoal(this, getBossSkills()));
 */
public class BossSkillGoal extends Goal {

    private final AbstractOdysseyBoss boss;
    private final List<BossSkill> skills;

    private BossSkill activeSkill = null;
    private int executionTimer = 0;

    public BossSkillGoal(AbstractOdysseyBoss boss, List<BossSkill> skills) {
        this.boss = boss;
        this.skills = skills;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    // -------------------------------------------------------------------------
    // Condições
    // -------------------------------------------------------------------------

    @Override
    public boolean canUse() {
        LivingEntity target = boss.getTarget();
        if (target == null || !target.isAlive()) return false;

        activeSkill = selectSkill();
        return activeSkill != null;
    }

    @Override
    public boolean canContinueToUse() {
        return activeSkill != null && executionTimer < activeSkill.getDuration();
    }

    // -------------------------------------------------------------------------
    // Execução
    // -------------------------------------------------------------------------

    @Override
    public void start() {
        executionTimer = 0;
        if (activeSkill != null) {
            activeSkill.onStart(boss);
        }
    }

    @Override
    public void tick() {
        executionTimer++;
        if (activeSkill != null) {
            activeSkill.onTick(boss, executionTimer);
        }
    }

    @Override
    public void stop() {
        if (activeSkill != null) {
            activeSkill.onEnd(boss);
            activeSkill.resetCooldown();
        }
        activeSkill = null;
        executionTimer = 0;
    }

    // -------------------------------------------------------------------------
    // Seleção de skill
    // -------------------------------------------------------------------------

    /**
     * Seleciona a primeira skill disponível na fase atual do boss.
     * A ordem da lista define a prioridade implícita.
     */
    private BossSkill selectSkill() {
        int currentPhase = boss.getCurrentPhase();
        return skills.stream()
                .filter(skill -> skill.isAvailable(currentPhase))
                .findFirst()
                .orElse(null);
    }
}