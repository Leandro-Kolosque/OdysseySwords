package com.odysseyswords.customswordmod.content.items.weapons.base;

import java.util.UUID;

/**
 * Representa a classe da arma.
 * Centraliza damage base, attack speed e atributos extras (knockback, reach)
 * para que o GenericWeaponItem não precise duplicar essa lógica.
 */
public enum WeaponClass {

    //                       damage  speed   knockback  reach
    SWORD       (5,  -2.3f,  0.0,    0.0,
                 null,
                 null),

    RAPIER      (4,  -1.8f,  0.0,    0.0,
                 null,
                 null),

    GREATSWORD  (7,  -2.8f,  0.0,    0.0,
                 null,
                 null),

    SCYTHE      (7,  -3.0f,  0.0,    0.0,
                 null,
                 null),

    AXE         (7,  -2.9f,  0.0,    0.0,
                 null,
                 null),

    HAMMER      (9,  -3.2f,  1.5,    0.0,
                 UUID.fromString("8e88a5c3-3f6a-4d72-b5a0-9c7e6e0c0001"),
                 null),

    SPEAR       (6,  -2.6f,  0.0,    1.5,
                 null,
                 UUID.fromString("c1c7b2a3-5f41-4e61-9e89-9d3b4e2f0001")),

    WARGLAIVE   (6,  -2.5f,  0.0,    0.75,
                 null,
                 UUID.fromString("b7c3a0b2-41df-4b5c-8d44-1c2e0f910001")),

    CLAW        (4,  -1.6f,  0.0,    0.0,
                 null,
                 null);

    // -------------------------------------------------------------------------

    private final int baseDamage;
    private final float baseAttackSpeed;
    private final double knockbackBonus;
    private final double reachBonus;
    private final UUID knockbackUUID;
    private final UUID reachUUID;

    WeaponClass(int baseDamage, float baseAttackSpeed,
                double knockbackBonus, double reachBonus,
                UUID knockbackUUID, UUID reachUUID) {
        this.baseDamage      = baseDamage;
        this.baseAttackSpeed = baseAttackSpeed;
        this.knockbackBonus  = knockbackBonus;
        this.reachBonus      = reachBonus;
        this.knockbackUUID   = knockbackUUID;
        this.reachUUID       = reachUUID;
    }

    public int getBaseDamage()       { return baseDamage; }
    public float getBaseAttackSpeed(){ return baseAttackSpeed; }
    public double getKnockbackBonus(){ return knockbackBonus; }
    public double getReachBonus()    { return reachBonus; }
    public UUID getKnockbackUUID()   { return knockbackUUID; }
    public UUID getReachUUID()       { return reachUUID; }

    public boolean hasExtraAttributes() {
        return knockbackBonus > 0 || reachBonus > 0;
    }
}