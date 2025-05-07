package com.s2310036.testmod.datagen.client;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestItemModelProvider extends ItemModelProvider {
    public TestItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(TestItems.GUARDIAN_SCALES.get());
        basicItem(TestItems.GUARDIAN_FIN.get());

        itemWithBlock(TestBlocks.GUARDIAN_SLAB);
        itemWithBlock(TestBlocks.GUARDIAN_STAIRS);
        itemWithBlock(TestBlocks.GUARDIAN_FENCE_GATE);
        itemWithBlock(TestBlocks.GUARDIAN_PRESSURE_PLATE);
        basicItem(TestBlocks.GUARDIAN_DOOR.get().asItem());
        trapdoor(TestBlocks.GUARDIAN_TRAPDOOR);
        fence(TestBlocks.GUARDIAN_FENCE, TestBlocks.GUARDIAN_PLANKS);
        button(TestBlocks.GUARDIAN_BUTTON, TestBlocks.GUARDIAN_PLANKS);

        sapling(TestBlocks.GUARDIAN_SAPLING);

        withExistingParent(TestItems.GUARDIAN_ALPHA_SPAWN_EGG.getId().getPath(),
                mcLoc("item/template_spawn_egg"));
    }

    public void itemWithBlock(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        TestMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void trapdoor(RegistryObject<Block> block) {
        this.getBuilder(ForgeRegistries.BLOCKS.getKey(block.get()).getPath())
                .parent(new ModelFile.UncheckedModelFile(
                        TestMod.MOD_ID + ":block/" +
                                ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
    public void fence(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void button(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void sapling(RegistryObject<Block> block) {
        this.withExistingParent(block.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath("minecraft","item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TestMod.MOD_ID,"block/" + block.getId().getPath()));
    }
}
