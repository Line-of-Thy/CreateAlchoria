package net.klompus.alchoria.item;

import java.util.function.Supplier;

import net.klompus.alchoria.CreateAlchoria;
import net.klompus.alchoria.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateAlchoria.MOD_ID);

    public static final Supplier<CreativeModeTab> CREATE_ALCHORIA = CREATIVE_MODE_TAB.register("create_alchoria",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.IRRELIANITE.get()))
            .title(Component.translatable("creativetab.alchoria.create_alchoria"))
            .displayItems((itemDisplayParameters,output) -> {
                output.accept(ModItems.IRRELIANITE);

                output.accept(ModItems.RAW_ALCHORUM);
                output.accept(ModItems.ALCHORUM_INGOT);
                output.accept(ModItems.ALCHORUM_NUGGET);
                output.accept(ModItems.ALCHORUM_SHEET);

                output.accept(ModItems.AMBROSE_INGOT);
                output.accept(ModItems.AMBROSE_NUGGET);
                output.accept(ModItems.AMBROSE_SHEET);

                output.accept(ModItems.BLASTED_ALCHORUM);
                output.accept(ModItems.POLISHED_ALCHORUM_INGOT);
                output.accept(ModItems.POLISHED_ALCHORUM_NUGGET);
                output.accept(ModItems.POLISHED_ALCHORUM_SHEET);
            })
            .build());
    
    public static final Supplier<CreativeModeTab> CREATE_ALCHORIA_BLOCKS = CREATIVE_MODE_TAB.register("create_alchoria_blocks",
        () -> CreativeModeTab.builder()
            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CreateAlchoria.MOD_ID, "create_alchoria"))
            .icon(() -> new ItemStack(ModBlocks.CHISELED_POLISHED_ALCHORUM.get()))
            .title(Component.translatable("creativetab.alchoria.create_alchoria_blocks"))
            .displayItems((itemDisplayParameters,output) -> {
                output.accept(ModBlocks.CHISELED_POLISHED_ALCHORUM);
                output.accept(ModBlocks.POLISHED_ALCHORUM_BLOCK);
                output.accept(ModBlocks.AMBROSE_BLOCK);
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
