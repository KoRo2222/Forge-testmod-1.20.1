package com.s2310036.testmod.datagen.server.loot;

import com.s2310036.testmod.entity.TestEntities;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.LootingEnchantFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

import static net.minecraft.world.level.storage.loot.LootPool.lootPool;

public class CustomEntityLootProvider extends EntityLootSubProvider {
    protected CustomEntityLootProvider() {
        super(FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {
        // ヒツジスライムにアイテムドロップを追加
        this.add(TestEntities.GUARDIAN_ALPHA.get(), LootTable.lootTable().withPool(
                lootPool().setRolls(ConstantValue.exactly(1.0f))
                        // 羊毛をドロップ
                        .add(LootItem.lootTableItem(TestItems.GUARDIAN_FIN.get())
                                // １～３個ドロップ
                                .apply(SetItemCountFunction.setCount(
                                        UniformGenerator.between(1.0f, 3.0f)
                                ))
                                // ドロップ増加エンチャント付きの場合、レベルごとにドロップが１増える
                                .apply(LootingEnchantFunction.lootingMultiplier(
                                        UniformGenerator.between(0.0f, 1.0f))))));
    }

    @Override
    protected Stream<EntityType<?>> getKnownEntityTypes() {
        return TestEntities.ENTITY_TYPES.getEntries()
                .stream().map(RegistryObject::get);
    }
}