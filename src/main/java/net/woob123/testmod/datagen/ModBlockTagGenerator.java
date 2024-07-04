package net.woob123.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.ModBlocks;
import net.woob123.testmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                //How to add elements to custom tag
                .add(ModBlocks.SAPPHIRE_ORE.get()).addTags(Tags.Blocks.ORES);
                                                    // this adds blocks from exisiting tags to your tag

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                //How to add elements to existing tag
                .add(ModBlocks.SAPPHIRE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                //How to add elements to existing tag
                .add(ModBlocks.SAPPHIRE_ORE.get(),
                        ModBlocks.SAPPHIRE_BLOCK.get(),
                        ModBlocks.RAW_SAPPHIRE_BLOCK.get(),
                        ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SAPPHIRE_FENCE.get());

        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SAPPHIRE_FENCE_GATE.get());

        this.tag(ModTags.Blocks.INCORRECT_FOR_SAPPHIRE_TOOL);

        this.tag(ModTags.Blocks.NEEDS_SAPPHIRE_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PINE_LOG.get())
                .add(ModBlocks.STRIPPED_PINE_LOG.get())
                .add(ModBlocks.PINE_WOOD.get())
                .add(ModBlocks.STRIPPED_PINE_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.PINE_PLANKS.get());
    }
}
