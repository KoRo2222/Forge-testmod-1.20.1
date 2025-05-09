package com.s2310036.testmod.datagen.client;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.entity.TestEntities;
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

        add("creativetabs.test_item_tab", "テストアイテム");
        add("creativetabs.test_block_tab", "テストブロック");

        addBlock(TestBlocks.GUARDMARINE, "ガードマリン");
        addBlock(TestBlocks.GUARDIAN_FOSSIL, "ガーディアンの化石");
        addBlock(TestBlocks.PRISMARINE_ORE, "プリズマリン鉱石");
        addBlock(TestBlocks.DEEPSLATE_PRISMARINE_ORE, "深層プリズマリン鉱石");
        addBlock(TestBlocks.GUARDIAN_LOG, "ガーディアンの原木");
        addBlock(TestBlocks.STRIPPED_GUARDIAN_LOG, "樹皮を剥いだガーディアンの原木");
        addBlock(TestBlocks.GUARDIAN_WOOD, "ガーディアンの木");
        addBlock(TestBlocks.STRIPPED_GUARDIAN_WOOD, "樹皮を剥いだガーディアンの木");
        addBlock(TestBlocks.GUARDIAN_LEAVES, "ガーディアンの葉");

        addBlock(TestBlocks.GUARDIAN_PLANKS, "ガーディアンの板材");
        addBlock(TestBlocks.GUARDIAN_SLAB, "ガーディアンのハーフブロック");
        addBlock(TestBlocks.GUARDIAN_STAIRS, "ガーディアンの階段");
        addBlock(TestBlocks.GUARDIAN_FENCE, "ガーディアンのフェンス");
        addBlock(TestBlocks.GUARDIAN_FENCE_GATE, "ガーディアンのフェンスゲート");
        addBlock(TestBlocks.GUARDIAN_DOOR, "ガーディアンのドア");
        addBlock(TestBlocks.GUARDIAN_TRAPDOOR, "ガーディアンのトラップドア");
        addBlock(TestBlocks.GUARDIAN_BUTTON, "ガーディアンのボタン");
        addBlock(TestBlocks.GUARDIAN_PRESSURE_PLATE, "ガーディアンの感圧板");

        addBlock(TestBlocks.GUARDIAN_SAPLING, "ガーディアンの苗木");

        addEntityType(TestEntities.GUARDIAN_ALPHA, "ガーディアンアルファ");

        addItem(TestItems.GUARDIAN_ALPHA_SPAWN_EGG, "ガーディアンアルファのスポーンエッグ");

        addItem(TestItems.GUARDIAN_EYE, "ガーディアンの目");
    }
}
