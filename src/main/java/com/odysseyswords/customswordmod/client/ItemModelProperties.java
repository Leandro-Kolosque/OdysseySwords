package com.odysseyswords.customswordmod.client;

import com.odysseyswords.customswordmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import com.odysseyswords.customswordmod.OdysseySwords;

@Mod.EventBusSubscriber(modid = OdysseySwords.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ItemModelProperties {
    
    @SubscribeEvent
    public static void registerItemProperties(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // Registro do arco Orion
            ItemProperties.register(ModItems.ORION.get(), 
                new ResourceLocation("pulling"),
                (stack, world, entity, seed) -> entity != null && 
                    entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F);
            
            ItemProperties.register(ModItems.ORION.get(), 
                new ResourceLocation("pull"),
                (stack, world, entity, seed) -> {
                    if (entity == null || entity.getUseItem() != stack) {
                        return 0.0F;
                    }
                    return (entity.getTicksUsingItem() + 1) / 20.0F;
                });
        });
    }
}