package io.github.lieonlion.mcv;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBlockEntity extends ChestBlockEntity {
    public MoreChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(blockEntityInit.MORE_CHEST, blockPos, blockState);
    }
}
