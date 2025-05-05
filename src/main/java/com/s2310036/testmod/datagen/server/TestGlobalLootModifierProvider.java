package com.s2310036.testmod.datagen.server;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.item.TestItems;
import com.s2310036.testmod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class TestGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public TestGlobalLootModifierProvider(PackOutput output) {
        super(output, TestMod.MOD_ID);
    }

    @Override
    protected void start() {
        // 難破船のチェスト
        add("gardian_scales_from_shipwreck_supply", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(fromNamespaceAndPath("minecraft","chests/shipwreck_supply")).build()
        }, TestItems.GUARDIAN_SCALES.get()));
        // ガーディアンのドロップ
        add("gardian_fin_from_guardian", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(fromNamespaceAndPath("minecraft","entities/guardian")).build(),
                LootItemRandomChanceCondition.randomChance(0.5f).build()
        }, TestItems.GUARDIAN_FIN.get()));
        // スニッファーの掘り出し物
        add("gardian_fossil_from_sniffer_digging", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(fromNamespaceAndPath("minecraft","gameplay/sniffer_digging")).build()
        }, TestItems.GUARDIAN_FIN.get()));
    }
}