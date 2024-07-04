package net.woob123.testmod.block.custom.signs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.woob123.testmod.block.entity.ModHangingSignBlockEntity;

public class ModWallHangingSignBlock extends WallHangingSignBlock {
    public ModWallHangingSignBlock(WoodType p_252140_, Properties p_251606_) {
        super(p_252140_, p_251606_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModHangingSignBlockEntity(pPos, pState);
    }
}
