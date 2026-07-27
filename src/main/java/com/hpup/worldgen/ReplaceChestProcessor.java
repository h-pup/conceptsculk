package com.hpup.worldgen;

import com.hpup.block.ConceptSculkBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jspecify.annotations.Nullable;

public class ReplaceChestProcessor implements StructureProcessor {
    private static final Block[] VASES = new Block[] {
            ConceptSculkBlocks.ANCIENT_VASE,
            ConceptSculkBlocks.ANCIENT_VASE_TALL,
            ConceptSculkBlocks.ANCIENT_VASE_SPIRAL,
            ConceptSculkBlocks.ANCIENT_VASE_EARS
    };

    public static final MapCodec<ReplaceChestProcessor> MAP_CODEC = MapCodec.unit(() -> ReplaceChestProcessor.INSTANCE);
    public static final ReplaceChestProcessor INSTANCE = new ReplaceChestProcessor();

    private ReplaceChestProcessor() {
    }

    @Override
    public StructureTemplate.@Nullable StructureBlockInfo processBlock(LevelReader level, BlockPos targetPosition, BlockPos referencePos, BlockPos templateRelativePos, StructureTemplate.StructureBlockInfo processedBlockInfo, StructurePlaceSettings settings) {
        if (processedBlockInfo.state().is(Blocks.CHEST)) {
            Direction facing = processedBlockInfo.state().getValue(ChestBlock.FACING);

            RandomSource random = RandomSource.create(processedBlockInfo.pos().asLong());
            Block chosen = VASES[random.nextInt(VASES.length)];

            BlockState output = chosen
                    .defaultBlockState()
                    .setValue(HorizontalDirectionalBlock.FACING, facing);
            return new StructureTemplate.StructureBlockInfo(processedBlockInfo.pos(), output, processedBlockInfo.nbt());
        }
        return processedBlockInfo;
    }

    @Override
    public MapCodec<? extends StructureProcessor> codec() {
        return MAP_CODEC;
    }
}
