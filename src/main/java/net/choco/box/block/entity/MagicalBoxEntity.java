package net.choco.box.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MagicalBoxEntity extends BlockEntity {

    public MagicalBoxEntity(BlockPos pos, BlockState blockState){
        super(ModBlockEntities.MAGICAL_BOX_BE.get(), pos, blockState);
    }
}
