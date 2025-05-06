package com.s2310036.testmod.datagen.client;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestBlockStateProvider extends BlockStateProvider {
    public TestBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(TestBlocks.GUARDMARINE);
        simpleBlockWithItem(TestBlocks.GUARDIAN_FOSSIL);
        simpleBlockWithItem(TestBlocks.PRISMARINE_ORE);
        simpleBlockWithItem(TestBlocks.DEEPSLATE_PRISMARINE_ORE);

        logBlock((RotatedPillarBlock) TestBlocks.GUARDIAN_LOG.get());
        logBlock((RotatedPillarBlock) TestBlocks.STRIPPED_GUARDIAN_LOG.get());
        axisBlock((RotatedPillarBlock) TestBlocks.GUARDIAN_WOOD.get(),
                blockTexture(TestBlocks.GUARDIAN_LOG.get()),
                blockTexture(TestBlocks.GUARDIAN_LOG.get()));
        axisBlock((RotatedPillarBlock) TestBlocks.STRIPPED_GUARDIAN_WOOD.get(),
                blockTexture(TestBlocks.STRIPPED_GUARDIAN_LOG.get()),
                blockTexture(TestBlocks.STRIPPED_GUARDIAN_LOG.get()));
        item(TestBlocks.GUARDIAN_LOG);
        item(TestBlocks.STRIPPED_GUARDIAN_LOG);
        item(TestBlocks.GUARDIAN_WOOD);
        item(TestBlocks.STRIPPED_GUARDIAN_WOOD);
        simpleLeaves(TestBlocks.GUARDIAN_LEAVES);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }

    // ブロック用のアイテムモデルを作成
    private void item(RegistryObject<Block> block) {
        simpleBlockItem(block.get(), new ModelFile.UncheckedModelFile(
                TestMod.MOD_ID + ":block/" +
                        ForgeRegistries.BLOCKS.getKey(block.get()).getPath()
        ));
    }

    // 呪われた葉ブロック
    private void cursedLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().cubeTop(
                ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                TextureMapping.getBlockTexture(block.get(), "_side"),
                TextureMapping.getBlockTexture(block.get(), "_top")
        ));
    }

    // 普通の葉ブロック
    private void simpleLeaves(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), models().singleTexture(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft","block/leaves"),
                "all", blockTexture(block.get())).renderType("cutout"));
    }
}
