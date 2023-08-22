package io.github.lieonlion.mcv.init;

import io.github.lieonlion.mcv.client.MoreChestRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

public class entityRendererInit {
    public static void register(){
        BlockEntityRendererRegistry.register(blockEntityInit.SPRUCE_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.BIRCH_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.JUNGLE_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.ACACIA_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.DARK_OAK_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.MANGROVE_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.CHERRY_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.BAMBOO_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.CRIMSON_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.WARPED_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.FIR_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.REDWOOD_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.MAHOGANY_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.JACARANDA_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.PALM_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.WILLOW_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.DEAD_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.MAGIC_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.UMBRAN_CHEST, MoreChestRenderer::new);
        BlockEntityRendererRegistry.register(blockEntityInit.HELLBARK_CHEST, MoreChestRenderer::new);
    }
}