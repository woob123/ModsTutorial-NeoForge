package net.woob123.testmod.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.ModBlocks;
import net.woob123.testmod.item.ModItems;

public class ModCreativeModTabs {
    //A deferred register for creative tabs
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);
    //Adding custom creative tabs
    public static final Holder<CreativeModeTab> TEST_TAB = CREATIVE_MOD_TABS.register("test_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creative.test_tab"))
            .icon(() -> ModItems.SAPPHIRE.value().getDefaultInstance())

            .displayItems((pParameters, pOutput) -> {
                //Items
                pOutput.accept(ModItems.SAPPHIRE.get());
                pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                //Advanced items
                pOutput.accept(ModItems.METAL_DETECTOR.get());

                //Blocks
                pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
                pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());

                //Advanced blocks
                pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                //Foods
                pOutput.accept(ModItems.STRAWBERRY.get());

                //Fuel items
                pOutput.accept(ModItems.PINE_CONE.get());

                //Item with 3D model
                pOutput.accept(ModItems.SAPPHIRE_STAFF.get());
            }).build());


    public static final Holder<CreativeModeTab> SAPPHIRE_EVERYTHING = CREATIVE_MOD_TABS.register("sapphire_everything_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creative.sapphire_everything_tab"))
            .icon(() -> ModItems.RAW_SAPPHIRE.get().getDefaultInstance())

            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());
            })
            .build());

    public static final Holder<CreativeModeTab> SAPPHIRE_TOOLS_AND_ARMOR = CREATIVE_MOD_TABS.register("sapphire_tools_and_armor", () -> CreativeModeTab.builder()
            .title(Component.translatable("creative.sapphire_tools_and_armor"))
            .icon(() -> ModItems.SAPPHIRE_SWORD.get().getDefaultInstance())

            .displayItems(((pParameters, pOutput) -> {
                pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                pOutput.accept(ModItems.SAPPHIRE_HOE.get());
                pOutput.accept(ModItems.SAPPHIRE_CHESTPLATE.get());
                pOutput.accept(ModItems.SAPPHIRE_LEGGINGS.get());
                pOutput.accept(ModItems.SAPPHIRE_HELMET.get());
                pOutput.accept(ModItems.SAPPHIRE_BOOTS.get());
            }))
            .build());

    public static final Holder<CreativeModeTab> CROPS_AND_FLOWERS = CREATIVE_MOD_TABS.register("crops", () -> CreativeModeTab.builder()
            .title(Component.translatable("creative.crops"))
            .icon(() -> ModItems.STRAWBERRY.get().getDefaultInstance())

            .displayItems(((pParameters, pOutput) -> {
                pOutput.accept(ModItems.STRAWBERRY_SEEDS.get());
                pOutput.accept(ModItems.STRAWBERRY.get());
                pOutput.accept(ModItems.CORN_SEEDS.get());
                pOutput.accept(ModBlocks.CATMINT.get());
            }))
            .build());
    public static void register(IEventBus bus){
        CREATIVE_MOD_TABS.register(bus);
    }
}
