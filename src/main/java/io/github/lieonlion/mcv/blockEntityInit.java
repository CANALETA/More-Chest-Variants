package io.github.lieonlion.mcv;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class blockEntityInit {
    public static BlockEntityType<MoreChestBlockEntity> MORE_CHEST;

    public static void registerBlockEntity() {
        MORE_CHEST = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(MoreChestVariants.MODID, "more_chest"),
                FabricBlockEntityTypeBuilder.create(MoreChestBlockEntity::new,
                        blocksInit.SPRUCE_CHEST).build(null));
    }
}