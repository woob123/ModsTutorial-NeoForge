package net.woob123.testmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.woob123.testmod.util.ModTags;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    //The result of the interaction
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        //The interaction result
        if(!pContext.getLevel().isClientSide){
            BlockPos position = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i < position.getY() + 64; i++){
                BlockState state = pContext.getLevel().getBlockState(position.below(i));

                if(isOre(state)){
                    //Sending the cooordonates in chat
                    outputCoordinates(position.below(), player, state.getBlock());
                    foundBlock = true;
                    break;
                }
            }

            //If the block is not found, outputting a message
            if(!foundBlock){
                player.sendSystemMessage(Component.literal("No ores found"));
            }
            //Hurting the durabiliy of the item
            pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(), LivingEntity.getSlotForHand(pContext.getHand()));
        }
        return InteractionResult.SUCCESS;
    }

    //Translatable tooltips
    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("item.testmod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }

    private void outputCoordinates(BlockPos blockPos, Player player, Block block) {
        //Sending chat messages
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isOre(BlockState state) {
        //What block is it?
        return state.is(ModTags.Blocks.METAL_DETECTOR_VALUABLES);
    }
}
