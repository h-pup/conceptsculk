package com.hpup.block;

import com.hpup.ConceptSculk;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ConceptSculkBlocks {
    public static final Block SCULK_JAW = registerBlock("sculk_jaw",
            properties -> new SculkJawBlock(properties.strength(1.0f).sound(SoundType.SCULK)));

    public static final Block ANCIENT_VASE = registerBlock("ancient_vase",
            properties -> new AncientVaseBlock(properties.strength(2.5f).sound(SoundType.DEEPSLATE_BRICKS).noOcclusion()));

    public static final Block ANCIENT_VASE_SPIRAL = registerBlock("ancient_vase_spiral",
            properties -> new AncientVaseBlock(properties.strength(2.5f).sound(SoundType.DEEPSLATE_BRICKS).noOcclusion()));

    public static final Block ANCIENT_VASE_EARS = registerBlock("ancient_vase_ears",
            properties -> new AncientVaseBlock(properties.strength(2.5f).sound(SoundType.DEEPSLATE_BRICKS).noOcclusion()));

    public static final Block ANCIENT_VASE_TALL = registerBlock("ancient_vase_tall",
            properties -> new TallAncientVaseBlock(properties.strength(2.5f).sound(SoundType.DEEPSLATE_BRICKS).noOcclusion()));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ConceptSculk.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ConceptSculk.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ConceptSculk.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ConceptSculk.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        ConceptSculk.LOGGER.info("Registering Mod Blocks for " + ConceptSculk.MOD_ID);
    }
}
