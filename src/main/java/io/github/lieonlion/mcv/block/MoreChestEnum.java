package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.MoreChestVariants;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum MoreChestEnum {
    SPRUCE,
    BIRCH,
    JUNGLE,
    ACACIA,
    DARK_OAK,
    MANGROVE,
    CHERRY,
    BAMBOO,
    CRIMSON,
    WARPED;

    public static final MoreChestEnum[] VALUES = values();

    public Identifier getId(){
        return new Identifier(MoreChestVariants.MODID, this.name().toLowerCase() + "_chest");
    }

    public MapColor getMapColour() {
        return switch (this) {
            case SPRUCE -> MapColor.SPRUCE_BROWN;
            case BIRCH -> MapColor.PALE_YELLOW;
            case JUNGLE -> MapColor.DIRT_BROWN;
            case ACACIA -> MapColor.ORANGE;
            case DARK_OAK -> MapColor.BROWN;
            case MANGROVE -> MapColor.RED;
            case CHERRY -> MapColor.TERRACOTTA_WHITE;
            case BAMBOO -> MapColor.YELLOW;
            case CRIMSON -> MapColor.DULL_PINK;
            case WARPED -> MapColor.DARK_AQUA;
        };
    }

    public MoreChestBlockEntity getBlockEntity(BlockPos pos, BlockState state) {
        return new MoreChestBlockEntity(this, pos, state);
    }
}
