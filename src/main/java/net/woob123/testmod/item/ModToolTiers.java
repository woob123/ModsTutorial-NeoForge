package net.woob123.testmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.woob123.testmod.util.ModTags;

public class ModToolTiers {
    //Adding new tool tiers
    public static final Tier SAPPHIRE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SAPPHIRE_TOOL,
            2031,
            9.0F,
            4.0F,
            15,
            () -> Ingredient.of(ModItems.SAPPHIRE.get())
            );
}
