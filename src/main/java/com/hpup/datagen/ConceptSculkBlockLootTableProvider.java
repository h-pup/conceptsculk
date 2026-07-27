package com.hpup.datagen;

import com.hpup.block.ConceptSculkBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ConceptSculkBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ConceptSculkBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropWhenSilkTouch(ConceptSculkBlocks.SCULK_JAW);
        dropWhenSilkTouch(ConceptSculkBlocks.ANCIENT_VASE);
    }
}
