package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.init.MoreChestInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBlock extends ChestBlock {
    public final MoreChestEnum chestType;

    public MoreChestBlock(MoreChestEnum chestType) {
        super(Settings.copy(Blocks.CHEST).mapColor(chestType.getMapColour()), () -> MoreChestInit.chest_entity);
        this.chestType = chestType;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.chestType.getBlockEntity(pos, state);
    }
}
