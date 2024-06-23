package net.woob123.testmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.woob123.testmod.block.ModBlocks;
import net.woob123.testmod.entity.ModEntities;
import net.woob123.testmod.entity.client.RhinoRenderer;
import net.woob123.testmod.item.ModItems;
import net.woob123.testmod.loot.ModLootModifiers;
import net.woob123.testmod.sound.ModSounds;
import net.woob123.testmod.util.ModCreativeModTabs;
import net.woob123.testmod.villager.ModVillagers;
import org.slf4j.Logger;

@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod(IEventBus bus) {
        //Makes sure to add the items to the mod
        ModItems.register(bus);
        //Adds the creative tabs
        ModCreativeModTabs.register(bus);
        //Adds blocks to the mod
        ModBlocks.register(bus);
        //Global loot modifiers
        ModLootModifiers.register(bus);
        //Custom villager professions
        ModVillagers.register(bus);
        //Custom sounds
        ModSounds.register(bus);
        //Custom entities
        ModEntities.register(bus);

        bus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //Adding pottable flowers
        event.enqueueWork(() -> ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(), ModBlocks.POTTED_CATMINT));
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //Adds items to normal creative tab
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.SAPPHIRE.get());
            event.accept(ModItems.RAW_SAPPHIRE.get());
            event.accept(ModItems.PINE_CONE.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.SAPPHIRE_BLOCK.get());
            event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
            event.accept(ModBlocks.SAPPHIRE_ORE.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.METAL_DETECTOR.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
            event.accept(ModBlocks.SOUND_BLOCK.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.STRAWBERRY.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
        }
    }
}
