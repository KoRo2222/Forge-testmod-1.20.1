package com.s2310036.testmod.block;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.block.custom.TestLeavesBlock;
import com.s2310036.testmod.block.custom.TestLogBlock;
import com.s2310036.testmod.block.custom.TestStrippableLogBlock;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

    private static <T extends Block> RegistryObject<T> registerBlockItem(String name,
                                                                         Supplier<T> supplier) {
        RegistryObject<T> block = BLOCKS.register(name, supplier);
        TestItems.ITEMS.register(name,
                () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
