package com.s2310036.testmod.datagen.client;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.entity.TestEntities;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, TestMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(TestItems.GUARDIAN_SCALES, "Guardian Scales");
        addItem(TestItems.GUARDIAN_FIN, "Guardian Fin");

        add("creativetabs.test_item_tab", "Test Items");
        add("creativetabs.test_block_tab", "Test Blocks");

        addBlock(TestBlocks.GUARDMARINE, "Guardmarine");
        addBlock(TestBlocks.GUARDIAN_FOSSIL, "Guardian Fossil");
        addBlock(TestBlocks.PRISMARINE_ORE, "Prismarine Ore");
        addBlock(TestBlocks.DEEPSLATE_PRISMARINE_ORE, "Deepslate Prismarine Ore");
        addBlock(TestBlocks.GUARDIAN_LOG, "Guardian Log");
        addBlock(TestBlocks.STRIPPED_GUARDIAN_LOG, "Stripped Guardian Log");
        addBlock(TestBlocks.GUARDIAN_WOOD, "Guardian Wood");
        addBlock(TestBlocks.STRIPPED_GUARDIAN_WOOD, "Stripped Guardian Wood");
        addBlock(TestBlocks.GUARDIAN_LEAVES, "Guardian Leaves");

        addBlock(TestBlocks.GUARDIAN_PLANKS, "Guardian Planks");
        addBlock(TestBlocks.GUARDIAN_SLAB, "Guardian Slab");
        addBlock(TestBlocks.GUARDIAN_STAIRS, "Guardian Stairs");
        addBlock(TestBlocks.GUARDIAN_FENCE, "Guardian Fence");
        addBlock(TestBlocks.GUARDIAN_FENCE_GATE, "Guardian Fence Gate");
        addBlock(TestBlocks.GUARDIAN_DOOR, "Guardian Door");
        addBlock(TestBlocks.GUARDIAN_TRAPDOOR, "Guardian Trapdoor");
        addBlock(TestBlocks.GUARDIAN_BUTTON, "Guardian Button");
        addBlock(TestBlocks.GUARDIAN_PRESSURE_PLATE, "Guardian Pressure Plate");

        addBlock(TestBlocks.GUARDIAN_SAPLING, "Guardian Sapling");

        addEntityType(TestEntities.GUARDIAN_ALPHA, "Guardian Alpha");

        addItem(TestItems.GUARDIAN_ALPHA_SPAWN_EGG, "Guardian Alpha Spawn Egg");

        addItem(TestItems.GUARDIAN_EYE, "Guardian Eye");
    }
}
