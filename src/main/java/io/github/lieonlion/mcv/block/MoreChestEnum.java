package io.github.lieonlion.mcv.block;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.init.blockEntityInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
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
    WARPED,
    FIR,
    REDWOOD,
    MAHOGANY,
    JACARANDA,
    PALM,
    WILLOW,
    DEAD,
    MAGIC,
    UMBRAN,
    HELLBARK;

    public static final MoreChestEnum[] VALUES = values();

    public Identifier getId(){
        return new Identifier(MoreChestVariants.MODID, this.name().toLowerCase() + "_chest");
    }

    public BlockEntityType<? extends MoreChestBlockEntity> getBlockEntityType() {
        return switch (this) {
            case SPRUCE -> blockEntityInit.SPRUCE_CHEST;
            case BIRCH -> blockEntityInit.BIRCH_CHEST;
            case JUNGLE -> blockEntityInit.JUNGLE_CHEST;
            case ACACIA -> blockEntityInit.ACACIA_CHEST;
            case DARK_OAK -> blockEntityInit.DARK_OAK_CHEST;
            case MANGROVE -> blockEntityInit.MANGROVE_CHEST;
            case CHERRY -> blockEntityInit.CHERRY_CHEST;
            case BAMBOO -> blockEntityInit.BAMBOO_CHEST;
            case CRIMSON -> blockEntityInit.CRIMSON_CHEST;
            case WARPED -> blockEntityInit.WARPED_CHEST;
            case FIR -> blockEntityInit.FIR_CHEST;
            case REDWOOD -> blockEntityInit.REDWOOD_CHEST;
            case MAHOGANY -> blockEntityInit.MAHOGANY_CHEST;
            case JACARANDA -> blockEntityInit.JACARANDA_CHEST;
            case PALM -> blockEntityInit.PALM_CHEST;
            case WILLOW -> blockEntityInit.WILLOW_CHEST;
            case DEAD -> blockEntityInit.DEAD_CHEST;
            case MAGIC -> blockEntityInit.MAGIC_CHEST;
            case UMBRAN -> blockEntityInit.UMBRAN_CHEST;
            case HELLBARK -> blockEntityInit.HELLBARK_CHEST;
        };
    }

    public MoreChestBlockEntity getBlockEntity(BlockPos pos, BlockState state) {
        return switch (this) {
            default -> new MoreChestBlockEntity(this, pos, state);
        };
    }
}
