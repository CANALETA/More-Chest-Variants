package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.MoreChestVariants;
import io.github.lieonlion.mcv.block.MoreChestBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class blocksInit {
    public final static MoreChestBlock SPRUCE_CHEST = registerBlock("spruce_chest", new MoreChestBlock(AbstractBlock.Settings.copy(Blocks.CHEST), () -> blockEntityInit.MORE_CHEST));
    public final static BlockItem SPRUCE_CHEST_ITEM = registerItem("spruce_chest", new BlockItem(SPRUCE_CHEST, new FabricItemSettings()));

    public static <B extends Block> B registerBlock(String name, B block) {
        Identifier id = new Identifier(MoreChestVariants.MODID, name);
        return Registry.register(Registries.BLOCK, id, block);
    }
    public static <I extends BlockItem> I registerItem(String name, I bItem) {
        Identifier id = new Identifier(MoreChestVariants.MODID, name);
        return Registry.register(Registries.ITEM, id, bItem);
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
