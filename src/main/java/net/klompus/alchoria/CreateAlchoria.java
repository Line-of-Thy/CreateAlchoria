package net.klompus.alchoria;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.klompus.alchoria.block.ModBlocks;
import net.klompus.alchoria.item.ModCreativeModeTabs;
import net.klompus.alchoria.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CreateAlchoria.MOD_ID)
public class CreateAlchoria
{
    public static final String MOD_ID = "alchoria";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CreateAlchoria(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        
        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.IRRELIANITE);

            event.accept(ModItems.RAW_ALCHORUM);
            event.accept(ModItems.ALCHORUM_INGOT);
            event.accept(ModItems.ALCHORUM_NUGGET);
            event.accept(ModItems.ALCHORUM_SHEET);

            event.accept(ModItems.BLASTED_ALCHORUM);
            event.accept(ModItems.POLISHED_ALCHORUM_INGOT);
            event.accept(ModItems.POLISHED_ALCHORUM_NUGGET);
            event.accept(ModItems.POLISHED_ALCHORUM_SHEET);

            event.accept(ModItems.AMBROSE_INGOT);
            event.accept(ModItems.AMBROSE_NUGGET);
            event.accept(ModItems.AMBROSE_SHEET);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.POLISHED_ALCHORUM_BLOCK);
            event.accept(ModBlocks.CHISELED_POLISHED_ALCHORUM);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
