package com.s2310036.testmod;

import com.mojang.logging.LogUtils;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.entity.TestEntities;
import com.s2310036.testmod.item.TestItems;
import com.s2310036.testmod.item.TestTabs;
import com.s2310036.testmod.loot.TestLootModifiers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TestMod.MOD_ID)
public class TestMod
{
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        // アイテムレジストリをイベントバスに登録
        TestItems.register(modEventBus);
        // クリエイティブタブレジストリをイベントバスに登録
        TestTabs.register(modEventBus);
        // ブロックレジストリをイベントバスに登録
        TestBlocks.register(modEventBus);
        // GlobalLootModifierレジストリをイベントバスに登録
        TestLootModifiers.register(modEventBus);
        // エンティティレジストリをイベントバス二登録
        TestEntities.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(TestItems.GUARDIAN_SCALES);
            event.accept(TestItems.GUARDIAN_FIN);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}
