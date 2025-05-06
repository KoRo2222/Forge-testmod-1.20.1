package com.s2310036.testmod.datagen;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.datagen.client.ENUSLanguageProvider;
import com.s2310036.testmod.datagen.client.JAJPLanguageProvider;
import com.s2310036.testmod.datagen.client.TestBlockStateProvider;
import com.s2310036.testmod.datagen.client.TestItemModelProvider;
import com.s2310036.testmod.datagen.server.TestBlockTagsProvider;
import com.s2310036.testmod.datagen.server.TestGlobalLootModifierProvider;
import com.s2310036.testmod.datagen.server.TestRecipeProvider;
import com.s2310036.testmod.datagen.server.TestWorldGenProvider;
import com.s2310036.testmod.datagen.server.loot.TestLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookUpProvider = event.getLookupProvider();

        // アイテム用のモデルファイルの生成
        generator.addProvider(event.includeClient(), new TestItemModelProvider(packOutput
                , existingFileHelper));
        // ブロック用のモデルファイルの生成
        generator.addProvider(event.includeClient(), new TestBlockStateProvider(packOutput
                , existingFileHelper));
        // 言語ファイル（英語）
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        // 言語ファイル（日本語）
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        // レシピ
        generator.addProvider(event.includeServer(), new TestRecipeProvider(packOutput));
        // ルートテーブル
        generator.addProvider(event.includeServer(), TestLootTables.create(packOutput));
        // ブロックタグ
        generator.addProvider(event.includeServer(), new TestBlockTagsProvider(packOutput,
                lookUpProvider, existingFileHelper));
        // GlobalLootModifier
        generator.addProvider(event.includeServer(),
                new TestGlobalLootModifierProvider(packOutput));
        // WorldGen
        generator.addProvider(event.includeServer(),
                new TestWorldGenProvider(packOutput, lookUpProvider));
    }
}
