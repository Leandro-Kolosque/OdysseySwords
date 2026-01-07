package com.odysseyswords.customswordmod.client.model.armor.pegasus;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.sets.pegasus.PegasusArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PegasusArmorModel extends GeoModel<PegasusArmorItem> {

    @Override
    public ResourceLocation getModelResource(PegasusArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "geo/pegasus_armor.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(PegasusArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "textures/models/armor/pegasus_armor.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(PegasusArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "animations/empty.json"
        );
    }
}
