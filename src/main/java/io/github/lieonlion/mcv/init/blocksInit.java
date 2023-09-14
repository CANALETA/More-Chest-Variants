package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class blocksInit {
    public final static MoreChestBlock SPRUCE_CHEST = new MoreChestBlock(MoreChestEnum.SPRUCE, MapColor.SPRUCE_BROWN);
    public final static MoreChestBlock BIRCH_CHEST = new MoreChestBlock(MoreChestEnum.BIRCH, MapColor.PALE_YELLOW);
    public final static MoreChestBlock JUNGLE_CHEST = new MoreChestBlock(MoreChestEnum.JUNGLE, MapColor.DIRT_BROWN);
    public final static MoreChestBlock ACACIA_CHEST = new MoreChestBlock(MoreChestEnum.ACACIA, MapColor.ORANGE);
    public final static MoreChestBlock DARK_OAK_CHEST = new MoreChestBlock(MoreChestEnum.DARK_OAK, MapColor.BROWN);
    public final static MoreChestBlock MANGROVE_CHEST = new MoreChestBlock(MoreChestEnum.MANGROVE, MapColor.RED);
    public final static MoreChestBlock CHERRY_CHEST = new MoreChestBlock(MoreChestEnum.CHERRY, MapColor.TERRACOTTA_WHITE);
    public final static MoreChestBlock BAMBOO_CHEST = new MoreChestBlock(MoreChestEnum.BAMBOO, MapColor.YELLOW);
    public final static MoreChestBlock CRIMSON_CHEST = new MoreChestBlock(MoreChestEnum.CRIMSON, MapColor.DULL_PINK);
    public final static MoreChestBlock WARPED_CHEST = new MoreChestBlock(MoreChestEnum.WARPED, MapColor.DARK_AQUA);

    public static void registerBlock(Identifier id, Block block, boolean canBurn){
        Registry.register(Registries.BLOCK, id, block);
        Item item = Registry.register(Registries.ITEM, id, new BlockItem(block, (new Item.Settings())));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(item));

        if (canBurn)
            FuelRegistry.INSTANCE.add(block, 300);
    }

    public static void registerBlocks(){
        registerBlock(MoreChestEnum.SPRUCE.getId(), SPRUCE_CHEST, true);
        registerBlock(MoreChestEnum.BIRCH.getId(), BIRCH_CHEST, true);
        registerBlock(MoreChestEnum.JUNGLE.getId(), JUNGLE_CHEST, true);
        registerBlock(MoreChestEnum.ACACIA.getId(), ACACIA_CHEST, true);
        registerBlock(MoreChestEnum.DARK_OAK.getId(), DARK_OAK_CHEST, true);
        registerBlock(MoreChestEnum.MANGROVE.getId(), MANGROVE_CHEST, true);
        registerBlock(MoreChestEnum.CHERRY.getId(), CHERRY_CHEST, true);
        registerBlock(MoreChestEnum.BAMBOO.getId(), BAMBOO_CHEST, true);
        registerBlock(MoreChestEnum.CRIMSON.getId(), CRIMSON_CHEST, false);
        registerBlock(MoreChestEnum.WARPED.getId(), WARPED_CHEST, false);
    }
}