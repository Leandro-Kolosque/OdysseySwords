package com.odysseyswords.customswordmod.client.renderer.armor;

import com.odysseyswords.customswordmod.client.model.armor.OdysseyArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.base.GenericGeoArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class OdysseyArmorRenderer extends GeoArmorRenderer<GenericGeoArmorItem> {
    public OdysseyArmorRenderer() {
        super(new OdysseyArmorModel());
    }
}