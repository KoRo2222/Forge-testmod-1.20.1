package com.s2310036.testmod.event;

import com.s2310036.testmod.TestMod;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID)
public class TestEvent {
    @SubscribeEvent
    public static void pickUpItemEvent(EntityItemPickupEvent event) {
        String itemName = event.getItem().getItem().getDisplayName().getString();
        event.getEntity().sendSystemMessage(
                Component.literal( itemName + "を拾った！"));
    }
}
