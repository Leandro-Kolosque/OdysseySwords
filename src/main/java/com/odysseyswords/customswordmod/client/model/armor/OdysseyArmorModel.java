package com.odysseyswords.customswordmod.client.model.armor;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.base.GenericGeoArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OdysseyArmorModel extends GeoModel<GenericGeoArmorItem> {
    @Override
    public ResourceLocation getModelResource(GenericGeoArmorItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "geo/" + animatable.getDefinition().setId() + "_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GenericGeoArmorItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "textures/models/armor/" + animatable.getDefinition().setId() + "_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GenericGeoArmorItem animatable) {
        return new ResourceLocation(OdysseySwords.MODID, "animations/empty.json"); // Ou padronize se tiver animações
    }
}