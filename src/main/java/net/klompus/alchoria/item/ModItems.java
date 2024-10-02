package net.klompus.alchoria.item;

import net.klompus.alchoria.CreateAlchoria;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CreateAlchoria.MOD_ID);

    public static final DeferredItem<Item> IRRELIANITE = ITEMS.register("irrelianite",
        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_ALCHORUM = ITEMS.register("raw_alchorum",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALCHORUM_INGOT = ITEMS.register("alchorum_ingot",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALCHORUM_NUGGET = ITEMS.register("alchorum_nugget",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALCHORUM_SHEET = ITEMS.register("alchorum_sheet",
        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> AMBROSE_INGOT = ITEMS.register("ambrose_ingot",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMBROSE_NUGGET = ITEMS.register("ambrose_nugget",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> AMBROSE_SHEET = ITEMS.register("ambrose_sheet",
        () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLASTED_ALCHORUM = ITEMS.register("blasted_alchorum",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_ALCHORUM_INGOT = ITEMS.register("polished_alchorum_ingot",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_ALCHORUM_NUGGET = ITEMS.register("polished_alchorum_nugget",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> POLISHED_ALCHORUM_SHEET = ITEMS.register("polished_alchorum_sheet",
        () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
