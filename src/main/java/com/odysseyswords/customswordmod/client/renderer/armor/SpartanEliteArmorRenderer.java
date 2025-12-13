package com.odysseyswords.customswordmod.client.renderer.armor;

import com.odysseyswords.customswordmod.client.model.armor.SpartanEliteArmorModel;
import com.odysseyswords.customswordmod.item.custom.SpartanEliteArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpartanEliteArmorRenderer extends GeoArmorRenderer<SpartanEliteArmorItem> {
    public SpartanEliteArmorRenderer() {
        super(new SpartanEliteArmorModel());
    }
}
