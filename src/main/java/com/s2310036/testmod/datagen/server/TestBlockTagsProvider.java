package com.s2310036.testmod.datagen.server;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.tag.TestTags;
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
                        TestBlocks.GUARDIAN_FOSSIL.get(),
                        TestBlocks.PRISMARINE_ORE.get(),
                        TestBlocks.DEEPSLATE_PRISMARINE_ORE.get()
                );

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(TestBlocks.GUARDIAN_FOSSIL.get(),
                        TestBlocks.PRISMARINE_ORE.get(),
                        TestBlocks.DEEPSLATE_PRISMARINE_ORE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(TestBlocks.GUARDMARINE.get());

        this.tag(TestTags.Blocks.GUARDIAN_LOG)
                .add(TestBlocks.GUARDIAN_LOG.get())
                .add(TestBlocks.STRIPPED_GUARDIAN_LOG.get())
                .add(TestBlocks.GUARDIAN_WOOD.get())
                .add(TestBlocks.STRIPPED_GUARDIAN_WOOD.get());
        // 原木を使うレシピや、地面かどうかの判定処理に使われる
        this.tag(BlockTags.LOGS)
                .add(TestBlocks.GUARDIAN_LOG.get())
                .add(TestBlocks.STRIPPED_GUARDIAN_LOG.get());
        // 焼くと木炭になる
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(TestBlocks.GUARDIAN_LOG.get())
                .add(TestBlocks.STRIPPED_GUARDIAN_LOG.get())
                .add(TestBlocks.GUARDIAN_WOOD.get())
                .add(TestBlocks.STRIPPED_GUARDIAN_WOOD.get());
        // 地面かどうかの判定に使われたり、ハサミで回収できるようになったりする
        this.tag(BlockTags.LEAVES)
                .add(TestBlocks.GUARDIAN_LEAVES.get());
    }
}
