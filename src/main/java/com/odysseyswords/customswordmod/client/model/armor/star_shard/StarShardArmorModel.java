package com.odysseyswords.customswordmod.client.model.armor.star_shard;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.sets.star_shard.StarShardArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class StarShardArmorModel extends GeoModel<StarShardArmorItem> {

    @Override
    public ResourceLocation getModelResource(StarShardArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "geo/star_shard_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarShardArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "textures/models/armor/star_shard_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarShardArmorItem object) {
        return new ResourceLocation(
                OdysseySwords.MODID,
                "animations/empty.json");
    }
}
