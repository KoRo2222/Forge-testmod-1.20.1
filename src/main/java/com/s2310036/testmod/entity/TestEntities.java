package com.s2310036.testmod.entity;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.entity.custom.GuardianAlpha;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TestEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TestMod.MOD_ID);

    public static final RegistryObject<EntityType<GuardianAlpha>> GUARDIAN_ALPHA =
            ENTITY_TYPES.register("guardian_alpha", () -> EntityType.Builder.of(
                    GuardianAlpha::new, MobCategory.MONSTER).build("guardian_alpha"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
