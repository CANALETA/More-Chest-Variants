package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class blocksInit {
    public final static MoreChestBlock SPRUCE_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.SPRUCE);
    public final static MoreChestBlock BIRCH_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.BIRCH);
    public final static MoreChestBlock JUNGLE_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.JUNGLE);
    public final static MoreChestBlock ACACIA_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.ACACIA);
    public final static MoreChestBlock DARK_OAK_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.DARK_OAK);
    public final static MoreChestBlock MANGROVE_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.MANGROVE);
    public final static MoreChestBlock CHERRY_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.CHERRY);
    public final static MoreChestBlock BAMBOO_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.BAMBOO);
    public final static MoreChestBlock CRIMSON_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.CRIMSON);
    public final static MoreChestBlock WARPED_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.WARPED);

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