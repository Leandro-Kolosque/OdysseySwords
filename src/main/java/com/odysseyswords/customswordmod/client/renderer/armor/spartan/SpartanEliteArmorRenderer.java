package com.odysseyswords.customswordmod.client.renderer.armor.spartan;

import com.odysseyswords.customswordmod.client.model.armor.spartan.SpartanEliteArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.sets.spartan.SpartanEliteArmorItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpartanEliteArmorRenderer extends GeoArmorRenderer<SpartanEliteArmorItem> {
    public SpartanEliteArmorRenderer() {
        super(new SpartanEliteArmorModel());
    }
}
