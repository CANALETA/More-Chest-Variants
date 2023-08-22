package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.init.blockEntityInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MoreChestBlock extends ChestBlock {
    public final MoreChestEnum chestType;

    public MoreChestBlock(Settings settings, MoreChestEnum chestType) {
        super(Settings.copy(Blocks.CHEST), chestType::getBlockEntityType);
        this.chestType = chestType;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.chestType.getBlockEntity(pos, state);
    }

    public MoreChestEnum getType(){return chestType;}
}
