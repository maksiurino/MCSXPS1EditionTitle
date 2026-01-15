package net.maksiuhrino.mcsxps1editiontitle.registry.tabs;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.maksiuhrino.mcsxps1editiontitle.MCSXPS1EditionTitle;
import net.maksiuhrino.mcsxps1editiontitle.registry.block.MCSXPS1EditionTitleBlocks;
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
                CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                        .icon(() -> new ItemStack(Items.STONE))
                        .title(Component.translatable("itemGroup.main_group"))
                        .build()
        );

        ItemGroupEvents.modifyEntriesEvent(MAIN_GROUP).register(output -> {
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
            output.accept(MCSXPS1EditionTitleBlocks.WATER_BLOCK);
            output.accept(MCSXPS1EditionTitleBlocks.LAVA_BLOCK);
            output.accept(Items.CHEST);
            output.accept(Items.CRAFTING_TABLE);
            output.accept(MCSXPS1EditionTitleBlocks.GEAR);

            // Wool

            output.accept(Items.IRON_SHOVEL);
            output.accept(Items.IRON_PICKAXE);
            output.accept(Items.IRON_AXE);
            output.accept(Items.FLINT_AND_STEEL);
            output.accept(Items.APPLE);
            output.accept(Items.ARROW);
            output.accept(Items.COAL);
            output.accept(Items.DIAMOND);
            output.accept(Items.IRON_INGOT);
            output.accept(Items.GOLD_INGOT);
            output.accept(Items.IRON_SWORD);
            output.accept(Items.WOODEN_SWORD);
            output.accept(Items.WOODEN_SHOVEL);
            output.accept(Items.WOODEN_PICKAXE);
            output.accept(Items.WOODEN_AXE);
            output.accept(Items.STONE_SWORD);
            output.accept(Items.STONE_SHOVEL);
            output.accept(Items.STONE_PICKAXE);
            output.accept(Items.STONE_AXE);
            output.accept(Items.DIAMOND_SWORD);
            output.accept(Items.DIAMOND_SHOVEL);
            output.accept(Items.DIAMOND_PICKAXE);
            output.accept(Items.DIAMOND_AXE);
            output.accept(Items.STICK);
            output.accept(Items.BOWL);
            output.accept(Items.MUSHROOM_STEW);
            output.accept(Items.GOLDEN_SWORD);
            output.accept(Items.GOLDEN_SHOVEL);
            output.accept(Items.GOLDEN_PICKAXE);
            output.accept(Items.GOLDEN_AXE);
            output.accept(Items.STRING);
            output.accept(Items.GUNPOWDER);
            output.accept(Items.LEATHER_HELMET);
            output.accept(Items.LEATHER_CHESTPLATE);
            output.accept(Items.LEATHER_LEGGINGS);
            output.accept(Items.LEATHER_BOOTS);
            output.accept(Items.CHAINMAIL_HELMET);
            output.accept(Items.CHAINMAIL_CHESTPLATE);
            output.accept(Items.CHAINMAIL_LEGGINGS);
            output.accept(Items.CHAINMAIL_BOOTS);
            output.accept(Items.IRON_HELMET);
            output.accept(Items.IRON_CHESTPLATE);
            output.accept(Items.IRON_LEGGINGS);
            output.accept(Items.IRON_BOOTS);
            output.accept(Items.PORKCHOP);
            output.accept(Items.COOKED_BEEF);
        });
    }
}
