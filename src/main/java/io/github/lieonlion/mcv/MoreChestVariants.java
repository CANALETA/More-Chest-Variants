package io.github.lieonlion.mcv;

import com.mojang.logging.LogUtils;
import io.github.lieonlion.mcv.init.blockEntityInit;
import io.github.lieonlion.mcv.init.blocksInit;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class MoreChestVariants implements ModInitializer {
    public static final String MODID = "lolmcv";

    @Override
    public void onInitialize() {
        blocksInit.registerBlocks();
        blockEntityInit.registerBlockEntities();
    }
}