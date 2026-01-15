package net.maksiuhrino.mcsxps1editiontitle;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.MCSXPS1EditionTitleBlocks;
import net.maksiuhrino.mcsxps1editiontitle.registry.tabs.MCSXPS1EditionTitleTabs;
import net.maksiuhrino.mcsxps1editiontitle.compat.modmenu.config.MCSXPS1EditionTitleConfig;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MCSXPS1EditionTitle implements ModInitializer {
    public static final String MOD_ID = "mcsxps1editiontitle";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        AutoConfig.register(MCSXPS1EditionTitleConfig.class, JanksonConfigSerializer::new);
        MCSXPS1EditionTitleBlocks.bootstrap();
        MCSXPS1EditionTitleTabs.bootstrap();
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
