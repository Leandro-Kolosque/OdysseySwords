package com.odysseyswords.customswordmod.client.renderer.armor.easter_eggs.dumb_hat;

import com.odysseyswords.customswordmod.client.model.armor.easter_eggs.dumb_hat.DumbHatModel;
import com.odysseyswords.customswordmod.content.items.armor.easter_eggs.dumb_hat.DumbHatItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DumbHatRenderer extends GeoArmorRenderer<DumbHatItem> {

    public DumbHatRenderer() {
        super(new DumbHatModel());
    }
}