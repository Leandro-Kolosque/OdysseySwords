package com.odysseyswords.customswordmod.content.items.armor.base;

import com.odysseyswords.customswordmod.client.renderer.armor.OdysseyArmorRenderer;
import com.odysseyswords.customswordmod.content.items.armor.definition.ArmorSetDefinition;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

/**
 * Toda armadura registrada no mod é uma instância desta classe.
 * Estende AbstractOdysseyArmorItem (e não ArmorItem diretamente) para que
 * ArmorTraitRegistry consiga reconhecer a peça via instanceof e resolver
 * seus traits ativos a partir da ArmorSetDefinition compartilhada.
 */
public class GenericGeoArmorItem extends AbstractOdysseyArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GenericGeoArmorItem(ArmorSetDefinition definition, ArmorItem.Type type, Properties properties) {
        super(definition, type, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private OdysseyArmorRenderer renderer;

            @Override
            public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entity, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new OdysseyArmorRenderer();
                }
                this.renderer.prepForRender(entity, stack, slot, original);
                return this.renderer;
            }
        });
    }

    @Override public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {}
    @Override public AnimatableInstanceCache getAnimatableInstanceCache() { return this.cache; }
}