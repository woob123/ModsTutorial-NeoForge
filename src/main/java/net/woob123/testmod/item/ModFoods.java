package net.woob123.testmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2f)
            .fast()
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 1), 1.0F)
            .build();
}
