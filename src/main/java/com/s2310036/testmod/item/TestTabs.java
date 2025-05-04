package com.s2310036.testmod.item;

import com.s2310036.testmod.TestMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;

public class TestTabs {
    // レジストリを作成
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);

    // レジストリにタブを登録
    public static final RegistryObject<CreativeModeTab> TEST_TAB = TABS.register("test_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.test_tab"))
                    .icon(TestItems.GUARDIAN_FIN.get()::getDefaultInstance)
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(TestItems.GUARDIAN_FIN.get());
                        pOutput.accept(TestItems.GUARDIAN_SCALES.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
