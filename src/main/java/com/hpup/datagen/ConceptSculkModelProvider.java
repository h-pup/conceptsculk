package com.hpup.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import com.hpup.block.ConceptSculkBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ConceptSculkModelProvider extends FabricModelProvider {
    public ConceptSculkModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ConceptSculkBlocks.SCULK_JAW);

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}