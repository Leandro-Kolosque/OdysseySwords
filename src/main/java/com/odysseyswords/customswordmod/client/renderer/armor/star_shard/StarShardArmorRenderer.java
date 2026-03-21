package com.odysseyswords.customswordmod.client.renderer.armor.star_shard;

import com.odysseyswords.customswordmod.client.model.armor.star_shard.StarShardArmorModel;
import com.odysseyswords.customswordmod.content.items.armor.sets.star_shard.StarShardArmorItem;

import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class StarShardArmorRenderer extends GeoArmorRenderer<StarShardArmorItem>{
    public StarShardArmorRenderer() {
        super(new StarShardArmorModel());
    }
}
