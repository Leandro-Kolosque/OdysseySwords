package com.odysseyswords.customswordmod.content.items.armor.sets.pegasus;

import com.odysseyswords.customswordmod.OdysseySwords;
import com.odysseyswords.customswordmod.content.items.armor.base.AbstractOdysseyArmorItem;
import com.odysseyswords.customswordmod.client.model.armor.pegasus.PegasusArmorModel;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import net.minecraft.world.entity.Entity;


import java.util.function.Consumer;

public class PegasusArmorItem extends AbstractOdysseyArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PegasusArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorSetId() {
        return "pegasus";
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(
                    LivingEntity entity,
                    ItemStack stack,
                    EquipmentSlot slot,
                    HumanoidModel<?> original) {
                if (renderer == null) {
                    renderer = new GeoArmorRenderer<>(new PegasusArmorModel());
                }
                renderer.prepForRender(entity, stack, slot, original);
                return renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

//     @Override
//     public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
//         return OdysseySwords.MODID + ":textures/item/pegasus_" + slot.getName() + ".png";
// }
    @Override
    public String getArmorTexture(ItemStack stack, net.minecraft.world.entity.Entity entity, EquipmentSlot slot, String type) {
        // Retorna uma textura 2D para o inventário
        return OdysseySwords.MODID + "textures/item/pegasus_" + slot.getName() + ".png";
    }
}
