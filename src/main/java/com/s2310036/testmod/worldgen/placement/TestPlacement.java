package com.s2310036.testmod.worldgen.placement;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.worldgen.features.TestFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class TestPlacement {
    public static final ResourceKey<PlacedFeature> ORE_PRISMARINE =
            createKey("ore_prismarine");

    public static final ResourceKey<PlacedFeature> GUARDIAN_TREE =
            createKey("guardian_tree");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        // 鉱石の配置情報を設定
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE);

        Object IntroductionOreFeatures;
        PlacementUtils.register(context, ORE_PRISMARINE,
                configuredFeatures.getOrThrow(TestFeatures.PRISMARINE_ORE_KEY),
                commonOrePlacement(90,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(112))));
        PlacementUtils.register(context, GUARDIAN_TREE,
                configuredFeatures.getOrThrow(TestFeatures.GUARDIAN_TREE_KEY),
                VegetationPlacements.treePlacement(
                        PlacementUtils.countExtra(10, 0.1f, 1),
                        TestBlocks.GUARDIAN_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE,
                ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }

    private static List<PlacementModifier> orePlacement(PlacementModifier pCountPlacement, PlacementModifier pHeightRange) {
        return List.of(pCountPlacement, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    private static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}
