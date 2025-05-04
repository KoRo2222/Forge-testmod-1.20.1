package com.s2310036.testmod.datagen;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class TestBlockStateProvider extends BlockStateProvider {
    public TestBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(TestBlocks.GUARDMARINE);
        simpleBlockWithItem(TestBlocks.GUARDIAN_FOSSIL);
    }

    private void simpleBlockWithItem(RegistryObject<Block> block) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()));
    }
}
