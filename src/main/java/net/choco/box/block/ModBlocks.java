package net.choco.box.block;

import net.choco.box.Box;
import net.choco.box.block.custom.MagicalBox;
import net.choco.box.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Box.MODID);

    public static final DeferredBlock<Block> CARDBOARD_BLOCK = registerBlock("cardboard_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(0.8F,0.4F).sound(SoundType.WOOD).ignitedByLava()){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 40;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 40;
                }
            });

    public static final DeferredBlock<Block> CARDBOARD_TILE = registerBlock("cardboard_tile",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(-1F,3600000.0F).sound(SoundType.WOOD).ignitedByLava()));

    public static final DeferredBlock<Block> CRAFT_LANTERN = registerBlock("craft_lantern",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .lightLevel(state-> 15)
                    .strength(0.5F,0.4F).sound(SoundType.WOOL)));

    public static final DeferredBlock<Block> GOOP_ORE = registerBlock("goop_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of()
                            .strength(2.8F,2F).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_GOOP_ORE = registerBlock("deepslate_goop_ore",
            ()-> new DropExperienceBlock(UniformInt.of(3, 6),
                    BlockBehaviour.Properties.of()
                            .strength(3.7F,3F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));



    public static final DeferredBlock<Block> MAGICAL_BOX = registerBlock("magical_box",
            ()-> new MagicalBox(BlockBehaviour.Properties.of().strength(0.3F,1200F).noOcclusion().forceSolidOn()));

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
