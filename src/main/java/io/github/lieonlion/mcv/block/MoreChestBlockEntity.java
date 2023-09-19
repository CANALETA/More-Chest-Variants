package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.init.MoreChestInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.util.math.BlockPos;

public class MoreChestBlockEntity extends ChestBlockEntity {
    private final MoreChestEnum chestType;

    public MoreChestBlockEntity(BlockPos pos, BlockState state) {
        this(MoreChestEnum.SPRUCE, pos, state);
    }

    public MoreChestBlockEntity(MoreChestEnum chestType, BlockPos blockPos, BlockState blockState) {
        super(MoreChestInit.chest_entity, blockPos, blockState);
        this.chestType = chestType;
    }

    public MoreChestEnum getChestType() {return chestType;}
}