package net.woob123.testmod.item;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;

public class ModCreativeModTabs {
    //Adding creative tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);
    //Adding custom creative tabs
    public static final Holder<CreativeModeTab> TEST_TAB = CREATIVE_MOD_TABS.register("test_tab", () -> CreativeModeTab.builder()
            .title(Component.literal("Test Tab"))
            .icon(() -> ModItems.SAPPHIRE.value().getDefaultInstance())

            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModItems.SAPPHIRE.value());
                pOutput.accept(ModItems.RAW_SAPPHIRE.value());
            }).build());
    public static void register(IEventBus bus){
        CREATIVE_MOD_TABS.register(bus);
    }
}
