package com.s2310036.testmod.datagen.server.loot;

import com.s2310036.testmod.block.TestBlocks;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class TestBlockLootTables extends BlockLootSubProvider {
    protected TestBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(TestBlocks.GUARDMARINE.get());

        this.add(TestBlocks.GUARDIAN_FOSSIL.get(),
                block -> createCopperLikeOreDrops(TestBlocks.GUARDIAN_FOSSIL.get(), TestItems.GUARDIAN_FIN.get()));

        this.add(TestBlocks.PRISMARINE_ORE.get(),
                block -> this.createOreDrop(block, Items.PRISMARINE_SHARD));
        this.add(TestBlocks.DEEPSLATE_PRISMARINE_ORE.get(),
                block -> this.createOreDrop(block, Items.PRISMARINE_SHARD));

        this.dropSelf(TestBlocks.GUARDIAN_LOG.get());
        this.dropSelf(TestBlocks.STRIPPED_GUARDIAN_LOG.get());
        this.dropSelf(TestBlocks.GUARDIAN_WOOD.get());
        this.dropSelf(TestBlocks.STRIPPED_GUARDIAN_WOOD.get());
        // TODO:ドロップを苗木に変更
        this.add(TestBlocks.GUARDIAN_LEAVES.get(), block ->
                createLeavesDrops(block, TestBlocks.GUARDMARINE.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return TestBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;    }
}
