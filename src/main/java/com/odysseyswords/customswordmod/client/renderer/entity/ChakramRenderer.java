package com.odysseyswords.customswordmod.client.renderer.entity;

import com.odysseyswords.customswordmod.content.entities.projectile.ChakramEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ChakramRenderer extends ThrownItemRenderer<ChakramEntity> {

    public ChakramRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
}

