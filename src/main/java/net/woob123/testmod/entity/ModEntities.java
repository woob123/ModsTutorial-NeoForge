package net.woob123.testmod.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.entity.custom.RhinoEntity;

public class ModEntities{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TestMod.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<RhinoEntity>> RHINO = ENTITY_TYPES.register("rhino",
            () -> EntityType.Builder.of(RhinoEntity::new, MobCategory.CREATURE)
                    .sized(2.5f, 2.5f)
                    .build("rhino"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
