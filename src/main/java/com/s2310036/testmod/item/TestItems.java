package com.s2310036.testmod.item;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.entity.TestEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.awt.*;
import java.awt.event.InputEvent;

public class TestItems {
    // レジストリを作成
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    //レジストリにアイテムを追加
    public static final RegistryObject<Item> GUARDIAN_SCALES = ITEMS.register("guardian_scales", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUARDIAN_FIN = ITEMS.register("guardian_fin", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GUARDIAN_ALPHA_SPAWN_EGG = ITEMS.register("guardian_alpha_spawn_egg",
            () -> new ForgeSpawnEggItem(TestEntities.GUARDIAN_ALPHA,
                    Color.CYAN.getRGB(), Color.ORANGE.getRGB(),
                    new Item.Properties()));

    public static final  RegistryObject<Item> GUARDIAN_EYE = ITEMS.register("guardian_eye", GuardianEye::new);

    public static void register(IEventBus eventbus) {
        // レジストリをイベントバスに登録
        ITEMS.register(eventbus);
    }
}
