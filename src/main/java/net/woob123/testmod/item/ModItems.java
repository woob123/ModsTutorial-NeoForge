package net.woob123.testmod.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;

public class ModItems {
    //"Holds" the items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    //Adding items
    public static final Holder<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final Holder<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
