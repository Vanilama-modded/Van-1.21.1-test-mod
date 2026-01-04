package net.vanilama.van.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.vanilama.van.Van;
import net.vanilama.van.block.custom.MagicBlock;
import net.vanilama.van.block.custom.PinkGarnetLampBlock;

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


    public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
            new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                    .strength(1.0F).requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED)? 15 : 0)));



    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));



    public static final Block STAINLESS_STEEL_BLOCK = registerBlock("stainless_steel_block",
            new Block(AbstractBlock.Settings.create().strength(1.0F).requiresTool().sounds(BlockSoundGroup.METAL)));

    //Blocks above here

    /*
    * Hit shift 2 times than search for blocks
    * "include non project items" than open blocks.java
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
            fabricItemGroupEntries.add(ModBlocks.STAINLESS_STEEL_BLOCK);
        });
    }
}
