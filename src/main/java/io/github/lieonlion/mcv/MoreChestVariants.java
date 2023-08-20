package io.github.lieonlion.mcv;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class MoreChestVariants implements ModInitializer {
    public static final String MODID = "lolmcv";
    private static final Logger LOGGER = LogUtils.getLogger();

    @Override
    public void onInitialize() {
        blocksInit.registerBlocks();
        blockEntityInit.registerBlockEntity();
    }
}