package net.maksiuhrino.mcsxps1editiontitle.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.maksiuhrino.mcsxps1editiontitle.client.datagen.providers.MCSXPS1EditionTitleLangProvider;

public class MCSXPS1EditionTitleDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MCSXPS1EditionTitleLangProvider::new);
    }
}
