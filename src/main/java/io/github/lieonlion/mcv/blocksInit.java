package io.github.lieonlion.mcv;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class blocksInit {

    public static final ChestBlock SPRUCE_CHEST = (ChestBlock) registerBlock("spruce_chest", new ChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), () -> BlockEntityType.CHEST));
    public static final BlockItem SPRUCE_CHEST_ITEM = (BlockItem) registerItem("spruce_chest", new BlockItem(SPRUCE_CHEST, new FabricItemSettings()));

    public static Block registerBlock(String name, Block block) {
        Identifier id = new Identifier(MoreChestVariants.MODID, name);
        return Registry.register(Registries.BLOCK, id, block);
    }
    private static Item registerItem(String name, BlockItem block) {
        Identifier id = new Identifier(MoreChestVariants.MODID, name);
        return Registry.register(Registries.ITEM, id, block);
    }

    public static void registerBlocks() {
        addItemsToItemGroup();
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.FUNCTIONAL, SPRUCE_CHEST_ITEM);
        addToItemGroup(ItemGroups.REDSTONE, SPRUCE_CHEST_ITEM);
    } private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
