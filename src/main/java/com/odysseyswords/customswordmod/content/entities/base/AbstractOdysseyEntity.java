package com.odysseyswords.customswordmod.content.entities.base;

import com.odysseyswords.customswordmod.content.entities.base.interfaces.IAnimatedEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

/**
 * Base de todas as entidades do OdysseySwords.
 * Centraliza o setup do GeckoLib e o predicate de animação padrão.
 * Subclasses sobrescrevem registerControllers() para adicionar
 * controllers específicos (ataque, morte, etc.).
 */
public abstract class AbstractOdysseyEntity extends PathfinderMob implements GeoEntity, IAnimatedEntity {

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    protected AbstractOdysseyEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    // -------------------------------------------------------------------------
    // GeckoLib
    // -------------------------------------------------------------------------

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "movement_controller", 5, state -> {
            if (state.isMoving()) {
                state.getController().setAnimation(
                        RawAnimation.begin().thenLoop(getWalkAnimationName()));
            } else {
                state.getController().setAnimation(
                        RawAnimation.begin().thenLoop(getIdleAnimationName()));
            }
            return PlayState.CONTINUE;
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}