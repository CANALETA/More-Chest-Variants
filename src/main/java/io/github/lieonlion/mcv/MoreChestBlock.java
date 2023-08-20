package io.github.lieonlion.mcv;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;

import java.util.function.Supplier;

public class MoreChestBlock extends ChestBlock {
    public MoreChestBlock(Settings settings, Supplier<BlockEntityType<? extends ChestBlockEntity>> supplier) {
        super(settings, supplier);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
