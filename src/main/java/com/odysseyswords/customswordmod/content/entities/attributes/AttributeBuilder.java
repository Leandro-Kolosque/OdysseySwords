package com.odysseyswords.customswordmod.content.entities.attributes;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;

/**
 * Builder fluente para construção de atributos de entidades.
 * Evita repetição de código ao definir atributos em cada mob.
 *
 * Uso:
 *   AttributeBuilder.hostile()
 *       .health(80)
 *       .damage(10)
 *       .speed(0.32)
 *       .armor(4)
 *       .build();
 */
public class AttributeBuilder {

    private final AttributeSupplier.Builder builder;

    private AttributeBuilder(AttributeSupplier.Builder base) {
        this.builder = base;
    }

    // -------------------------------------------------------------------------
    // Pontos de entrada — já partem de uma base adequada para cada tipo
    // -------------------------------------------------------------------------

    /** Base para mobs hostis comuns. */
    public static AttributeBuilder hostile() {
        return new AttributeBuilder(Monster.createMonsterAttributes());
    }

    /** Base para bosses — já inclui knockback resistance padrão. */
    public static AttributeBuilder boss() {
        return new AttributeBuilder(Monster.createMonsterAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0));
    }

    // -------------------------------------------------------------------------
    // Atributos configuráveis
    // -------------------------------------------------------------------------

    public AttributeBuilder health(double value) {
        builder.add(Attributes.MAX_HEALTH, value);
        return this;
    }

    public AttributeBuilder damage(double value) {
        builder.add(Attributes.ATTACK_DAMAGE, value);
        return this;
    }

    public AttributeBuilder speed(double value) {
        builder.add(Attributes.MOVEMENT_SPEED, value);
        return this;
    }

    public AttributeBuilder followRange(double value) {
        builder.add(Attributes.FOLLOW_RANGE, value);
        return this;
    }

    public AttributeBuilder armor(double value) {
        builder.add(Attributes.ARMOR, value);
        return this;
    }

    public AttributeBuilder armorToughness(double value) {
        builder.add(Attributes.ARMOR_TOUGHNESS, value);
        return this;
    }

    public AttributeBuilder knockbackResistance(double value) {
        builder.add(Attributes.KNOCKBACK_RESISTANCE, value);
        return this;
    }

    public AttributeBuilder attackKnockback(double value) {
        builder.add(Attributes.ATTACK_KNOCKBACK, value);
        return this;
    }

    public AttributeBuilder attackSpeed(double value) {
        builder.add(Attributes.ATTACK_SPEED, value);
        return this;
    }

    // -------------------------------------------------------------------------
    // Termina a construção
    // -------------------------------------------------------------------------

    public AttributeSupplier.Builder build() {
        return builder;
    }
}
