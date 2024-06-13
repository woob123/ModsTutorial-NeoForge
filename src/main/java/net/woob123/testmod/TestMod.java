package net.woob123.testmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
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
import net.woob123.testmod.item.ModCreativeModTabs;
import net.woob123.testmod.item.ModItems;
import org.slf4j.Logger;

@Mod(TestMod.MOD_ID)
public class TestMod {
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod(IEventBus bus) {
        //Makes sure to add the items to the mod
        ModItems.register(bus);
        //Adds items to custom creative tab
        ModCreativeModTabs.register(bus);
        //Adds blocks to the mod
        ModBlocks.register(bus);

        bus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        bus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        //Adds items to normal creative tab
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.SAPPHIRE.get());
            event.accept(ModItems.RAW_SAPPHIRE.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.SAPPHIRE_BLOCK.get());
            event.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());
            event.accept(ModBlocks.SAPPHIRE_ORE.get());
        }
        else if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(ModItems.METAL_DETECTOR.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
