package com.s2310036.testmod.item;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
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
                        pOutput.accept(TestItems.GUARDIAN_SCALES.get());
                        pOutput.accept(TestItems.GUARDIAN_FIN.get());
                        pOutput.accept(TestBlocks.GUARDMARINE.get());
                        pOutput.accept(TestBlocks.GUARDIAN_FOSSIL.get());
                        pOutput.accept(TestBlocks.PRISMARINE_ORE.get());
                        pOutput.accept(TestBlocks.DEEPSLATE_PRISMARINE_ORE.get());
                        pOutput.accept(TestBlocks.STRIPPED_GUARDIAN_LOG.get());
                        pOutput.accept(TestBlocks.STRIPPED_GUARDIAN_WOOD.get());
                        pOutput.accept(TestBlocks.GUARDIAN_LOG.get());
                        pOutput.accept(TestBlocks.GUARDIAN_WOOD.get());
                        pOutput.accept(TestBlocks.GUARDIAN_LEAVES.get());
                        pOutput.accept(TestBlocks.GUARDIAN_PLANKS.get());
                        pOutput.accept(TestBlocks.GUARDIAN_SLAB.get());
                        pOutput.accept(TestBlocks.GUARDIAN_STAIRS.get());
                        pOutput.accept(TestBlocks.GUARDIAN_FENCE.get());
                        pOutput.accept(TestBlocks.GUARDIAN_FENCE_GATE.get());
                        pOutput.accept(TestBlocks.GUARDIAN_DOOR.get());
                        pOutput.accept(TestBlocks.GUARDIAN_TRAPDOOR.get());
                        pOutput.accept(TestBlocks.GUARDIAN_BUTTON.get());
                        pOutput.accept(TestBlocks.GUARDIAN_PRESSURE_PLATE.get());
                        pOutput.accept(TestBlocks.GUARDIAN_SAPLING.get());
                        pOutput.accept(TestItems.GUARDIAN_ALPHA_SPAWN_EGG.get());
                    }))
                    .build());

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
