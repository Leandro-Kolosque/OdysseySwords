package com.odysseyswords.customswordmod.content.entities.base.interfaces;

/**
 * Define o contrato de animações para todas as entidades do mod.
 * Os nomes seguem a convenção do arquivo .animation.json do GeckoLib.
 */
public interface IAnimatedEntity {

    default String getIdleAnimationName()   { return "animation.idle"; }
    default String getWalkAnimationName()   { return "animation.walk"; }
    default String getAttackAnimationName() { return "animation.attack"; }
    default String getDeathAnimationName()  { return "animation.death"; }
    default String getHurtAnimationName()   { return "animation.hurt"; }
}