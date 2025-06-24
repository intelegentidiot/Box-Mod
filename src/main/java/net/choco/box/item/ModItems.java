package net.choco.box.item;

import net.choco.box.Box;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Box.MODID);

    public static final Supplier<Item> CARDBOARD = ITEMS.registerItem(
            "cardboard",
            Item::new,
            new Item.Properties()
    );

    public static final Supplier<Item> GOOP = ITEMS.registerItem(
            "goop",
            Item::new,
            new Item.Properties()
    );

    public static final Supplier<Item> RAW_GOOP = ITEMS.registerItem(
            "raw_goop",
            Item::new,
            new Item.Properties()
    );

    public static final Supplier<Item> TAPE = ITEMS.registerItem(
            "tape",
            Item::new,
            new Item.Properties()
    );

    public static final Supplier<Item> CORE = ITEMS.registerItem(
            "core",
            Item::new,
            new Item.Properties()
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
