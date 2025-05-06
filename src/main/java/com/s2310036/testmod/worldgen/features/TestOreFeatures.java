package com.s2310036.testmod.worldgen.features;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class TestOreFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRISMARINE_ORE_KEY =
            createKey("prismarine_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> prismarineOres = List.of(
                OreConfiguration.target(stone,
                        TestBlocks.PRISMARINE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslate,
                        TestBlocks.DEEPSLATE_PRISMARINE_ORE.get().defaultBlockState())
        );

        FeatureUtils.register(context, PRISMARINE_ORE_KEY, Feature.ORE, new OreConfiguration(prismarineOres, 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }
}
