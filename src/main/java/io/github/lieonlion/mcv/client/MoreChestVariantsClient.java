package io.github.lieonlion.mcv.client;

import io.github.lieonlion.mcv.init.entityRendererInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class MoreChestVariantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        entityRendererInit.register();
    }
}
