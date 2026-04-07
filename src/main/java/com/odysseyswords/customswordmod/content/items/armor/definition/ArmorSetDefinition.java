package com.odysseyswords.customswordmod.content.items.armor.definition;

import com.odysseyswords.customswordmod.content.items.armor.traits.IArmorTrait;
import net.minecraft.world.item.ArmorMaterial;
import java.util.List;

public record ArmorSetDefinition(
    String setId, 
    ArmorMaterial material, 
    List<IArmorTrait> traits
) {}