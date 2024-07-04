package net.woob123.testmod.block.custom.signs;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModStandingSignBlock extends StandingSignBlock {
    public ModStandingSignBlock(WoodType p_56991_, Properties p_56990_) {
        super(p_56991_, p_56990_);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new SignBlockEntity(pPos, pState);
    }
}
