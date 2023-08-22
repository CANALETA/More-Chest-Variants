package io.github.lieonlion.mcv.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBlockEntity extends ChestBlockEntity {
    private final MoreChestEnum chestType;

    public MoreChestBlockEntity(MoreChestEnum chestType, BlockPos blockPos, BlockState blockState) {
        super(chestType.getBlockEntityType(), blockPos, blockState);
        this.chestType = chestType;
    }

    public MoreChestEnum getChestType() {return chestType;}
}
