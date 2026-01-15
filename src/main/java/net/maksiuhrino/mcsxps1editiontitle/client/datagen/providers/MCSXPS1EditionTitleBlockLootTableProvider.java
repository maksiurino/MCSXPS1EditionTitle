package net.maksiuhrino.mcsxps1editiontitle.client.datagen.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.MCSXPS1EditionTitleBlocks;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MCSXPS1EditionTitleBlockLootTableProvider extends FabricBlockLootTableProvider {
    public MCSXPS1EditionTitleBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(MCSXPS1EditionTitleBlocks.GEAR);
    }
}
