package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.init.MoreChestInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class MoreChestVariantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(MoreChestInit.chest_entity, MoreChestRenderer::new);
    }
}