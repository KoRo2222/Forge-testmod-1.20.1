package com.s2310036.testmod.event;

import com.s2310036.testmod.TestMod;
import com.s2310036.testmod.entity.TestEntities;
import com.s2310036.testmod.entity.custom.GuardianAlpha;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModBusEvent {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(TestEntities.GUARDIAN_ALPHA.get(), GuardianAlpha.createAttributes().build());
    }
}
