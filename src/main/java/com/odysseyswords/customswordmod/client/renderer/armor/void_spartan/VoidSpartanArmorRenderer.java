package com.odysseyswords.customswordmod.client.renderer.armor.void_spartan;

import com.odysseyswords.customswordmod.client.model.armor.void_spartan.VoidSpartanArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.sets.void_spartan.VoidSpartanArmorItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VoidSpartanArmorRenderer extends GeoArmorRenderer<VoidSpartanArmorItem>{
    public VoidSpartanArmorRenderer() {
        super(new VoidSpartanArmorModel());
    }
}
