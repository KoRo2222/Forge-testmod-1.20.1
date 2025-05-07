package com.s2310036.testmod.block;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.custom.TestLeavesBlock;
import com.s2310036.testmod.block.custom.TestLogBlock;
import com.s2310036.testmod.block.custom.TestStrippableLogBlock;
import com.s2310036.testmod.item.TestItems;
import com.s2310036.testmod.worldgen.tree.GuardianTreeGrower;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TestBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> GUARDMARINE = registerBlockItem("guardmarine",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GUARDIAN_FOSSIL = registerBlockItem("guardian_fossil",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> PRISMARINE_ORE = registerBlockItem("prismarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_PRISMARINE_ORE = registerBlockItem(
            "deepslate_prismarine_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final RegistryObject<Block> STRIPPED_GUARDIAN_LOG = registerBlockItem("stripped_guardian_log",
            () -> new TestLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block> STRIPPED_GUARDIAN_WOOD = registerBlockItem("stripped_guardian_wood",
            () -> new TestLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block> GUARDIAN_LOG = registerBlockItem("guardian_log",
            () -> new TestStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).sound(SoundType.NETHER_BRICKS),
                    STRIPPED_GUARDIAN_LOG));

    public static final RegistryObject<Block> GUARDIAN_WOOD = registerBlockItem("guardian_wood",
            () -> new TestStrippableLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.NETHER_BRICKS),
                    STRIPPED_GUARDIAN_WOOD));

    public static final RegistryObject<Block> GUARDIAN_LEAVES = registerBlockItem("guardian_leaves",
            () -> new TestLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));

    // 板材
    public static final RegistryObject<Block> GUARDIAN_PLANKS = registerBlockItem("guardian_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    // ハーフブロック
    public static final RegistryObject<Block> GUARDIAN_SLAB = registerBlockItem("guardian_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    // 階段
    public static final RegistryObject<Block> GUARDIAN_STAIRS = registerBlockItem("guardian_stairs",
            () -> new StairBlock(() -> TestBlocks.GUARDIAN_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    // フェンス
    public static final RegistryObject<Block> GUARDIAN_FENCE = registerBlockItem("guardian_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    // フェンスゲート
    public static final RegistryObject<Block> GUARDIAN_FENCE_GATE = registerBlockItem("guardian_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    SoundEvents.BAMBOO_WOOD_FENCE_GATE_OPEN, SoundEvents.BAMBOO_WOOD_FENCE_GATE_CLOSE));
    // ドア
    public static final RegistryObject<Block> GUARDIAN_DOOR = registerBlockItem("guardian_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));
    // トラップドア
    public static final RegistryObject<Block> GUARDIAN_TRAPDOOR = registerBlockItem("guardian_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).noCollission(),
                    BlockSetType.IRON));
    // ボタン
    public static final RegistryObject<Block> GUARDIAN_BUTTON = registerBlockItem("guardian_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK, 30, true));
    // 感圧板
    public static final RegistryObject<Block> GUARDIAN_PRESSURE_PLATE = registerBlockItem("guardian_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS),
                    BlockSetType.OAK));

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        TestItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
    // 苗木
    public static final RegistryObject<Block> GUARDIAN_SAPLING = registerBlockItem("guardian_sapling",
            () -> new SaplingBlock(new GuardianTreeGrower(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
