package com.odysseyswords.customswordmod.client.model.armor.void_spartan;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.sets.void_spartan.VoidSpartanArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class VoidSpartanArmorModel extends GeoModel<VoidSpartanArmorItem>{
    
    @Override
    public ResourceLocation getModelResource(VoidSpartanArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "geo/void_spartan_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VoidSpartanArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "textures/models/armor/void_spartan_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VoidSpartanArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "animations/empty.json");
    }
}
