package net.maksiuhrino.mcsxps1editiontitle.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.MCSXPS1EditionTitleBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class MCSXPS1EditionTitleClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(
                MCSXPS1EditionTitleBlocks.GEAR,
                ChunkSectionLayer.CUTOUT
        );
    }
}
