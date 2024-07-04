package net.woob123.testmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.woob123.testmod.TestMod;

public class ModTags {
    public static class Blocks{
        //Adding block tags
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = tag("incorrect_for_sapphire_tool");
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(TestMod.MOD_ID, name));
        }
    }
    public static class Items{
        //Adding item tags
        public static final TagKey<Item> PINE_LOGS = tag("pine_logs");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(TestMod.MOD_ID, name));
        }

    }
}
