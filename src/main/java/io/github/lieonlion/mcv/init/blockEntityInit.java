package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestBlockEntity;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class blockEntityInit {
    public static BlockEntityType<MoreChestBlockEntity> SPRUCE_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> BIRCH_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> JUNGLE_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> ACACIA_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> DARK_OAK_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> MANGROVE_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> CHERRY_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> BAMBOO_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> CRIMSON_CHEST;
    public static BlockEntityType<MoreChestBlockEntity> WARPED_CHEST;

    public static void registerBlockEntities() {
        SPRUCE_CHEST = register(MoreChestEnum.SPRUCE, blocksInit.SPRUCE_CHEST);
        BIRCH_CHEST = register(MoreChestEnum.BIRCH, blocksInit.BIRCH_CHEST);
        JUNGLE_CHEST = register(MoreChestEnum.JUNGLE, blocksInit.JUNGLE_CHEST);
        ACACIA_CHEST = register(MoreChestEnum.ACACIA, blocksInit.ACACIA_CHEST);
        DARK_OAK_CHEST = register(MoreChestEnum.DARK_OAK, blocksInit.DARK_OAK_CHEST);
        MANGROVE_CHEST = register(MoreChestEnum.MANGROVE, blocksInit.MANGROVE_CHEST);
        CHERRY_CHEST = register(MoreChestEnum.CHERRY, blocksInit.CHERRY_CHEST);
        BAMBOO_CHEST = register(MoreChestEnum.BAMBOO, blocksInit.BAMBOO_CHEST);
        CRIMSON_CHEST = register(MoreChestEnum.CRIMSON, blocksInit.CRIMSON_CHEST);
        WARPED_CHEST = register(MoreChestEnum.WARPED, blocksInit.WARPED_CHEST);
    }

    private static BlockEntityType<MoreChestBlockEntity> register(MoreChestEnum type, MoreChestBlock... block){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, type.getId(),
                FabricBlockEntityTypeBuilder.create((pos, state)-> new MoreChestBlockEntity(type, pos, state),
                        block).build(null));
    }
}