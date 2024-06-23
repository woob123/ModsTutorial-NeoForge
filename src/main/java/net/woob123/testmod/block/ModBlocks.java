package net.woob123.testmod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.custom.CornCropBlock;
import net.woob123.testmod.block.custom.SoundBlock;
import net.woob123.testmod.block.custom.StrawberryCropBlock;
import net.woob123.testmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(TestMod.MOD_ID);

    //Adding a blocks
    public static final DeferredHolder<Block, Block> SAPPHIRE_BLOCK = registerBlock("sapphire_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final DeferredHolder<Block, Block> RAW_SAPPHIRE_BLOCK = registerBlock("raw_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));

    //Adding blocks that drop xp
    public static final DeferredHolder<Block, Block> SAPPHIRE_ORE = registerBlock("sapphire_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 6), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
                    .strength(0.4f).requiresCorrectToolForDrops()));

    //Adding custom blocks with custom classes
    public static final DeferredHolder<Block, SoundBlock> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.of()));

    //Adding non-block blocks lol

        //Stairs
    public static final DeferredHolder<Block, Block> SAPPHIRE_STAIRS = registerBlock("sapphire_stairs",
            () -> new StairBlock(ModBlocks.SAPPHIRE_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

        //Slabs
    public static final DeferredHolder<Block, Block> SAPPHIRE_SLAB = registerBlock("sapphire_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

        //Buttons
    public static final DeferredHolder<Block, Block> SAPPHIRE_BUTTON = registerBlock("sapphire_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

        //Pressure plates
    public static final DeferredHolder<Block, Block> SAPPHIRE_PRESSURE_PLATE = registerBlock("sapphire_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

        //Fences
    public static final DeferredHolder<Block, Block> SAPPHIRE_FENCE = registerBlock("sapphire_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

        //Fence gates
    public static final DeferredHolder<Block, Block> SAPPHIRE_FENCE_GATE = registerBlock("sapphire_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

        //Doors
    public static final DeferredHolder<Block, Block> SAPPHIRE_DOOR = registerBlock("sapphire_door",
            () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

        //Trapdoor
    public static final DeferredHolder<Block, Block> SAPPHIRE_TRAPDOOR = registerBlock("sapphire_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

    //Crops
    public static final DeferredHolder<Block, CropBlock> STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
            () -> new StrawberryCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final DeferredHolder<Block, CropBlock> CORN_CROP = BLOCKS.register("corn_crop",
            () -> new CornCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.PITCHER_CROP).noOcclusion().noCollission()));

    //Flowers
    public static final DeferredHolder<Block, FlowerBlock> CATMINT = registerBlock("catmint",
            () -> new FlowerBlock(MobEffects.DIG_SPEED, 4, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM).noCollission().noOcclusion()));
    //Potted flowers
    public static final DeferredHolder<Block, FlowerPotBlock> POTTED_CATMINT = registerBlock("potted_catmint",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.CATMINT, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion()));
    public static <T extends Block> DeferredHolder<Block, T> registerBlock(String name, Supplier<T> block){
        var toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block> DeferredHolder<Item, Item> registerBlockItem(String name, DeferredHolder<Block, T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }
}
