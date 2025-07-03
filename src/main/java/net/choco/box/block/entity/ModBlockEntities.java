package net.choco.box.block.entity;

import net.choco.box.Box;
import net.choco.box.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Box.MODID);

    public static final Supplier<BlockEntityType<MagicalBoxEntity>> MAGICAL_BOX_BE =
            BLOCK_ENTITIES.register("magical_box_be", ()-> BlockEntityType.Builder.of(
                    MagicalBoxEntity::new, ModBlocks.MAGICAL_BOX.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
