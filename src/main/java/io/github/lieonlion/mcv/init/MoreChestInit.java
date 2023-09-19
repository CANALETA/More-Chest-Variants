package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.block.MoreChestBlock;
import io.github.lieonlion.mcv.block.MoreChestBlockEntity;
import io.github.lieonlion.mcv.block.MoreChestEnum;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import java.util.Arrays;

public class MoreChestInit {
    public static MoreChestBlock[] chests = new MoreChestBlock[MoreChestEnum.VALUES.length];
    public static BlockEntityType<MoreChestBlockEntity> chest_entity;

    public static void register() {
        for (MoreChestEnum type : MoreChestEnum.VALUES) {
            MoreChestBlock chest_block = Registry.register(Registries.BLOCK, type.getId(), new MoreChestBlock(type));
            chests[type.ordinal()] = chest_block;

            Item item = Registry.register(Registries.ITEM, type.getId(), new BlockItem(chest_block, (new Item.Settings())));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.add(item));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(entries -> entries.add(item));
        }

        chest_entity = Registry.register(Registries.BLOCK_ENTITY_TYPE, "chest_entity",
                FabricBlockEntityTypeBuilder.create(MoreChestBlockEntity::new, Arrays.stream(chests).toArray(Block[]::new)).build(null));
    }
}