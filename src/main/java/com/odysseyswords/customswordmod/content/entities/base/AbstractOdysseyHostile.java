package com.odysseyswords.customswordmod.content.entities.base;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

/**
 * Base para todos os mobs hostis do mod.
 * Já registra os goals mínimos de comportamento hostil.
 * Subclasses adicionam goals específicos antes ou depois via registerGoals().
 */
public abstract class AbstractOdysseyHostile extends AbstractOdysseyEntity {

    protected AbstractOdysseyHostile(EntityType<? extends AbstractOdysseyHostile> type, Level level) {
        super(type, level);
        this.xpReward = 10;
    }

    // -------------------------------------------------------------------------
    // Goals padrão — subclasses chamam super.registerGoals() e adicionam os seus
    // -------------------------------------------------------------------------

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0f));
        this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    // -------------------------------------------------------------------------
    // Atributos padrão — subclasses sobrescrevem com seus próprios valores
    // -------------------------------------------------------------------------

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.ATTACK_DAMAGE, 4.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 35.0)
                .add(Attributes.ARMOR, 0.0);
    }
}