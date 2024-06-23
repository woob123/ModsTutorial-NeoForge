package net.woob123.testmod.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TestMod.MOD_ID);

    public static final DeferredHolder<SoundEvent, SoundEvent> METAL_DETECTOR_FOUND_ORE = registerSoundEvents("metal_detector_found_ore");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BLOCK_BREAK = registerSoundEvents("sound_block_break");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BLOCK_FALL = registerSoundEvents("sound_block_fall");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BLOCK_STEP = registerSoundEvents("sound_block_step");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BLOCK_PLACE = registerSoundEvents("sound_block_place");
    public static final DeferredHolder<SoundEvent, SoundEvent> SOUND_BLOCK_HIT = registerSoundEvents("sound_block_hit");

    public static final Supplier<SoundType> SOUND_BLOCK_SOUNDS = () -> new SoundType(
            1f, 1f,
            ModSounds.SOUND_BLOCK_BREAK.get(),
            ModSounds.SOUND_BLOCK_STEP.get(),
            ModSounds.SOUND_BLOCK_PLACE.get(),
            ModSounds.SOUND_BLOCK_HIT.get(),
            ModSounds.SOUND_BLOCK_FALL.get());

//uite, asteapta oleac, vezi erorile?
    //nu, daca dai tu run?
    // merge?.. stai there
    // gata mrg mai e si aia cu global loot modifers
    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TestMod.MOD_ID, name)));
    }

    public static void register(IEventBus bus){
        SOUND_EVENTS.register(bus);
    }
}
