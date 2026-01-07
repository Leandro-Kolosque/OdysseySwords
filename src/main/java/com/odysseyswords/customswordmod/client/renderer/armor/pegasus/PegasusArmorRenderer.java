package com.odysseyswords.customswordmod.client.renderer.armor.pegasus;

import com.odysseyswords.customswordmod.client.model.armor.pegasus.PegasusArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.sets.pegasus.PegasusArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PegasusArmorRenderer extends GeoArmorRenderer<PegasusArmorItem> {
    public PegasusArmorRenderer() {
        super(new PegasusArmorModel());
    }
}
