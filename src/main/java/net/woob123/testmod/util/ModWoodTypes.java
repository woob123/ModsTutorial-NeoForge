package net.woob123.testmod.util;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.woob123.testmod.TestMod;

//new wood types
public class ModWoodTypes {
    public static final WoodType PINE = WoodType.register(new WoodType(TestMod.MOD_ID + ":pine", BlockSetType.OAK));
}
