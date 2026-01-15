package net.maksiuhrino.mcsxps1editiontitle.client.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.maksiuhrino.mcsxps1editiontitle.registry.tabs.MCSXPS1EditionTitleTabs;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MCSXPS1EditionTitleLangProvider extends FabricLanguageProvider {
    public MCSXPS1EditionTitleLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add("text.autoconfig.mcsxps1editiontitle.title", "MCSX - PS1 Edition Title");
        translationBuilder.add("text.autoconfig.mcsxps1editiontitle.option.blurBackground", "Blur Background");
        translationBuilder.add(MCSXPS1EditionTitleTabs.MAIN_GROUP, "Select block");
    }
}
