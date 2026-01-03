package net.vanilama.van.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vanilama.van.Van;
import net.vanilama.van.block.custom.MagicBlock;

public class ModBlocks {
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(1.0F)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(1.0F)
                    .requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK).mapColor(MapColor.PINK)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new Block(AbstractBlock.Settings.create().strength(1.0F)
                    .requiresTool().sounds(BlockSoundGroup.STONE).mapColor(MapColor.PINK)));

    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1.0F)
                    .requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("pink_garnet_deepslate_ore",
            new Block(AbstractBlock.Settings.create().strength(1.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE).mapColor(MapColor.PINK)));

    //Blocks above here

    /*
    * Hit shift 2 times than search for blocks
    * include non project items than open blocks.java
    * list of all blocks for 1.21.1
     */

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Van.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Van.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public  static void registerBlocks() {
        Van.LOGGER.info("Registering Blocks" + Van.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_ORE);
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        });
    }
}
