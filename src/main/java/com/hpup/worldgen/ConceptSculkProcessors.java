package com.hpup.worldgen;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class ConceptSculkProcessors {
    public static final MapCodec<ReplaceChestProcessor> REPLACE_CHEST =
            Registry.register(
                    BuiltInRegistries.STRUCTURE_PROCESSOR,
                    Identifier.fromNamespaceAndPath("conceptsculk", "replace_chest"),
                    ReplaceChestProcessor.MAP_CODEC
            );

    public static void register() {}
}