package com.odysseyswords.customswordmod.client.renderer.armor.cyber;

import com.odysseyswords.customswordmod.client.model.armor.cyber.CyberArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.sets.cyber.CyberArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class CyberArmorRenderer extends GeoArmorRenderer<CyberArmorItem>{
    public CyberArmorRenderer() {
        super(new CyberArmorModel());
    }
}
