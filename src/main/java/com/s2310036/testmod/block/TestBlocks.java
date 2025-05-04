package com.s2310036.testmod.block;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.item.TestItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
