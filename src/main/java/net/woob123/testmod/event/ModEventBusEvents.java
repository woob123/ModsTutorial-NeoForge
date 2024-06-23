package net.woob123.testmod.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.entity.ModEntities;
import net.woob123.testmod.entity.custom.RhinoEntity;

@EventBusSubscriber(modid = TestMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RHINO.get(), RhinoEntity.createAttributes().build());
    }
}
