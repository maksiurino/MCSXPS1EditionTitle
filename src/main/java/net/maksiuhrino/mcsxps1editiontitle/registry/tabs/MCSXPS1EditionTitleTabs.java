package net.maksiuhrino.mcsxps1editiontitle.registry.tabs;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.maksiuhrino.mcsxps1editiontitle.MCSXPS1EditionTitle;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MCSXPS1EditionTitleTabs {
    public static final ResourceKey<CreativeModeTab> MAIN_GROUP = ResourceKey.create(Registries.CREATIVE_MODE_TAB, MCSXPS1EditionTitle.id("main_group"));

    public static void bootstrap() {
        Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                MAIN_GROUP,
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(Items.STONE))
                        .title(Component.translatable("itemGroup.main_group"))
                        .displayItems((params, output) -> {
                            output.accept(Items.STONE);
                            output.accept(Items.GRASS_BLOCK);
                            output.accept(Items.DIRT);
                            output.accept(Items.COBBLESTONE);
                            output.accept(Items.OAK_PLANKS);
                            output.accept(Items.OAK_SAPLING);
                            output.accept(Items.BEDROCK);
                            output.accept(Items.SAND);
                            output.accept(Items.GRAVEL);
                            output.accept(Items.GOLD_ORE);
                            output.accept(Items.IRON_ORE);
                            output.accept(Items.COAL_ORE);
                            output.accept(Items.DIAMOND_ORE);
                            output.accept(Items.OAK_LOG);
                            output.accept(Items.OAK_LEAVES);
                            output.accept(Items.SPONGE);
                            output.accept(Items.GLASS);
                            output.accept(Items.DANDELION);
                            output.accept(Items.POPPY);
                            output.accept(Items.BROWN_MUSHROOM);
                            output.accept(Items.RED_MUSHROOM);
                            output.accept(Items.GOLD_BLOCK);
                            output.accept(Items.IRON_BLOCK);
                            output.accept(Items.DIAMOND_BLOCK);
                            output.accept(Items.SMOOTH_STONE_SLAB);
                            output.accept(Items.BRICKS);
                            output.accept(Items.TNT);
                            output.accept(Items.BOOKSHELF);
                            output.accept(Items.MOSSY_COBBLESTONE);
                            output.accept(Items.OBSIDIAN);
                            output.accept(Items.TORCH);
                        })
                        .build()
        );
    }
}
