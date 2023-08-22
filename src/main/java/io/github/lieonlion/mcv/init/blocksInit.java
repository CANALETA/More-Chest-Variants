package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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
    public final static MoreChestBlock FIR_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.FIR);
    public final static MoreChestBlock REDWOOD_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.REDWOOD);
    public final static MoreChestBlock MAHOGANY_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.MAHOGANY);
    public final static MoreChestBlock JACARANDA_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.JACARANDA);
    public final static MoreChestBlock PALM_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.PALM);
    public final static MoreChestBlock WILLOW_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.WILLOW);
    public final static MoreChestBlock DEAD_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.DEAD);
    public final static MoreChestBlock MAGIC_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.MAGIC);
    public final static MoreChestBlock UMBRAN_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.UMBRAN);
    public final static MoreChestBlock HELLBARK_CHEST = new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), MoreChestEnum.HELLBARK);

    public static void registerBlock(Identifier id, Block block){
        Registry.register(Registries.BLOCK, id, block);
        registerBlockItem(id, block);
    }

    public static void registerBlockItem(Identifier id, Block block){
        Item item = Registry.register(Registries.ITEM, id, new BlockItem(block, (id.equals(MoreChestEnum.SPRUCE.getId()) ? new Item.Settings() :new Item.Settings())));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(item));
    }

    public static void registerBlocks(){
        registerBlock(MoreChestEnum.SPRUCE.getId(), SPRUCE_CHEST);
        registerBlock(MoreChestEnum.BIRCH.getId(), BIRCH_CHEST);
        registerBlock(MoreChestEnum.JUNGLE.getId(), JUNGLE_CHEST);
        registerBlock(MoreChestEnum.ACACIA.getId(), ACACIA_CHEST);
        registerBlock(MoreChestEnum.DARK_OAK.getId(), DARK_OAK_CHEST);
        registerBlock(MoreChestEnum.MANGROVE.getId(), MANGROVE_CHEST);
        registerBlock(MoreChestEnum.CHERRY.getId(), CHERRY_CHEST);
        registerBlock(MoreChestEnum.BAMBOO.getId(), BAMBOO_CHEST);
        registerBlock(MoreChestEnum.CRIMSON.getId(), CRIMSON_CHEST);
        registerBlock(MoreChestEnum.WARPED.getId(), WARPED_CHEST);
        registerBlock(MoreChestEnum.FIR.getId(), FIR_CHEST);
        registerBlock(MoreChestEnum.REDWOOD.getId(), REDWOOD_CHEST);
        registerBlock(MoreChestEnum.MAHOGANY.getId(), MAHOGANY_CHEST);
        registerBlock(MoreChestEnum.JACARANDA.getId(), JACARANDA_CHEST);
        registerBlock(MoreChestEnum.PALM.getId(), PALM_CHEST);
        registerBlock(MoreChestEnum.WILLOW.getId(), WILLOW_CHEST);
        registerBlock(MoreChestEnum.DEAD.getId(), DEAD_CHEST);
        registerBlock(MoreChestEnum.MAGIC.getId(), MAGIC_CHEST);
        registerBlock(MoreChestEnum.UMBRAN.getId(), UMBRAN_CHEST);
        registerBlock(MoreChestEnum.HELLBARK.getId(), HELLBARK_CHEST);
    }
}
