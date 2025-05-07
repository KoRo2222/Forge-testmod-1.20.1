package com.s2310036.testmod.event;

import com.s2310036.testmod.TestMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, value = Dist.CLIENT)
public class TestClientEvent {
    @SubscribeEvent
    public static void mouseDraggedEvent(ScreenEvent.MouseDragged event) {
        // System.out.println("Mouse Drugged");
    }
}
