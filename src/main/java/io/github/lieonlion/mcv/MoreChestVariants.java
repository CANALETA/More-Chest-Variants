package io.github.lieonlion.mcv;

import io.github.lieonlion.mcv.init.MoreChestInit;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.CommonLifecycleEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MoreChestVariants implements ModInitializer {
    public static final TagKey<Item> CHEST_IS_FUEL = TagKey.of(RegistryKeys.ITEM, new Identifier(MoreChestVariants.MODID, "chest_is_fuel"));
    public static final String MODID = "lolmcv";

    @Override
    public void onInitialize() {
        MoreChestInit.register();

        CommonLifecycleEvents.TAGS_LOADED.register((identifier, tag) -> {
            FuelRegistry.INSTANCE.add(CHEST_IS_FUEL, 300);
        });
    }
}