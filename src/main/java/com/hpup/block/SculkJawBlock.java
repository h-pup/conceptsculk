package com.hpup.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class SculkJawBlock extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public static final float DAMAGE = 5.0F; // out of 20
    public static final int COOLDOWN = 60; // 20 ticks = 1 second

    public SculkJawBlock(Properties properties) {
        super(properties);
        registerDefaultState(this.defaultBlockState().setValue(ACTIVATED, false));
    }

    @Override
    public void stepOn(final Level level, final BlockPos pos, final BlockState onState, final Entity entity) {
        if (!onState.getValue(ACTIVATED) && !entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().generic(), DAMAGE);
            level.setBlock(pos, onState.setValue(ACTIVATED, true), 3);
            level.scheduleTick(pos, this, COOLDOWN);
            level.playSound(null, pos, SoundEvents.SCULK_SENSOR_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        super.stepOn(level, pos, onState, entity);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (state.getValue(ACTIVATED)) {
            level.setBlock(pos, state.setValue(ACTIVATED, false), 3);
        }

        super.tick(state, level, pos, random);
    }
}
