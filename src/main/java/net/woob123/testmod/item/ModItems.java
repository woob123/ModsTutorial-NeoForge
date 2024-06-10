package net.woob123.testmod.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.woob123.testmod.TestMod;

public class ModItems {
    //"Holds" the items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.createItems(TestMod.MOD_ID);

    //Adding items
    public static final DeferredHolder<Item, Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final DeferredHolder<Item, Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
