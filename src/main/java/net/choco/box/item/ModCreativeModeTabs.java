package net.choco.box.item;

import net.choco.box.Box;
import net.choco.box.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Box.MODID);

    public static final Supplier<CreativeModeTab> BOX_MOD_TAB = CREATIVE_MODE_TAB.register("box_mod_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModBlocks.MAGICAL_BOX.get()))
                    .title(Component.translatable("itemgroup.box"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept((ItemLike) ModItems.CARDBOARD);
                        output.accept((ItemLike) ModItems.CORE);
                        output.accept((ItemLike) ModItems.RAW_GOOP);
                        output.accept((ItemLike) ModItems.GOOP);
                        output.accept((ItemLike) ModItems.TAPE);
                        output.accept((ItemLike) ModItems.CORE);
                        output.accept(ModBlocks.CARDBOARD_BLOCK);
                        output.accept(ModBlocks.CRAFT_LANTERN);
                        output.accept(ModBlocks.MAGICAL_BOX);
                        output.accept(ModBlocks.GOOP_ORE);
                        output.accept(ModBlocks.DEEPSLATE_GOOP_ORE);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
