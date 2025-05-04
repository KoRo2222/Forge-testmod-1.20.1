package com.s2310036.testmod.item;

import com.s2310036.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.event.InputEvent;

public class TestItems {
    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    //レジストリにアイテムを追加
    public static final RegistryObject<Item> GUARDIAN_SCALES = ITEMS.register("guardian_scales", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventbus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventbus);
    }
}
