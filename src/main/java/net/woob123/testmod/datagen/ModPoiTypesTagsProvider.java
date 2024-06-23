package net.woob123.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.woob123.testmod.TestMod;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypesTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypesTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
        super(pOutput, pProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(TestMod.MOD_ID, "sound_poi"));
    }
}
