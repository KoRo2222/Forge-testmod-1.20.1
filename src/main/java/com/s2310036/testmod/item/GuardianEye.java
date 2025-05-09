package com.s2310036.testmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class GuardianEye extends Item {
    public GuardianEye() {
        super(new Properties()
                .fireResistant() // 燃えないようになる
                .craftRemainder(TestItems.GUARDIAN_SCALES.get()) // クラフトしたときアイテムが返ってくる（例: バケツ）
                .rarity(Rarity.EPIC) // 名前の色が変わる
                .stacksTo(16) // 最大スタック数
        );
    }
}
