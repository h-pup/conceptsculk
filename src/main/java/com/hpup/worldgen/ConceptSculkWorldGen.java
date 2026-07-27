package com.hpup.worldgen;

import com.hpup.ConceptSculk;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ConceptSculkWorldGen {
    public static void register() {
        ConceptSculk.LOGGER.info("Running WorldGen features for " + ConceptSculk.MOD_ID);

        BiomeModifications.addFeature(
                BiomeSelectors.includeByKey(Biomes.DEEP_DARK),
                GenerationStep.Decoration.UNDERGROUND_DECORATION,
                ResourceKey.create(
                        Registries.PLACED_FEATURE,
                        Identifier.fromNamespaceAndPath("conceptsculk", "sculk_jaw")
                )
        );
    }
}
