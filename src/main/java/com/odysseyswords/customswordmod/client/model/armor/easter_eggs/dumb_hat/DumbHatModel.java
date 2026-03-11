package com.odysseyswords.customswordmod.client.model.armor.easter_eggs.dumb_hat;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.easter_eggs.dumb_hat.DumbHatItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DumbHatModel extends GeoModel<DumbHatItem> {

    @Override
    public ResourceLocation getModelResource(DumbHatItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "geo/dumb_hat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DumbHatItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "textures/models/armor/dumb_hat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DumbHatItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "animations/dumb_hat.animation.json");
    }
}