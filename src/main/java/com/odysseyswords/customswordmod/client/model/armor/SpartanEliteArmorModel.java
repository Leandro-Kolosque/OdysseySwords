package com.odysseyswords.customswordmod.client.model.armor;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.item.custom.SpartanEliteArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SpartanEliteArmorModel extends GeoModel<SpartanEliteArmorItem> {
    @Override
    public ResourceLocation getModelResource(SpartanEliteArmorItem object) {
        return new ResourceLocation(OdysseySwords.MODID, "geo/spartan_elite_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpartanEliteArmorItem object) {
        return new ResourceLocation(OdysseySwords.MODID, "textures/models/armor/spartan_elite_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpartanEliteArmorItem object) {
        // Se não houver animação, retorne um arquivo vazio
        return new ResourceLocation(OdysseySwords.MODID, "animations/empty.json");
    }
}
