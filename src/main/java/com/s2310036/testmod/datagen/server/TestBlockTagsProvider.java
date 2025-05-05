package com.s2310036.testmod.datagen.server;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TestBlockTagsProvider extends BlockTagsProvider {
    public TestBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(TestBlocks.GUARDMARINE.get(),
                        TestBlocks.GUARDIAN_FOSSIL.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TestBlocks.GUARDIAN_FOSSIL.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(TestBlocks.GUARDMARINE.get());
    }
}
