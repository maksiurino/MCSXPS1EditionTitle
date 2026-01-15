package net.maksiuhrino.mcsxps1editiontitle.registry.block;

import net.maksiuhrino.mcsxps1editiontitle.registry.block.types.GearBlock;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.types.PlaceableFluidBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class MCSXPS1EditionTitleBlocks {
    public static final Block WATER_BLOCK = register(
            ResourceLocation.withDefaultNamespace("water_block"),
            properties -> new PlaceableFluidBlock(Blocks.WATER.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.WATER),
            true
    );

    public static final Block LAVA_BLOCK = register(
            ResourceLocation.withDefaultNamespace("lava_block"),
            properties -> new PlaceableFluidBlock(Blocks.LAVA.defaultBlockState(), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA),
            true
    );

    public static final Block GEAR = register(
            ResourceLocation.withDefaultNamespace("gear"),
            GearBlock::new,
            BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion().noCollission(),
            true
    );

    public static Block register(ResourceLocation id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());

            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    public static void bootstrap() {}
}
