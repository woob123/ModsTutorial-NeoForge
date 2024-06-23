package net.woob123.testmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;
import net.woob123.testmod.TestMod;
import net.woob123.testmod.block.ModBlocks;
import net.woob123.testmod.item.ModItems;
import net.woob123.testmod.villager.ModVillagers;

import java.util.List;

@EventBusSubscriber(modid = TestMod.MOD_ID)
public class ModEvents {

    //Profession villagers
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        //Farmer trades
        if(event.getType() == VillagerProfession.FARMER){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1 trades
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 12),
                    10, 8, 0.2f)));
        }

        //Librarian trades
        if(event.getType() == VillagerProfession.LIBRARIAN){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack enchantedBook = EnchantedBookItem.createForEnchantment(new EnchantmentInstance(Enchantments.SWIFT_SNEAK, 2));
            //Level 5 trades
            trades.get(5).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    enchantedBook,
                    10, 8, 0.2f)));
        }

        //SoundMaster trades
        if(event.getType() == ModVillagers.SOUND_MASTER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            //Level 1 trades
            trades.get(1).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 16),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get()),
                    10, 8, 0.2f)));

            //Level 2 trades
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 30),
                    new ItemStack(Items.MUSIC_DISC_13),
                    5, 8, 0.2f)));
            trades.get(2).add(((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 40),
                    new ItemStack(Items.MUSIC_DISC_11),
                    5, 8, 0.2f)));
        }
    }

    //Wandering traders
    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event){
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(ModItems.PINE_CONE.get()),
                4, 8, 0.2f));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 23),
                new ItemStack(ModItems.SAPPHIRE_BOOTS.get()),
                3, 8, 0.2f));
    }

}
