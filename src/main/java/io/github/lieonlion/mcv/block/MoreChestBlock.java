package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.init.blockEntityInit;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class MoreChestBlock extends ChestBlock {
    public final MoreChestEnum chestType;

    public MoreChestBlock(MoreChestEnum chestType, MapColor colour) {
        super(Settings.copy(Blocks.CHEST).mapColor(colour), chestType::getBlockEntityType);
        this.chestType = chestType;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.chestType.getBlockEntity(pos, state);
    }

    public MoreChestEnum getType(){return chestType;}
}
