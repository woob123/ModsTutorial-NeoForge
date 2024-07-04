package net.woob123.testmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.custom.CornCropBlock;
import net.woob123.testmod.block.custom.ModFlammableRotatedPillarBlock;
import net.woob123.testmod.block.custom.SoundBlock;
import net.woob123.testmod.block.custom.StrawberryCropBlock;
import net.woob123.testmod.block.custom.signs.ModHangingSignBlock;
import net.woob123.testmod.block.custom.signs.ModStandingSignBlock;
import net.woob123.testmod.block.custom.signs.ModWallHangingSignBlock;
import net.woob123.testmod.block.custom.signs.ModWallSignBlock;
import net.woob123.testmod.item.ModItems;
import net.woob123.testmod.sound.ModSounds;
import net.woob123.testmod.util.ModWoodTypes;

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
            () -> new SoundBlock(BlockBehaviour.Properties.of().sound(ModSounds.SOUND_BLOCK_SOUNDS.get())));

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

    //Custom wood
    public static final DeferredHolder<Block, RotatedPillarBlock> PINE_LOG = registerBlock("pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block, RotatedPillarBlock> PINE_WOOD = registerBlock("pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).strength(3f)));
    public static final DeferredHolder<Block, RotatedPillarBlock> STRIPPED_PINE_LOG = registerBlock("stripped_pine_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).strength(3f)));
    public static final DeferredHolder<Block, RotatedPillarBlock> STRIPPED_PINE_WOOD = registerBlock("stripped_pine_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD).strength(3f)));

    //If you have many types of planks you can make a custom PlankBlock class to override these methods  -> same goes for the custom leaves
    public static final DeferredHolder<Block, Block> PINE_PLANKS = registerBlock("pine_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredHolder<Block, LeavesBlock> PINE_LEAVES = registerBlock("pine_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    //Custom signs
    public static final DeferredHolder<Block, StandingSignBlock> PINE_SIGN = BLOCKS.register("pine_sign",
            () -> new ModStandingSignBlock(ModWoodTypes.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)));

    public static final DeferredHolder<Block, WallSignBlock> PINE_WALL_SIGN = BLOCKS.register("pine_wall_sign",
            () -> new ModWallSignBlock(ModWoodTypes.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN)));

    public static final DeferredHolder<Block, CeilingHangingSignBlock> PINE_HANGING_SIGN = BLOCKS.register("pine_hanging_sign",
            () -> new ModHangingSignBlock(ModWoodTypes.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)));

    public static final DeferredHolder<Block, ModWallHangingSignBlock> PINE_WALL_HANGING_SIGN = BLOCKS.register("pine_wall_hanging_sign",
            () -> new ModWallHangingSignBlock(ModWoodTypes.PINE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN)));

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
