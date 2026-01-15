package net.maksiuhrino.mcsxps1editiontitle.client.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.MCSXPS1EditionTitleBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MCSXPS1EditionTitleBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public MCSXPS1EditionTitleBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(MCSXPS1EditionTitleBlocks.GEAR);
    }
}
