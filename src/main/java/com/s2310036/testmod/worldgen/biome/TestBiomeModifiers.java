package com.s2310036.testmod.worldgen.biome;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.worldgen.placement.TestPlacement;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class TestBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_PRISMARINE_ORE =
            createKey("add_prismarine_ore");

    public static final ResourceKey<BiomeModifier> ADD_GUARDIAN_TREE =
            createKey("add_guardian_tree");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures =
                context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(ADD_PRISMARINE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(TestPlacement.ORE_PRISMARINE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        // 木が生成されるバイオームを設定
  //      context.register(ADD_GUARDIAN_TREE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
  //              biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
  //              HolderSet.direct(placedFeatures.getOrThrow(TestPlacement.GUARDIAN_TREE)),
  //              GenerationStep.Decoration.VEGETAL_DECORATION
  //      ));
    }

    private static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID, name));
    }
}
