package net.choco.box.block;

import net.choco.box.Box;
import net.choco.box.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Box.MODID);

    public static final DeferredBlock<Block> CARDBOARD_BLOCK = registerBlock("cardboard_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8F,0.4F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> CARDBOARD_TILE = registerBlock("cardboard_tile",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(-1F,3600000.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> CRAFT_LANTERN = registerBlock("craft_lantern",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .lightLevel(state-> 15)
                    .strength(0.5F,0.4F).sound(SoundType.WOOL)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
