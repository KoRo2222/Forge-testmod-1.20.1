package com.s2310036.testmod.datagen.client;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
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

        add("creativetabs.test_tab", "Test");

        addBlock(TestBlocks.GUARDMARINE, "Guardmarine");
        addBlock(TestBlocks.GUARDIAN_FOSSIL, "Guardian Fossil");
        addBlock(TestBlocks.PRISMARINE_ORE, "Prismarine Ore");
        addBlock(TestBlocks.DEEPSLATE_PRISMARINE_ORE, "Deepslate Prismarine Ore");
    }
}
