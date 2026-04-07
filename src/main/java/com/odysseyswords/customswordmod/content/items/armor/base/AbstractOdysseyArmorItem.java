package com.odysseyswords.customswordmod.content.items.armor.base;

import com.odysseyswords.customswordmod.content.items.armor.definition.ArmorSetDefinition;
import net.minecraft.world.item.ArmorItem;

/**
 * Classe base para TODAS as armaduras do mod OdysseySwords.
 * Garante que toda peça de armadura tenha uma definição vinculada.
 */
public abstract class AbstractOdysseyArmorItem extends ArmorItem {
    protected final ArmorSetDefinition definition;

    protected AbstractOdysseyArmorItem(ArmorSetDefinition definition, Type type, Properties properties) {
        // Passamos o material contido na definição diretamente para o super do Minecraft
        super(definition.material(), type, properties);
        this.definition = definition;
    }

    public ArmorSetDefinition getDefinition() {
        return this.definition;
    }

    /**
     * Facilita o acesso ao ID do set sem precisar cavar na definição toda vez.
     */
    public String getArmorSetId() {
        return definition.setId();
    }
}