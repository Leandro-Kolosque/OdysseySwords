package com.odysseyswords.customswordmod.client.model.armor.cyber;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.sets.cyber.CyberArmorItem;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CyberArmorModel extends GeoModel<CyberArmorItem>{

    @Override
    public ResourceLocation getModelResource(CyberArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "geo/cyber_armor.geo.json"
        );
    }

    @Override
    public ResourceLocation getTextureResource(CyberArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "textures/models/armor/cyber_armor.png"
        );
    }

    @Override
    public ResourceLocation getAnimationResource(CyberArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "animations/empty.json"
        );
    }
}
