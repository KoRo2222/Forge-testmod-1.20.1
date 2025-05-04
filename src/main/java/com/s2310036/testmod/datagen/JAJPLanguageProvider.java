package com.s2310036.testmod.datagen;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class JAJPLanguageProvider extends LanguageProvider {
    public JAJPLanguageProvider(PackOutput output) {
        super(output, TestMod.MOD_ID, Locale.JAPAN.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(TestItems.GUARDIAN_SCALES, "ガーディアンのウロコ");
        addItem(TestItems.GUARDIAN_FIN, "ガーディアンのひれ");

        add("creativetabs.test_tab", "テスト");

        addBlock(TestBlocks.GUARDMARINE, "ガードマリン");
        addBlock(TestBlocks.GUARDIAN_FOSSIL, "ガーディアンの化石");
    }
}
