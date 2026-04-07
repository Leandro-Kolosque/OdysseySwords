package com.odysseyswords.customswordmod.registry.helpers;

import com.odysseyswords.customswordmod.content.items.armor.base.GenericGeoArmorItem;
import com.odysseyswords.customswordmod.content.items.armor.definition.ArmorSetDefinition;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class ArmorRegistryHelper {
    public static List<RegistryObject<Item>> registerArmorSet(DeferredRegister<Item> register, ArmorSetDefinition def) {
        List<RegistryObject<Item>> items = new ArrayList<>();
        
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            String registryName = def.setId() + "_" + type.getName();
            items.add(register.register(registryName, () -> new GenericGeoArmorItem(def, type, new Item.Properties())));
        }
        
        return items;
    }
}