package io.github.lieonlion.mcv;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(MoreChestVariants.MODID)
public class MoreChestVariants {
    public static final String MODID = "lolmcv";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MoreChestVariants() {
        SCRegistry.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener((CreativeModeTabEvent.BuildContents e) -> {
            if (e.getTab() == CreativeModeTabs.FUNCTIONAL_BLOCKS || e.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
                SCRegistry.ITEMS.getEntries()
                        .stream()
                        .map(RegistryObject::get)
                        .forEach(e::accept);
            }
        });
    }
}