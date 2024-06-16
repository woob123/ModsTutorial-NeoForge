package net.woob123.testmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.ModBlocks;
import net.woob123.testmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE.get(), ModItems.RAW_SAPPHIRE.get());
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        //Blasting recipes -> can check the RecipeProvider class for more methods for different kinds of recipes
        oreBlasting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, (ItemLike) ModItems.SAPPHIRE, 0.25f, 100, "sapphire");
        oreSmelting(pRecipeOutput, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, (ItemLike) ModItems.SAPPHIRE, 0.25f, 100, "sapphire");

        //Shaped recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.RAW_SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.RAW_SAPPHIRE.get()), has(ModItems.RAW_SAPPHIRE.get()))
                .save(pRecipeOutput);

        //Door recipes
        door(pRecipeOutput, ModBlocks.SAPPHIRE_DOOR.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Fence gate recipe
        fenceGate(pRecipeOutput, ModBlocks.SAPPHIRE_FENCE_GATE.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Pressure plate
        pressurePlate(pRecipeOutput, ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Slab
        slab(pRecipeOutput, ModBlocks.SAPPHIRE_SLAB.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Stair
        stair(pRecipeOutput, ModBlocks.SAPPHIRE_STAIRS.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Fence
        fence(pRecipeOutput, ModBlocks.SAPPHIRE_FENCE.get(), ModBlocks.SAPPHIRE_BLOCK.get());

        //Trapdoor
        trapdoor(pRecipeOutput, ModBlocks.SAPPHIRE_TRAPDOOR.get(), ModBlocks.SAPPHIRE_BLOCK.get());


        //Shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(pRecipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_SAPPHIRE.get(), 9)
                .requires(ModBlocks.RAW_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_SAPPHIRE_BLOCK.get()), has(ModBlocks.RAW_SAPPHIRE_BLOCK.get()))
                .save(pRecipeOutput);
    }

    //Furnace recipes
    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_smelting"
        );
    }

    //Blast Furnace recipes
    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(
                pRecipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                pIngredients,
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pGroup,
                "_from_blasting"
        );
    }

    //Wall
    protected static void wall(RecipeOutput pRecipeOutput, ItemLike pWall, ItemLike pMaterial) {
        wallBuilder(pWall, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }

    protected static RecipeBuilder wallBuilder(ItemLike pWall, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pWall, 6)
                .define('#', pMaterial)
                .pattern("###")
                .pattern("###");
    }

    //Door
    protected static void door(RecipeOutput pRecipeOutput, ItemLike pDoor, ItemLike pMaterial){
        doorBuilder(pDoor, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }
    protected static RecipeBuilder doorBuilder(ItemLike pDoor, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pDoor, 3)
                .define('#', pMaterial)
                .pattern("##")
                .pattern("##")
                .pattern("##");
    }

    //Regular Fence
    protected static void fence(RecipeOutput pRecipeOutput, ItemLike pFence, ItemLike pMaterial){
        fenceBuilder(pFence, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }

    protected static RecipeBuilder fenceBuilder(ItemLike pFence, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, pFence)
                .define('W', pMaterial)
                .define('#', Items.STICK)
                .pattern("W#W")
                .pattern("W#W");
    }

    //Fence Gate
    protected static void fenceGate(RecipeOutput pRecipeOutput, ItemLike pFenceGate, ItemLike pMaterial){
        fenceGateBuilder(pFenceGate, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }
    protected static RecipeBuilder fenceGateBuilder(ItemLike pFenceGate, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pFenceGate)
                .define('#', Items.STICK)
                .define('W', pMaterial)
                .pattern("#W#")
                .pattern("#W#");
    }

    //Pressure Plate
    protected static void pressurePlate(RecipeOutput pRecipeOutput, ItemLike pPressurePlate, ItemLike pMaterial) {
        pressurePlateBuilder(pPressurePlate, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }

    protected static RecipeBuilder pressurePlateBuilder(ItemLike pPressurePlate, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pPressurePlate)
                .define('#', pMaterial)
                .pattern("##");
    }

    //Slab
    protected static void slab(RecipeOutput pRecipeOutput, ItemLike pSlab, ItemLike pMaterial) {
        slabBuilder(pSlab, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }

    protected static RecipeBuilder slabBuilder(ItemLike pSlab, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pSlab, 6)
                .define('#', pMaterial)
                .pattern("###");
    }

    //Stairs
    protected static void stair(RecipeOutput pRecipeOutput, ItemLike pStair, ItemLike pMaterial){
        stairBuilder(pStair, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }
    protected static RecipeBuilder stairBuilder(ItemLike pStairs, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, pStairs, 4)
                .define('#', pMaterial)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###");
    }

    //Trapdoor
    protected static void trapdoor(RecipeOutput pRecipeOutput, ItemLike pTrapdoor, ItemLike pMaterial){
        trapdoorBuilder(pTrapdoor, Ingredient.of(pMaterial))
                .unlockedBy(getHasName(pMaterial), has(pMaterial))
                .save(pRecipeOutput);
    }

    protected static RecipeBuilder trapdoorBuilder(ItemLike pTrapdoor, Ingredient pMaterial) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, pTrapdoor, 2)
                .define('#', pMaterial)
                .pattern("###")
                .pattern("###");
    }



    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput pRecipeOutput,
            RecipeSerializer<T> pSerializer,
            AbstractCookingRecipe.Factory<T> pRecipeFactory,
            List<ItemLike> pIngredients,
            RecipeCategory pCategory,
            ItemLike pResult,
            float pExperience,
            int pCookingTime,
            String pGroup,
            String pSuffix) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, TestMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }
    }

}
