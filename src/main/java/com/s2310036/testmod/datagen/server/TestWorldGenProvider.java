package com.s2310036.testmod.datagen.server;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.worldgen.biome.TestBiomeModifiers;
import com.s2310036.testmod.worldgen.biome.TestBiomes;
import com.s2310036.testmod.worldgen.features.TestFeatures;
import com.s2310036.testmod.worldgen.placement.TestPlacement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class TestWorldGenProvider extends DatapackBuiltinEntriesProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TestFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, TestPlacement::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, TestBiomeModifiers::bootstrap)
            .add(Registries.BIOME, TestBiomes::bootstrap);

    public TestWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(TestMod.MOD_ID));
    }
}
